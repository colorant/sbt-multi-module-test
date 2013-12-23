package org.raymond.test.common
import org.raymond.test.core.Core

class Common {
  val name = "common"
  def sayName() = {
    val c = new Core
    c.sayName
    println(name)
  }
}

object Common {
  def main(argStrings: Array[String]) {
    println("Hello common")
  }
}
