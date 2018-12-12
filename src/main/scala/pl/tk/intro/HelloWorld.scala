package pl.tk.intro

object HelloWorld extends App {
  def helloText(name: String) = "Hello " + name + "!"
  println(helloText("world"))
}
