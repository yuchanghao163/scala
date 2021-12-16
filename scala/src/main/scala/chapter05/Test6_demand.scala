package chapter05

import scala.collection.mutable

object Test6_demand {
  def main(args: Array[String]): Unit = {

    //合并map
    val map1: mutable.Map[String, Int] = mutable.Map(("hello",1))
    val map2: Map[String, Int] = Map(("hello",2),("world",4))

    //方法1：用for 。可变集合添加元素，合并成一个，不推荐，因为必须是可变集合
    for (elem <- map2) {
        val key: String = elem._1
      val value: Int = elem._2

//      if(map1.contains(key)){
//        map1.update(key,value+map1(key))
//      } else {
//        map1.put(key,value)
//      } //这一部分化简为
      map1.put(key,value+map1.getOrElse(key,0))
    }
    println(map1)

    //方法二：用foreach()。
    val map1_1: mutable.Map[String, Int] = mutable.Map(("hello",4))
    val map2_2: Map[String, Int] = Map(("hello",2),("world",4))
    map2_2.foreach(s => map1_1.put(s._1,s._2+map1_1.getOrElse(s._1,0)))
    println(map1_1)



    //方法三： foldLeft 归约
    val map1_11: mutable.Map[String, Int] = mutable.Map(("hello",4))
    val map2_22: Map[String, Int] = Map(("hello",2),("world",4))

    map2_22.foldLeft(map1_11)((res, elem) => {
      res.put(elem._1, (res.getOrElse(elem._1,0) + elem._2))
      res //返回res
    }
    )
    println(map1_11)
  }
}









