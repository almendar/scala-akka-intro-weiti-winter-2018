package pl.tk.intro.akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props, Terminated, Timers}
import akka.util.Timeout

class Supervisor extends Actor {

  import akka.actor.OneForOneStrategy
  import akka.actor.SupervisorStrategy._

  import scala.concurrent.duration._

  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 3, withinTimeRange = 1 minute) {
      case _: ArithmeticException ⇒ Resume
      case _: NullPointerException ⇒ Restart
      case _: IllegalArgumentException ⇒ Stop
      case _: Exception ⇒ Escalate
    }

  def receive = {
    case p: Props ⇒ sender() ! context.actorOf(p)
  }
}


class Child extends Actor {
  var state = 1

  def receive = {
    case ex: Exception ⇒ throw ex
    case x: Int ⇒ state = x
    case "get" ⇒ sender() ! state
  }
}

class Driver(supervisor: ActorRef) extends Actor  with Timers {
  supervisor ! Props(classOf[Child])

  override def receive: Receive = {
    case ac: ActorRef =>
      context.watch(ac)
      ac ! 66
      ac ! new IllegalArgumentException()
      ac ! "get"
      context.setReceiveTimeout(100 milliseconds)
    case nr: Int => println(nr)
    case Terminated(x) => println("Nie dostnaę oddpwoiedzi")


  }
}

object SuperVision extends App {
  implicit val system = ActorSystem("system")
  val supervisor = system.actorOf(Props[Supervisor])
  val driver = system.actorOf(Props(classOf[Driver], supervisor))
}