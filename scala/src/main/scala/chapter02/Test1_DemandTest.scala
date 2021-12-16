package chapter02

import scala.util.control.Breaks

object Test1_DemandTest {
  def main(args: Array[String]): Unit = {
    //9*9乘法表
    for(i<- 1 to 9){
      for(j<- 1 to i){
        print(s"$j * $i =${i*j} \t")
      }
      println()
    }
    //方法二
    for(i<- 1 to 9; j<- 1 to i ){
      print(s"$j * $i =${i*j} \t")
      if(i==j) println()
    }

    //9层宝塔
    println("=========")
    /*for (i<- 1 to 9){
      for (j<- 9-i to 1 by -1){
        print(" ")
      }
      for (j<- 1 to 2*i-1){
        print("*")
      }
      println()
    }*/


    def demand2(floors :Int) :Unit={
      for (i<- 1 to floors){
        for (j<- floors-i to 1 by -1){
          print(" ")
        }
        for (j<- 1 to 2*i-1){
          print("*")
        }
        println()
      }
    }

    demand2(5)

    println("========")

    for (i <- 1 to 9 ) {
      print(" " * (9 - i))
      print("*" * (2*i-1))
      println()
    }

    println("===========")

    //倒序输出1-100内的质数
    for (i <- 2 to 100 reverse){
      var flag :Boolean =true;


     Breaks.breakable({
       for(j <- 2 to i-1  ){
         //Scala中循环中断的用法，
           if (i%j==0){
             flag=false
             Breaks.break()
           }
       }
     })
      if (flag){
        println(i)
      }
    }


    println("===========")
    //for 循环的本质
    for(i <- List(1,2,3,5)){
      println(i)
    }

  }
}
