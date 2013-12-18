package org.raymond.test.foo

import org.raymond.test.core.Core

class Foo {
  val name = "foo"
  def sayName = {
    val c = new Core
    c.sayName
    println(name)
  }
}

object Foo {
  def main(argStrings: Array[String]) {
    val f = new Foo
    f.sayName
  }
}
