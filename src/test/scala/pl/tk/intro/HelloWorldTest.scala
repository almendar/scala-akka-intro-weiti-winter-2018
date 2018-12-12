package pl.tk.intro

import org.scalatest.FunSuite

class HelloWorldTest extends FunSuite {
  test("Testing hello text") {
    assertResult("Hello world!") {
      val g = new Greeter("world")
      g.helloText
    }
  }
}
