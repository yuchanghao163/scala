package chapter03

object TestPO {
  def main(args: Array[String]): Unit = {

      //直接可以调用包对象中的静态方法，
      mainP(args)
      //通过   包.属性    调用包对象中的属性
    println(chapter03.name)
      //      包.方法
    chapter03.mainP(args)


  }
}
