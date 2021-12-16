package chapter04

object ExtendTest_3 {
  def main(args: Array[String]): Unit = {

      val st1 = new student("二年级")

    println(st1.age)

    println(st1.grade)

    st1.sayHi()
    println(st1.id)
    println(st1.name)

    println("===========")


    val st2 = new student(20)
    println(st2.age)


  }
}


//子类继承父类，当new 子类构造器， 它会先走父类构造器
//继承的实质：只继承父类一个构造器，并且父类构造器有什么参数，子类构造器必须有相同的参数

class student(id1:Int,name:String)extends person3(name:String){
    println("子类主构造器")
    var id=id1
    var grade:String= _

  def this(grade:String){
    this(1,"子类")
    this.grade=grade
    println("子类辅助构造器1")
  }

  def this(age:Int){
    this("一年级")
    this.age=age
    println("子类辅助构造器2")
  }
}


class person3(name1: String) {
  println("父主构造器")
  var name = name1;
  var age:Int= _

  def this(age: Int) {
    this("fulei")
    this.age=age
    println("父辅助构造器1")
  }

  def this() {
    this(10)
    println("父辅助构造器2")
  }

  def sayHi(): Unit = {
    println("nihao")
  }
}
