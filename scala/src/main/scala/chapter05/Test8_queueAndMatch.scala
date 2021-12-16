package chapter05

import scala.collection.mutable

object Test8_queueAndMatch {
  def main(args: Array[String]): Unit = {
    val q1 = new mutable.Queue[Int]()

    //进队
    q1.enqueue(1,2,3,4)
    println(q1)

    //出队:去掉第一个，然后返回剩下的队列
    q1.dequeue()
    println(q1)




    //并行集合:   l1.par.foreach(print)
    val range: Range.Inclusive = (1 to 20)
    range.foreach(println)

    range.par.foreach(println)

    val l1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    l1.foreach(print)
    println("======")
    l1.par.foreach(print)
  }
}
