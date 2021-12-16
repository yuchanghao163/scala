package chapter05

object Test4_PrimaryFunc {
  def main(args: Array[String]): Unit = {
//    （1）sorted
//    对一个集合进行自然排序，通过传递隐式的Ordering
//    （2）sortBy
//    对一个属性或多个属性进行排序，通过它的类型。
//    （3）sortWith
//    基于函数的排序，通过一个comparator函数，实现自定义排序的逻辑。




    val l1 = List(2,1,3)
//  （1）求和
    println(l1.sum)

//  （2）求乘积
    println(l1.product)

//  （3）最大值
    println(l1.max)

//  （4）最小值
    println(l1.min)

//  （5）排序
    println(l1)
//      5.1: sorted：默认从小到大排序，按照元素的字典序排。Ordering[(String, Int)] 括号里面的是数据类型
    println(l1.sorted)
    //实现倒序
    println(l1.sorted(Ordering.Int.reverse))//写法一：
    println(l1.sorted(Ordering[Int].reverse))//写法二：

    //排序元组 :先按照key排，然后按照value排
    val tuples: List[(String, Int)] = List(("ad",2),("ab",1),("cc",1))
    println(tuples.sorted)
    //倒序排序元组
    println(tuples.sorted(Ordering[(String, Int)].reverse))


//     5.2: sortBy: 可以实现按照 value排
    println(tuples.sortBy((tup: (String, Int)) => tup._2   ))

                    //按照value的倒序排
    val tu1: List[(String, Int)] = tuples.sortBy((tup: (String, Int)) => tup._2)(Ordering[Int].reverse)//完整版
    val tu2: List[(String, Int)] = tuples.sortBy( tup => tup._2)(Ordering[Int].reverse)//省略过程
    val tu3: List[(String, Int)] = tuples.sortBy( _._2)(Ordering[Int].reverse)//最终版省略
    println(tu3)

    println("===========")

//    5.3： sortWith :可以自定义排序

    //按照key的第二个字母， 从小到大排序
    val tu4: List[(String, Int)] =
      tuples.sortWith((left:(String,Int),right:(String,Int)) => left._1.charAt(1) < right._1.charAt(1))
    println(tu4)                                                             //这里是比较大小，返回一个Boolean

    //按照value，从大到小
    val tu5: List[(String, Int)] =
      tuples.sortWith((left:(String,Int),right:(String,Int)) => left._2 > right._2)
    //化简：
    val tu6: List[(String, Int)] = tuples.sortWith(_._2 > _._2)


    println(tu5)
  }
}
