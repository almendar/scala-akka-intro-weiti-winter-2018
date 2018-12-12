package pl.tk.intro.akka

import akka.actor.{Actor, ActorSystem, PoisonPill, Props, Terminated}

import scala.concurrent.duration._
import scala.language.postfixOps

case object Ping

case object Pong


class Pinger extends Actor {
  var countDown = 100

  def receive = {
    case Pong ⇒
      println(s"${self.path} received pong, count down $countDown")
      if (countDown > 0) {
        countDown -= 1
        sender() ! Ping
      } else {
        sender() ! PoisonPill
        self ! PoisonPill
      }
  }
}

object Ponger {
  def createion(name: String): Props = Props.apply(classOf[Ponger], name)
}

class Ponger extends Actor {
  val pinger = context.actorOf(Props[Pinger], "Pinger")
  context.watch(pinger)

  def receive = {
    case Ping ⇒
      println(s"${self.path} received ping")
      pinger ! Pong
    case Terminated(`pinger`) =>
      println(s"${self.path} Pinger is dead, I'm going to die also. Bye!")
      self ! PoisonPill
      context.system.terminate()
  }
}

object PingPongMain extends App {
  val system = ActorSystem("pingpong")

  val ponger = system.actorOf(Props(classOf[Ponger]), "ponger")

  import system.dispatcher

  system.scheduler.scheduleOnce(500 millis) {
    ponger.!(Ping)
  }

}