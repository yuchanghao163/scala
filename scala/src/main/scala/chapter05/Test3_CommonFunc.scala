package chapter05

object Test3_CommonFunc {
  def main(args: Array[String]): Unit = {

    val l1 = List(2,34,567,1)
//  （1）获取集合长度
    println(l1.length)
//  （2）获取集合大小
    println(l1.size)
//  （3）循环遍历
    for (elem <- l1) {
      println(elem)
    }
    println("==========")
    //  （4）迭代器
    val iterator: Iterator[Int] = l1.iterator
    while (iterator.hasNext){
      println(iterator.next())
    }
    println("==========")
//  （5）生成字符串:
    println(l1.toString())
    val str: String = l1.mkString(",") //返回一个集合字符串，元素之间用  , 分开
    println(str)
    val str1: String = l1.mkString("{", ",", "}")  //可以写字符串的开头和结尾
    println(str1)
//  （6）是否包含
    println(l1.contains(567))
  }
}






object Test3_1CommonFunc{
  def main(args: Array[String]): Unit = {
    val l1 = List(2,34,567,1)
    println(l1)
//    （1）获取集合的头:返回的是第一个元素
    println(l1.head)

//    （2） tail方法，返回去除了第一个元素的新集合
    println(l1.tail)

//    （3）获取集合最后一个数据
    println(l1.last)

//    （4）init方法，返回去除最后一个元素后的新集合
    println(l1.init)

//    （5）反转
    println(l1.reverse)

//    （6）take 和 takeRight
    println(l1.take(2)) //返回前两个元素组成的新集合
    println(l1.takeRight(3))//返回后三个元素组成的新集合

//    （7）drop 和 dropRight
    println(l1.drop(2))//返回去除前两个元素 后组成的新集合
    println(l1.dropRight(2))//返回去除 后两个元素 后组成的新集合

//    （8）union并集:将两个集合合并成一个集合，不去重
    val l2 = List(1,2,9,8,7)
    println(l1.union(l2))

//    （9）intersect交集
    println(l1.intersect(l2))

//    （10）diff差集:  l1.diff(l2)    l1去除交集元素后，返回一个新集合
    println(l1.diff(l2))

//    （11）拉链:l1的第一个元素2和l2的第一个1元素对应 如下对应。如果l1和l2长度不一样，则多余的不要
    println(l1.zip(l2))//List((2,1), (34,2), (567,9), (1,8))

//    （12）滑窗
    println("==========")
    val l3 = List(1,2,3,4,5,6,7)
    //每三个元素作为一个集合，默认每次向右滑动一格。获得的集合存在Iterator中。
    val iterator1: Iterator[List[Int]] = l3.sliding(3)
    iterator1.foreach(println)//遍历打印集合


    println("==========")
    //设置集合长度为3，滑动步长为3个元素，如果最后最后一个不够3，也继续返回，如最后只剩一个元素，则返回 List(7)
    val iterator2: Iterator[List[Int]] = l3.sliding(3,3)
    iterator2.foreach(println)

  }
}






