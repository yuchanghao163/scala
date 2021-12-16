package chapter04

import scala.beans.BeanProperty

object FieldsAndPackaging {
  def main(args: Array[String]): Unit = {

    val p1 = new person1()
    p1.setAge(26)
    println(p1.age)
    //没有setName方法，因为类中  用val 修饰了name

    //p1.id   类中私有属性无法调用,protected修饰的也无法调用

    //object中的静态属性，子类无法继承


  }
}



class person1 {
  //类中属性读写的修改，通过var 和val 决定属性可以不以修改
  //属性加  注解  @BeanProperty  就可以用get set 方法

  @BeanProperty
  val name:String ="ych"

  @BeanProperty
  var age:Int = 25

  private val id=12345

  protected val addr="河南"
}
