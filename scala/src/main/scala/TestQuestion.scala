object TestQuestion {
  def main(args: Array[String]): Unit = {

    val s1 = new String("ych")
    val s2 = new String("ych")

    //equals比较地址值，如果有重写equals方法，则比较内容
    println(s1.equals(s2))

    // eq不管有没有重写equals方法，都比较地址值
    println(s1.eq(s2))


    val t = new T11
  }
}


abstract class T1{
  def sayHi():Unit
}
class T11 extends T1{
  override def sayHi(): Unit = ???
}



object TestQuestion2 {
  def main(args: Array[String]): Unit = {
      val arr1 = Array(1,2)
      arr1(0)=2
    arr1.foreach(println)
  }
}


object TestQuestion3 {
  def main(args: Array[String]): Unit = {
    def sayHi(s:String="ych")={println(s"hi $s")}

    sayHi()

  }

  }
