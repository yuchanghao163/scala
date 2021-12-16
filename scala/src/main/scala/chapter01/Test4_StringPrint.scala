package chapter01

object Test4_StringPrint {
  var c: Int = _
  val d: Int =1

  def main(args: Array[String]): Unit = {
    var age = 10
    val name = "余长浩"
    //（1）字符串，通过+号连接
    println("1"+name + age)

    //（2）重复字符串拼接
    println("2"+(name+age)*4)
    //（3）printf用法：字符串，通过%传值。%d代表数值类型，%s代表引用类型
    printf("3"+"我是%d岁的%s \n",10,"余长浩")
    //（4）字符串模板（插值字符串）：通过${var}（括号里可以运算）获取变量值
    println(s"4我是${age+15}岁的${name}啊哈哈")
    //（5）长字符串  原始字符串
    println(
      """5呀
        |你好
        |我是
        |小鱼呀
      """.stripMargin)
  }




}

class Test4_StringPrint{
  var age=1
  val name = "ych"

}
