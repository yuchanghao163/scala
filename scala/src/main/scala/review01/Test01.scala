package review01

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.util.control.Breaks

object Test01 {
  def main(args: Array[String]): Unit = {

    Breaks.breakable(
      for (elem <- 1 to 5) {
        if(elem==4){
          Breaks.break()
        }
        println(elem)
      }
    )
    }
  }


object Test02 {
  def main(args: Array[String]): Unit = {
//异常的处理和循环中断
      Breaks.breakable(
        for (elem <- 1 to 5) {
          try {
            if (elem == 4) {
              throw new RuntimeException
            }
          } catch {
            case e => println("报错啦")
              Breaks.break()
          }
          println(elem)
        }
      )

  }
  }

object Test03 {
  def main(args: Array[String]): Unit = {
    val l1 = ListBuffer(1,2,3)



    val arr = ArrayBuffer(1,2,3)

    l1 += 4              //l1 = l1 + 4
    arr += 4
    println(arr)
    println(l1)

    var l2= Nil
    val nil: List[Int] = Nil :+ 2
    println(nil)

    val set1: Set[Int] = Set(1)
    println(set1 + 2)

    //flatten扁平化: 将嵌套集合的集合，打散，不会去重
    val ll2: List[List[Int]] = List(List(1, 1, 0), List(2, 1, 0), List(3, 1, 0))
    println(ll2.flatten)

  }
  }


