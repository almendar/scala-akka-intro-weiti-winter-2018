# Scala and AKKA intro for PW EiTI Winter 2018

## Scala
 - Hello world
   - imports
 - Testing
   - http://www.scalatest.org
- class
    - methods
      - default values
    - constructor
- case class
- object
  - functions
- fields 
   - val
   - var
- trait
- String
  - interpolation
  - multiplies
  - stripmargin
- Generics
- case object
- Option
- Pattern matching
- Try
- sealed traits
- collections
- for-comprehension
- Future
- implicits
  - implicit arguments
  - implicit class
  - implicit conversion

## SBT
   - build definition
   - dependencies
   - run
   - runMain
   - test
   - testQuick
   - testOnly
   - ~

## Akka
 - Actor creation
 [Ping-Pong](https://doc.akka.io/docs/akka/current/actors.html#here-is-another-example-that-you-can-edit-and-run-in-the-browser-)
    - Props
    - Actor hierarchy
  - Actor lifecycle
  - Death watch
  - ask, pipeTo
  - Receive timeout
    `context.setReceiveTimeout(100 milliseconds)`
  - [Supervision](https://doc.akka.io/docs/akka/current/fault-tolerance.html#test-application)
