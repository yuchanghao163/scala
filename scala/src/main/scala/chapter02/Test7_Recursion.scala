package chapter02

import scala.annotation.tailrec

object Test7_Recursion {
  def main(args: Array[String]): Unit = {

    //递归求  2+3+4

    def f1(i:Int):Int=if(i==2) 2 else i+f1(i-1)

    println(f1(4))

    //尾递归优化
    //求2+3+4

    @tailrec
    def f2(i:Int,res:Int =2):Int ={
      if(i==2) res
      else f2(i-1,i+res)
    }

    println(f2(4))




  }

}
