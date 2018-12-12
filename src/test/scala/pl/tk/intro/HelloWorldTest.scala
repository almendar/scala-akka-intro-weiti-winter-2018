package pl.tk.intro

import org.scalatest.FunSuite

class HelloWorldTest extends FunSuite {
  test("Testing hello text") {
    assertResult("Hello world!") {
      HelloWorld.helloText("world")
    }
  }
}
