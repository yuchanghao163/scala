package chapter02

object Test5_SeniorFun {
  def main(args: Array[String]): Unit = {


    def f0(name: String): String = {

      println(name)
      s"hi  $name"
    }

    //    1）函数可以作为值进行传递
    // 方法一： f0("余长浩")是调用函数， res1用来接收函数的返回值（函数的返回值是s"hi  $name"）
    val res1: String = f0("余长浩")
    println(res1)
    /*方法二：上面那种方法必须要传入一个参数“余长浩”，才能得到函数的返回值，
    *         而用下面这种方法，不需要传入参数，res2就代表函数f0的返回值
    *         函数名 _   代表函数自身
    *         如果有类型推断，直接用函数名  代表函数自身
    *         */

    val res2: String => String = f0 _
    val res3: String => String = f0 //化简上面的，因为有String => String类型推断，所有可以省略 _

    println(res2("ych"))

    //    2）函数可以作为参数进行传递
    def sumAB(a: Int, b: Int): Int = {
      a + b
    }
    //化简为
    val sumAB1:(Int,Int)=>Int = (a: Int, b: Int) => a + b
    val sumAB2:(Int,Int)=>Int =  _ + _

    val i1: Int = sumAB(10, 20)
    println("=====sumAB=====")
    println(i1)

    //将函数作为参数  r:(Int,Int)=>Int = (a: Int, b: Int) => a + b    等号左右
    def operateAB(a: Int, b: Int,r:(Int,Int)=>Int)={
      r(a,b)
    }
    /*operateAB(10,20,sumAB)
    operateAB(10,20,sumAB1)
    operateAB(10,20,sumAB2)   --->  operateAB(10,20,_+_)*/
    println("=======operateAB=======")
    println(operateAB(10, 20, _ + _))
    println(operateAB(10, 20, 2 * _ + 3 + _))




    //    3）函数可以作为函数返回值返回
      def sumX(x:Int)={
        def sumY(y:Int)={
          x+y
        }
        sumY _
      }
    //化简1
    def sumX1(x:Int)=(y:Int)=>x+y
    //化简2
    val sumxx: Int=>Int=>Int  = (x:Int)=>(y:Int) => x+y



    println("=======sumX==========")
    println(sumX(10)(20))
    println(sumxx(10)(20))

  }
}
