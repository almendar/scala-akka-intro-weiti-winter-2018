package pl.tk.intro

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object Greeter {
  val DefaultValue = "world"
}


trait GreeterLike {
  def helloText: String
}

trait NameProvider[A] {
  def name: String
}


class Greeter(name: String)
  extends GreeterLike {

  def fromJavaWorld: Greeter = null


  override def helloText = "Hello " + name + "!"

}


case object Foo

case class Greeter1(name: String, surname: String) extends GreeterLike {
  override def helloText =
    s"""Hello $name!
       |
       |
       |
       |$Foo
       |sdflknsdokfsad
       |fasd
       |f
       |asdf
       |asdf
       |asdf
       |gsa
       |dgsd
       |
     """.stripMargin
}

object HelloWorld extends App {

  def foo(b: Int, c: Int, a: Int = 2) = ???

  val greeter = new Greeter("")

  val greeter1 = new Greeter1("tomek", "x")
  greeter1.name

  greeter1.copy(surname = "y")
  println(greeter.helloText)
  2 + 2

  val maybeInt: Option[Int] = Some(2)
  val maybeInt1: Option[Int] = None

  val p = 2 + maybeInt.getOrElse(3)
  val p1 = 2 + maybeInt1.getOrElse(3)
  println(s"$p $p1")

  maybeInt match {
    case Some(x) => println(2 + x)
    case None => println(2 + 3)
  }

  case class Fer(a: Int, b: String)

  case class Bar(fer: Fer, a: String)

  val a: Bar = Bar(
    Fer(3, "sfdf"),
    "asd")

  a match {
    case y: Bar => y.fer.b
  }

  //  Option
  //     Some
  //     IDontKnow
  //     None
  //
  //  Try
  //     Success
  //     Failure


  Try(throw new RuntimeException("Booo")) match {
    case Success(value) => println(value)
    case Failure(exception) => exception.printStackTrace()
  }


  sealed trait MyOption[A]

  case class MySome[A](value: A) extends MyOption[A]

  case object MyNone extends MyOption[Nothing]

  val fg: MyOption[Int] = MySome(3)

  fg match {
    case x: MySome[Int] => println(x)
  }

  val l1: List[String] = List("dsad", "sfasf")

  l1 match {
    case (head: String) :: (tail: List[String]) =>
  }

  val tupla: (Int, String) = 2 -> "String"
  val tupla1: Tuple2[Int, String] = 2 -> "String"
  Map(2 -> "String", 3 -> "sdfnsdf")
  Set("asfasf", "asfasfasf", "DSfsdf")

  // A => B
  // Int => String
  List(1, 2, 3, 4).map(x => x.toString)
  println(List(1, 2, 3, 4).map(x => List.fill(x)(x)))
  //Int => List[String]
  println(List(1, 2, 3, 4).flatMap(x => List.fill(x)(x)))

//  val g: Option[Int] = for {
//    maybe1 <- Option(23)
//    maybe2 <- None
//    maybe3 <- Option(54)
//  } yield maybe1 + maybe2 + maybe3

//  val g1: Try[Int] = for {
//    maybe1 <- Try(23)
//    maybe2 <- Failure(new RuntimeException)
//    maybe3 <- Try(54)
//  } yield maybe1 + maybe2 + maybe3

//  import scala.concurrent.
//  val g2: Future[Int] = for {
//    maybe1 <- Future.successful(23)
//    maybe2 <- Future(new RuntimeException)
//    maybe3 <- Future(54)
//  } yield maybe1 + maybe2 + maybe3


//  Future()
//  def fun(implicit a:Int) = a+2
//  implicit val g:Int = 3
//  fun()


}
