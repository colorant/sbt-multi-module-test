package org.raymond.test.foo

import org.raymond.test.core.Core
import org.raymond.test.common.Common

class Foo {
  val name = "foo"
  def sayName = {
    val c = new Core
    c.sayName
    println(name)
  }

  def callCommon = {
    val c = new Common
    c.sayName()
  }
}

object Foo {
  def main(argStrings: Array[String]) {
    val f = new Foo
    f.sayName
    f.callCommon
  }
}
