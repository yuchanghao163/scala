package chapter02

//函数参数
object Test2_DefinedFun {
  def main(args: Array[String]): Unit = {
//    （1）可变参数
    def sayHi1(name:String*): Unit ={
      println(s"hi $name")
    }
    sayHi1("ych","aaaa")
//    （2）如果参数列表中存在多个参数，那么可变参数一般放置在最后,即使数据类型不一致也不行
    def sayHi2(id:Int ,name:String*): Unit ={
      println(s"id号为$id 的 $name")
    }
    sayHi2(1,"ych1","ych2")

//    （3）参数默认值，一般将有默认值的参数放置在参数列表的后面
    def sayHi3(id :Int =1,name:String): Unit ={
      println(s"hi id号为$id 的 $name")
    }
    sayHi3(1,"ych")
    sayHi3(name = "ych2")//可以省略不写默认值，用带名参数
//    （4）带名参数
  }
}
