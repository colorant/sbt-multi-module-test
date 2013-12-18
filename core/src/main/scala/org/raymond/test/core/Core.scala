package org.raymond.test.core

class Core {
  val name = "core"
  def sayName() = {
    println(name)
  }
}

object Core {
  def main(argStrings: Array[String]) {
    println("Hello core")
  }
}
