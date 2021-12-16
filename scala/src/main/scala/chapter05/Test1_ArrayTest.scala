package chapter05

import scala.collection.mutable

//建议：在操作集合的时候，不可变用符号，可变用方法
object ArrayTest_1 {
  def main(args: Array[String]): Unit = {
    //创建数组的两种方式:不可变数组
    val arr2: Array[Int] = new Array[Int](5)
    val arr1: Array[Int] = Array(1,2,3)//  本质是调用apply方法
    //val ints: Array[Int] = Array.apply(1,2,3)

    println("for========")

    //for循环遍历数组
    for (elem <- arr1) {
      println(elem)
    }

    println("iterator========")
    //迭代器遍历数组
    val iterator: Iterator[Int] = arr2.iterator
    while (iterator.hasNext){
      println(iterator.next())
    }

    println("foreach========")

    //foreach()遍历数组,参数可以是一个匿名函数
    arr1.foreach(i => {println(i)})//花括号可省略

    println("foreach(myprint)========")
    def myprint(i:Int)=println(s"第 $i 个")
    arr1.foreach(myprint)
    arr1.foreach((i:Int) => println(2*i))    //(f:Int) => U  这个是匿名函数



    //foreach()直接调用println方法,不是println()  Scala中()代表构造器
    println("foreach(println)========")
    arr1.foreach(println)


//    不可变数组不会将元素添加到原数组，只能通过.var  返回新数组
    //添加数组元素，添加后不是原来的数组
    println("========")
    val arr1_1: Array[Int] = arr1 :+ 4    //数组右边添加
    arr1_1.foreach(println)
    println("========")
    val arr1_2: Array[Int] = 5 +: arr1    //数组左边添加
    arr1_2.foreach(println)

    //修改数组元素,修改后还是原来的数组
    println("========")
    arr1(0)=6
    arr1.foreach(println)

  }
}



object ArrayTest_2{
  def main(args: Array[String]): Unit = {
    //可变数组需要导包
    import scala.collection.mutable.ArrayBuffer


    val buf2: ArrayBuffer[Int] = new ArrayBuffer[Int](4)
    val buf1: ArrayBuffer[Int] = ArrayBuffer(1,2,3)

//    可变数组的特殊遍历打印
      println(buf1)   //ArrayBuffer(1, 2, 3)

//    可变数组添加元素推荐用方法
      buf1.append(4)
      println(buf1)

    //可变数组和不可变数组的转换
    val arr1: Array[Int] = Array(1,2,3)

    val buffer: mutable.Buffer[Int] = arr1.toBuffer
    val array: Array[Int] = buf1.toArray

    array.foreach(println)
    println(buffer)
  }
}



object ArrayTest_3 {
  def main(args: Array[String]): Unit = {
    //二维数组：val arr = Array.ofDim[Double](3,4)    3行4列
    val arr3: Array[Array[Int]] = Array.ofDim[Int](3, 3)

    //赋值
    arr3(0)(0) = 1
    arr3(0)(1) = 2
    arr3(0)(2) = 3

    arr3(1)(0) = 2
    arr3(2)(0) = 3
    //遍历
    for (elems <- arr3) {
      for (elem <- elems) {
        print(elem +"\t")
      }
      println()
    }

    println("==========")
    val arr4: Array[Array[Int]] = new Array[Array[Int]](3)
    arr4(0)=Array(0,1,2)
    arr4(1)=Array(0,1,2)
    arr4(2)=Array(0,1,2)
    for (elems <- arr4) {
      for (elem <- elems) {
        print(elem +"\t")
      }
      println()
    }
  }
}