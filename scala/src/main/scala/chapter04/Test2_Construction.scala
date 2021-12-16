package chapter04

object ConstructionTest_2 {
  def main(args: Array[String]): Unit = {

    //用到构造器，最先必须先用主构造器，然后才能用到辅助构造器

    val p2 = new person2("ych")//主
    println("=========")

    val p2_1 = new person2//辅助构造器1
    println(p2_1.name1)


    println("=========")
    val p2_2 :person2 = new person2(18)//辅助构造器1

    println(p2_2.name1)
    println(p2_2.age)

  }
}


//主构造器
class person2(name: String) {
  println("主构造器")
  //一定要写这个，不然在外面 p2不好调用name，var修饰代表可以变，val修饰代表不可变
  var name1 = name;

  var age:Int =_

  //辅助构造器:其第一行，必须直接或间接调用主构造器
  def this() {
    this("ych")
    println("辅助构造器1")
  }


  def this(age:Int) {
    this() //辅助构造器调用辅助构造器，实现间接调用主构造器
    this.age=age
    println("辅助构造器2")
  }


}
