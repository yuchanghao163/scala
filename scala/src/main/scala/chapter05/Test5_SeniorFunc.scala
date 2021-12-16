package chapter05

object Test5_SeniorFunc {
  def main(args: Array[String]): Unit = {
    val l1 = List(1,2,3,4,5,6)

    //filter过滤函数：  过滤掉 小于4的元素
    println(l1.filter((i: Int) => i < 4))

    //map 转化/映射函数
    println(l1.map((i: Int) => i + 1))   //输入i  输出是 i+1
    println(l1.map(((i: Int) => i.toString))) // 输入是int类型的i ,输出转化为String类型
    println(l1.map((i: Int) => List(i, 1, 0)))// 输入是int类型， 转化成一个集合


  }
}


object Test5_1SeniorFunc {
  def main(args: Array[String]): Unit = {

    //flatten扁平化: 将嵌套集合的集合，打散，不会去重
    val l2: List[List[Int]] = List(List(1, 1, 0), List(2, 1, 0), List(3, 1, 0))
    println(l2.flatten)

    //map映射  +  flatten扁平化
    val l2_2: List[String] = List("How are","you and","you")
    val l2_3: List[List[String]] = l2_2.map((s: String) => {
      val arrs: Array[String] = s.split(" ")
      arrs.toList
    })//映射


    println(l2_3.flatten)//扁平化


    //flattenMap ：相当于只用写map映射成集合，它内部会自动扁平化
    val l2_4: List[String] = l2_2.flatMap((s: String) => {
      val arrs: Array[String] = s.split(" ")
      arrs.toList
    })//这里只映射成集合就完成了扁平化

    println(l2_4)



  }
}


object Test5_2SeniorFunc {
  def main(args: Array[String]): Unit = {

    val l5: List[Int] = List(1,2,3,4,5,6)
    //groupBy 分组 :函数体的返回值就作为分组的标签，对应分组后的key

    // 大于等于3的分一组List，小于3的分一组List， 返回的是Map集合
    val map1: Map[Boolean, List[Int]] = l5.groupBy((i:Int) => i>=3 )
    println(map1)

    println("99999999999999999")
    //大于等于3的分一组List，小于3的分一组List， 等于3的分一组List
    val map2: Map[Int, List[Int]] = l5.groupBy((i: Int) => {
      if (i > 3) {
        1
      }
      else if (i < 3) {
        -1
      }
      else {
        0
      }
    })
    println(map2)


    //按照自身分组  :  Map(How -> List(How), you -> List(you, you),  are -> List( are))
    val l5_1: List[String] = List("How"," are","you","you")

    val map3: Map[String, List[String]] = l5_1.groupBy( (i:String) => i )
    println(map3)
  }
}





object Test5_3SeniorFunc {
  def main(args: Array[String]): Unit = {

    val l1: List[Int] = List(1, 2, 3, 4, 5, 6)
    //reduce 归约
    //res 是集合中的第一个元素，elem是除了第一个其他的元素
    val i: Int = l1.reduce((res:Int,elem:Int) => res + elem)
    println(i)

    //fold  折叠
    //fold 可以手动填一个初始值，初始值类型是确定的，是集合元素的类型。然后其他和reduce用法一样

    val i1: Int = l1.fold(0)((res:Int,elem:Int) => res + elem)//这里相当于将res 的值赋为0
    println(i1)


    //需求：将 List(1, 2, 3, 4, 5, 6)  -->归约成  ("和为"，21)
    val l2 = List(1, 2, 3, 4, 5, 6)

    //foldLeft可以手动填一个初始值，初始值类型也可以定义。
    l2.foldLeft(("和为",0))((res:(String,Int),elem:Int) => (res._1,res._2+elem))



    //需求：合并两个map("aa",1)  ，key相同时，将value相加


  }
}