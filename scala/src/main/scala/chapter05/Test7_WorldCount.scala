package chapter05




//WorldCount案例
object Test7_WorldCount {
  def main(args: Array[String]): Unit = {

    //原始数据
    val stringList = List("Hello Scala Hbase kafka", "Hello Scala Hbase", "Hello Scala", "Hello")

    //1、flattenMap展开所有的单词   (先弄成集合嵌套，然后flatten扁平化形成)

    //方法一、正常写法:先map映射，再flattenj
    /*val l1: List[List[String]] = stringList.map((s:String) => s.split(" ").toList)
   println(l1) //List(List(Hello, Scala, Hbase, kafka), List(Hello, Scala, Hbase)
   val l2: List[String] = l1.flatten
   println(l2)  //List(Hello, Scala, Hbase, kafka, Hello, Scala, Hbase, Hello, Scala, Hello)
   */

    //方法二:直接用 flattenMap实现上面  括号里面就是map映射，它会自动扁平化
    //val l3: List[String] = stringList.flatMap((s:String) => s.split(" ").toList)//没有化简

    //化简： flatMap((s:String) => s.split(" ")) 可以直接分成数组即可，
    val l4: List[String] = stringList.flatMap(_.split(" "))
    println(l4)


    //2、groupBy将相同的单词放一起。返回map集合。将List(Hello,Hello, Scala, Hello) 写成Map(Hello -> List(Hello,Hello)
    //val l6: Map[String, List[String]] = l4.groupBy((s:String) => s)
    //化简：
    val l5: Map[String, List[String]] = l4.groupBy( s => s)
    println(l5)


    //3、map映射成  (单词，数字)的格式   Map(Hello -> List(Hello, Hello, Hello, Hello))  转化成Map(Hello -> 4)

    /*
    //方法一:用map,不推荐，
   //val l7: Map[String, Int] = l5.map((s:(String,List[String])) => (s._1,s._2.size))
    //化简
    val l6: Map[String, Int] = l5.map( s => (s._1,s._2.size))
    */

    //方法二：用mapValue ,推荐，直接操作map集合的value,
    //val l9: Map[String, Int] = l5.mapValues((s:List[String]) => s.size)
    //化简
    val l8: Map[String, Int] = l5.mapValues(_.size)
    println(l8)


    //4、按照value排序，取top 3 。因为map集合没有sort系列方法，先转化成list
    val l10: List[(String, Int)] = l8.toList
    println(l10)

    //用sortBy排序
    //val l12: List[(String, Int)] = l10.sortBy((s:(String,Int)) => s._2)(Ordering[Int].reverse)
    //化简:
    val l11: List[(String, Int)] = l10.sortBy(_._2)(Ordering[Int].reverse)
    println(l11)

    //用sortWith排序
    val l14: List[(String, Int)] = l10.sortWith((left:(String,Int),right:(String,Int)) => left._2 >right._2 )
    //化简
    val l13: List[(String, Int)] = l10.sortWith(_._2 >_._2 )
    println(l13)

    //take获取前三
    println(l13.take(3))






    println("========")
    //将所有的步骤化简写
    val ss1 = List("Hello Scala Hbase kafka", "Hello Scala Hbase", "Hello Scala", "Hello")
    val ss2: Map[String, List[String]] = ss1
      .flatMap(s => s.split(" "))
      .groupBy(s => s)
    println(ss2)
    val list: List[(String, Int)] = ss2
      .mapValues(s => s.size)
      .toList
      .sortBy(s => s._2)(Ordering[Int].reverse)
      .take(3)
    println(list)


  }
}





//复杂WorldCount案例
object Test7_1WorldCount {
  def main(args: Array[String]): Unit = {

    val tupleList = List(("Hello Scala Spark World ", 4), ("Hello Scala Spark", 3), ("Hello Scala", 2), ("Hello", 1))

      //1、转化成    List((单词,次数),(单词,次数))
          //方法1：先map，在flatten   变成  List((Hello,4), (Scala,4))
    /*val list1: List[List[(String, Int)]] = tupleList.map(s => (s._1.split(" ")).map(s1 => (s1, s._2)).toList)
    println(list1)
    println(list1.flatten)*/

          //方法2： 用flatMap
    val list2: List[(String, Int)] = tupleList.flatMap(s => (s._1.split(" ")).map(s1 => (s1, s._2)))
    println(list2)


    //2、groupBy聚合
    val list3: Map[String, List[(String, Int)]] = list2.groupBy(s => s._1)
    println(list3)

    //3、 求和
         //方法1：Map(Hello -> List((Hello,4), (Hello,3),....)  :转化成Map(Hello -> List(4, 3) ,....)然后再求和
    /*val list4: Map[String, List[Int]] = list3.map(s => (s._1, s._2.map(s1 => s1._2)))
    println(list4.map(s => (s._1, s._2.sum)))*/

        //方法2：mapValue直接用foldLeft
    val list5: Map[String, Int] = list3.mapValues(s => s.foldLeft(0)((res,elem) => res + elem._2))
    println(list5)

    //4、排序，取top3

    val list6: List[(String, Int)] = list5.toList.sortWith((left,right) => left._2>right._2)
    println(list6)

    println(list6.take(3))

  }
  }







object test1{
  def main(args: Array[String]): Unit = {
    var str = "Hello Scala Hbase kafka Hello Scala Hbase Hello Scala"
    val s1: Array[String] = str.split(" ")

    println(str.split(" ").toList)
    val gb: Map[String, List[String]] = s1.toList.groupBy(s => s)
    println(gb)

    val l1: Map[String, Int] = gb.mapValues(s => s.size)
    println(l1)
  }
}

object test2{
  def main(args: Array[String]): Unit = {
    val tupleList = List(("Hello Scala Spark World ", 4), ("Hello Scala Spark", 3), ("Hello Scala", 2), ("Hello", 1))
    val map1: Map[String, Int] = tupleList.flatMap(s => s._1.split(" ").toList.map(s1 => (s1, s._2)))
      .groupBy(s => s._1)
      .mapValues(s => s.foldLeft(0)((res, elem) => res + elem._2))
    println(map1)

    println(map1.toList.sortWith((left, right) => left._2 > right._2).take(3))
  }

  }
