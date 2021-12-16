package chapter01

import scala.io.StdIn

object Test3_StdInTest {
  def main(args: Array[String]): Unit = {
    println("你好%s","余长浩")

      var s1 = StdIn.readLine("欢迎%s来到尚硅谷\n","余长浩")
    println(s1)
    println("请继续输入")
      var s2 = StdIn.readLine()
    println(s2)

  }
}
