package object chapter03 {

    //包对象：它里面的属性方法是共享的，在当前包下的类可以直接使用
  val name="ych"
  var age=25

  def mainP(args: Array[String]): Unit = {
      println(s"$name : $age 岁")
  }
}


