package chapter02

object Test3_FunSimplifyPrinciple {
/*
  只有一行代码，可以省略花括号
（4）如果有return，则不能省略返回值类型，必须指定

 有返回值的省略：①可以类型推断，省略返回值类型。但是如果有return，则不能省略返回值类型
 无返回值的省略：省略等号，但必须加上花括号
 匿名函数：
 //(x:Int,y:Int) => "f9是"+(x+y).var返回得到下面，匿名函数
     val function: (Int, Int) => String = (x:Int,y:Int) => "f9是"+(x+y)
* */


  def main(args: Array[String]): Unit = {

    def f0(name:String):String={
      return  s"hello $name"
    }

//    （1）return可以省略，Scala会使用函数体的最后一行代码作为返回值
    def f1(name:String):String={
       s"hello $name"
    }
    println(f1("f1浴场好"))

//    （2）如果函数体只有一行代码，可以省略花括号
    def f2(name:String):String=s"hello $name"
    println(f2("f2浴场好"))

//    （3）返回值类型如果能够推断出来，那么可以省略（:和返回值类型一起省略）
    def f3(name:String) = s"hello $name"
    println(f3("f3浴场好"))

//    （4）如果有return，则不能省略返回值类型，必须指定
def f4(name:String):String =return s"hello $name"
    println(f4("f4浴场好"))

    //    （5）如果函数明确声明unit，那么即使函数体中使用return关键字也不起作用
    def f5(name:String):Unit =return s"hello $name"
    println(f5("f5浴场好"))

    //    （6）Scala如果期望是无返回值类型，可以省略等号
    def f6(x:Int,y:Int) {println("f6是"+(x+y))}
    f6(1,1)

    //    （7）如果函数无参，但是声明了参数列表，那么调用时，小括号，可加可不加
    def f7():Unit ={println("f7hello")}
    f7
    //    （8）如果函数没有参数列表，那么小括号可以省略，调用时小括号必须省略
    def f8 {println("f8hello")}
    f8
    //    （9）如果不关心名称，只关心逻辑处理，那么函数名（def）可以省略

    //(x:Int,y:Int) => "f9是"+(x+y).var返回得到下面，匿名函数
     val function=(x:Int,y:Int) => "f9是"+(x+y)
    println(function(1, 2))

  }
}
