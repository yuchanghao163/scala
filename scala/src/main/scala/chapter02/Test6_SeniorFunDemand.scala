package chapter02

object Test6_SeniorFunDemand {
  def main(args: Array[String]): Unit = {



    /*需求1：定义一个函数，函数在调用的时候，填入参数（0，'0',""）
    返回false，否则返回true*/
    def f1(a:Int,b:Char,c:String)=if(a==0 && b=='0' && c=="") false else true
    def f11(a:Int,b:Char,c:String)= !(a==0 && b=='0' && c=="")  //化简
    def f111(a:Int,b:Char,c:String)=  a != 0 || b!='0' || c!=""  //化简
    println("=====")

//    (a:Int,b:Char,c:String) =>  a != 0 || b!='0' || c!=""  //化简成匿名函数
                                                          //接收匿名函数并化简
    var f1111:(Int,Char,String) =>Boolean = (a:Int,b:Char,c:String) =>  a != 0 || b!='0' || c!=""
    var f1112:(Int,Char,String) =>Boolean = (a,b,c) =>  a != 0 || b!='0' || c!=""

//    过度化简
//    var f1113:(Int,Char,String) =>Boolean =  _ != 0 || _!='0' || _!=""


    val boo: Boolean = f1111(0, '0', "")


      println("=====")
      println(f1111(0, '0', ""))
      println("+++++++")


    /*需求2：定义一个函数，函数在调用的时候，填入参数(0)('0')("")
    返回false，否则返回true*/
    def f2(a:Int) ={
      def f3(b:Char) ={
        def f4(c:String):Boolean ={
          a != 0 || b!='0' || c!=""
        }
        f4 _
      }
      f3 _
    }

    /*def f2(a:Int) ={//简化步骤
      def f3(b:Char) =
        (c:String) => a != 0 || b!='0' || c!=""
    }*/

    println("f2=========")
    println(f2(0)('0')(""))
    println(f2(1)('0')(""))


    //化简
    /*var f4:Int => Char => String => Boolean =
      (a:Int) => (b:Char) => (c:String) => a != 0 || b!='0' || c!=""*/
    var f4:Int => Char => String => Boolean =
      a=> b => c => a != 0 || b!='0' || c!=""

    /*过度化简 _，且这里的化简只能化简最后一个c,因为只有它没有被嵌套，
    var f5:Int => Char => String => Boolean =
      (a) => (b)  => a != 0 || b!='0' || _!=""*/

    println("f4=========")
    println(f4(0)('0')(""))
    println(f4(1)('0')(""))




    //柯里化：定义函数时，直接成这样
    def f55(a:Int)(b:Int)(c:Int) :Boolean = {
      a != 0 || b!='0' || c!=""
    }
    println("f55=========")
    println(f4(0)('0')(""))
    println(f4(1)('0')(""))


    //闭包
    def sumBy1(x:Int)={
      def sumBy2(y:Int):Int=x+y
      sumBy2 _
    }
    //使用方便
    val sumByFive: Int => Int = sumBy1(5)  //5 + y
    val sumBySix: Int => Int = sumBy1(6)   //6 + y
  }
}
