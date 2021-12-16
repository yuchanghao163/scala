package chapter05

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object CollectionTest_2 {
  def main(args: Array[String]): Unit = {
    //      Scala的集合有三大类：序列Seq、集Set、映射Map
    //（1）List:不可变集合。listBuffer可变集合
//    （2）创建一个List（数据有顺序，可重复）
          val l1: List[Int] = List(1,2,3,1)

//    （3）List增加数据
          val l1_1: List[Int] = l1 :+ 4    //右添加, 注意：没有 l1 :: 4
          val l1_2: List[Int] = 5 :: l1    //左添加
//    （4）遍历List
          l1_2.foreach(println)

//    （5）集合间合并：将一个整体拆成一个一个的个体，称为扁平化,就是将两个集合合成一个,不去重
        val l1_3: List[Int] = l1_1 ::: l1_2
        println(l1_3)
//    （6）获取索引位置的元素，索引从0开始
        val i: Int = l1_3(3)
        println(i)
//    （7）空集合Nil ：就是将 1 ，2 ，3 添加到空的集合中，返回一个新集合
        val value: Any = 1 :: 2 :: 3 :: Nil
        println(value)
  }

}

object CollectTest_2_2 {
  def main(args: Array[String]): Unit = {

    //（1）创建一个可变集合ListBuffer,两种方法
    val buf2: ListBuffer[Int] = new ListBuffer[Int]
    val buf1: ListBuffer[Int] = ListBuffer(2, 3, 4)

    //（2）向集合中添加数据
    buf1.append(1)
    println(buf1)
    //（3）删除元素:  buf1.remove(4)索引   buf1.remove(1,3) 删除索引1后面的3个元素
    buf1.remove(1)
    println(buf1)
    //（4）查看修改元素
    println(buf1(0)) //查看
    buf1(0)=0  //修改
    println(buf1)


  }
}




object CollectTest_2_3{
  def main(args: Array[String]): Unit = {
    //set集合特点：无序，不可重复。底层是trait。如果元素个数大于4个 是Hashset，否则不是Hashset类型
    //创建不可变set集合：就只用apply 方法
    val s1: Set[Int] = Set(1,1,2,3,5,4,4)
    println(s1)

    //不可变set，添加元素 用 +    删除元素用   -
    val s1_1: Set[Int] = s1 + 11
    println(s1_1)
    val s1_2: Set[Int] = s1_1 - 11
    println(s1_2)
    println("===========")

    //创建可变set集合：就只用apply 方法。需要手动导包
    val s2: mutable.Set[Int] = mutable.Set(2,3,4,4,5,5)
    println(s2)

    //添加元素用add方法，删除元素用remove
    s2.add(11)
    println(s2)

    //判断是否有哪个元素。 contains(11)   括号里面是元素，不是索引
    println(s2.contains(11))

    //删除元素
    s2.remove(11)
    println(s2)
  }
  }





object CollectTest_2_4{
  def main(args: Array[String]): Unit = {
    //创建不可变map集合的两种方法
    val map1: Map[String, Int] = Map("aa"-> 1,"bb"-> 2)
    val map2: Map[String, Int] = Map(("aa",2),("bb",2))

    for (elem <- map1) {
      println(elem)//打印结果   (bb,2)
    }
    println(map1) //打印结果 Map(aa -> 1, bb -> 2)

    //获取key集  和value集
    val keys: Iterable[String] = map1.keys    //key 的set集
    val values: Iterable[Int] = map1.values   //value  集合

    //map集合中获取value值的方法1：先map1.get("aa") 获取maybeInt，然后maybeInt.get 获取value值
    val maybeInt: Option[Int] = map1.get("aa")
    println(maybeInt)
    println(maybeInt.get)
    /*如果没有对应的value   maybeInt=None，然后调用get方法可能会报错，所以下面优化maybeInt
    如果有对应的value    maybeInt=Some(1)    然后maybeInt.get 获取值*/

    println("======")

    val maybeInt1: Option[Int] = map1.get("aa1")
    //maybeInt1.getOrElse(-1)的优化: 如果有相应的value，则返回value，否则返回默认值 -1
    println(maybeInt1.getOrElse(-1))

    //map集合中获取value值的方法2：推荐用这种方法
    println(map1.getOrElse("aa1", -1))

    //map集合中获取value值的方法3：使用apply方法，前提是确定集合中有这个key,如果没有，它会报错。推荐使用
    println(map1("aa1"))
  }
}

object CollectTest_2_5{
  def main(args: Array[String]): Unit = {

//  （1）创建可变集合 :mutable.Map
    val map1: mutable.Map[String, Int] = mutable.Map(("aa",1),("bb",1),("cc",2))

//  （2）向集合增加数据（也相当于修改）
    map1.put("dd",1)
    map1.put("dd",2)//如果key重复，会覆盖原来的value值
    println(map1)
//  （3）修改数据:update
    map1.update("dd",11)
    map1("dd")=12//也可以用这个修改
    println(map1)

//  （4）删除数据
    map1.remove("dd")
    println(map1)
//   (5)map集合转换成list集合
    val list: List[(String, Int)] = map1.toList
    println(list)

  }
  }



object CollectTest_2_6{
  def main(args: Array[String]): Unit = {
    /*元组：元组也是可以理解为一个容器，可以存放各种相同或不同类型的数据。
           说的简单点，就是将多个无关的数据封装为一个整体，称为元组。注意：元组中最大只能有22个元素。*/

//  （1）声明元组的方式1：注意：Tuple3中的3就代表需要写入三个元素，
    val tuple3 = new Tuple3[String,Int,Boolean]("hi",1,true)
//      声明元组的方式1：(元素1，元素2，元素3)
    val tuple3_1: (String, Int) = ("hi",1)    //元组两个元素，就是map集合
    println(tuple3_1)   //打印结果 (hi,1)


//  （2）访问元组：调用方式：_顺序号
    println(tuple3_1._1)     //hi
    println(tuple3_1._2)     //1


//  （3）map中的元素其实就是元组,只不过元组的元素个数为2， ._1  ._2 f分别对应map中的key 和value
    val map1 = mutable.Map(("hh",1),("bb",3))
    for (elem <- map1) {
      println(elem._1)//key
      println(elem._2)//value
    }

  }
  }