package org.raymond.test.common

class Common {
  val name = "common"
  def sayName() = {
    println(name)
  }
}

object Common {
  def main(argStrings: Array[String]) {
    println("Hello common")
  }
}
