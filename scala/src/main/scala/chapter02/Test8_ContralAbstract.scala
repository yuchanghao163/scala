package chapter02

object Test8_ContralAbstract {
  def main(args: Array[String]): Unit = {

    //值调用:把计算后的值传递过去,我们一般用的是值调用，
    //名调用:把整个代码块传递
    /*当代码块作为参数时，值调用会先执行代码块，将其最后一行作为返回值，然后作为函数的参数，
                        名调用会先执行函数，当每用到一次代码块参数，就会执行一次代码块*/

    //值调用   name:String
    def sayHi1(name:String)={
      println("我特殊")
      s"你好 $name"
    }

    println(sayHi1({//值调用：代码块作为参数时，会先执行代码块，将其最后一行作为返回值，然后作为函数的参数
      println("调用")
      "余长浩"
    }))

    println("==================")

    //名调用   name: => String
    def sayHi2(name: => String)={
      println("我特殊")
      s"你好 $name"
      s"你好 $name"
    }

    println(sayHi2({//名调用：代码块作为参数，先不执行代码块，当用到代码块参数时，再调用。
      println("调用")
      "余长浩"
    }))


    println("******************")




    //惰性函数
    def func(a:Int,b:Int)={
      println("调用惰性函数")
      a+b
    }

    val sum1: Int = func(1, 2) //会执行   println("调用惰性函数")

    lazy val sum2: Int = func(1, 2)   //加上lazy 就不会主动执行函数内部的println("调用惰性函数")

    println(sum2)//当用到变量时，才会执行



    println("******************")




    //自己写一个while循环：

    //op : =>Unit  代表一个代码块,
    // 下面写法有问题，因为b:Boolean  是值调用，只会运行一次，第一次为true然后就一直是true，所以就成了while（true）
  /*  def myWhile(b:Boolean)(op : =>Unit): Unit={
      if(b){
        op
        myWhile(b)(op)
      }
    }
    */

    def myWhile(b: => Boolean)(op : =>Unit): Unit= {
      if (b) {
        op
        myWhile(b)(op)
      }
    }

    var n=0
    myWhile(n<5){
      println(n)
      n += 1
    }
    
  }
}
