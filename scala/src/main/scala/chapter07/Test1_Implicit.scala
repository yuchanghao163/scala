package chapter07

object Test1_Implicit {
  def main(args: Array[String]): Unit = {

    //隐式函数
      implicit def ch(i:Int):MyInt={
        new MyInt(i)
      }
      // 当想调用对象功能时，如果编译错误，那么编译器会尝试在当前作用域范围内查找能调用对应功能的转换规则，
    // 这个调用过程是由编译器完成的，所以称之为隐式转换。也称之为自动转换，

    // 10 调用发现没10这个对象，然后就走隐式函数， 就相当于 10=new MyInt(10)
    println(10.myMax(11))

  }
}

class MyInt( n:Int){

  def myMax(i:Int):Int={
    if (n>i) n else i
  }
}









object Test1_1Implicit {
  def main(args: Array[String]): Unit = {

    //隐式参数:隐式参数和默认参数没啥区别，但是调用时 不带参数括号 走隐式，带上空括号，走默认

    implicit  val str="ych"
    def sayHi(implicit s:String)={println(s"hi $s")}

    sayHi //不用填参数

    def sayHi1(implicit s:String="lsn")={println(s"hi $s")}

    sayHi1  //ych
    sayHi1()  //lsn
    sayHi1("zy")  //zy
  }
  }









//隐式类
object Test1_2Implicit {
  def main(args: Array[String]): Unit = {

    //声明了隐式类，可以直接调用类中的方法
    println(10.myMax(11))
  }

  //隐式类：只能在object中，
implicit class MyInt1( n:Int){

  def myMax(i:Int):Int={
    if (n>i) n else i
  }
}

}




//泛型：
//    [+T] :表示正常继承的父子关系
//    [-T] :逆变，表示逆转父子关系