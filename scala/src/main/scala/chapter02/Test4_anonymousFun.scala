package chapter02

object Test4_anonymousFun {

  /*传递匿名函数至简原则：
（1）参数的类型可以省略，会根据形参进行自动的推导
（2）类型省略之后，发现只有一个参数，则圆括号可以省略；其他情况：没有参数和参数超过1的永远不能省略圆括号。
（3）匿名函数如果只有一行，则大括号也可以省略
（4）如果参数只出现一次，则参数省略且后面参数可以用_代替*/

  def main(args: Array[String]): Unit = {
    val f1: String => String = (name:String) => name+1

    def fun(name:String) =name +1

    //（1）参数的类型可以省略，会根据形参进行自动的推导
    val f2 = (name:String) => name+1//省略一
    val f3: String => String = (name) => name+1//省略二
    println(f3("ych"))
    //（2）类型省略之后，发现只有一个参数，则圆括号可以省略；其他情况：没有参数和参数超过1的永远不能省略圆括号。
    val f4: String => String = name => name+1//省略三
    val f5: (String, Int) => String = (name,age) => name+age//参数超过一个，不可省略圆括号
    val i: () => Int = () => 1//无参数是，圆括号不可以省略

   // （3）匿名函数如果只有一行，则大括号也可以省略
   val f6: String => String = (name:String) => {
     println("nihao")
     name+1
   }


   //（4）如果参数只出现一次，则参数省略且后面参数可以用_代替
   //val f4: String => String = name => name+1
    val f7: String => String = _+1
    //val f8: (Int, Int) => Int = (x:Int,y:Int) => x+y
    val f8: (Int, Int) => Int =  _+_    //下划线代表x和y

    //参数需要按照顺序来
    val f9: (Int, Int) => Int = (x:Int,y:Int) => y-x

    //当下划线只有一个时，会报错
    val f10: String => String = name => name
    val f11: String => String = _ + ""
  }
}
