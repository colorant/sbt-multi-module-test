package org.raymond.test.bar

import org.raymond.test.core.Core
import org.raymond.test.common.Common

class Bar {
  val name = "bar"
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

object Bar {
  def main(argStrings: Array[String]) {
    val f = new Bar
    f.sayName
    f.callCommon
  }
}
