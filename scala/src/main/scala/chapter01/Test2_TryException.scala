package chapter01

object Test2_TryException {
  def main(args: Array[String]): Unit = {


    val str: Unit = {
      10
      20
      println(10)
    }
    //代码块中最后一个行是返回值  Unit代表无返回值为  ()
    println(str)

    val i: Unit = {
      println(20)
      30
    }
    println(i)


    println("============")//try  catch 异常处理
    for (i <- 5 to 1 by -1){
      println(i)

      try {
      if(i==3){
        throw new RuntimeException()
      }
      } catch {
        case e: Exception => println("抓取异常")
      }


    }
  }
}
