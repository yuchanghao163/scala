package chapter04

/*
（1）定义抽象类：abstract class Person{} //通过abstract关键字标记抽象类
（2）定义抽象属性：val|var name:String //一个属性没有初始化，就是抽象属性
（3）定义抽象方法：def  hello():String //只声明而没有实现的方法，就是抽象方法
 (4)抽象的属性只能存在于抽象的类中.
 (5)抽象类的使用有两种方法 :1.使用子类继承抽象类 2.使用匿名子类
 (6)Scala的多态没有Java中的 特色（多态创建的对象，调用子类重写的方法）
*/



/*写上abstract就是抽象类，不写方法的方法体和属性的值，就是抽象属性和方法，
 反之就是非抽象方法和属性*/

abstract class person4 (){
     //抽象属性
    val name:String
    var age:Int

    //非抽象属性
    val name1:String="ych"
    var age1:Int=10


  //抽象方法
  def sayHi():Unit
  def sayHi(name:String,age:Int):String
  //非抽象方法
  def sayHi1(): Unit ={
    println("nihao1 person")
  }

}

/*
（1）如果父类为抽象类，那么子类需要将抽象的属性和方法实现，否则子类也需声明为抽象类
（2）重写非抽象方法需要用override修饰，重写抽象方法则可以不加override。
（3）子类中调用父类的方法使用super关键字
（4）对于非抽象属性，只能重写val修饰的属性。var修饰的非抽象属性不能重写
     而var和val修饰的抽象属性都可以重写
*/
class student11 extends person4(){

  override val name: String = "student"  //重写val属性，必须给个值，var 不用

  override var age: Int = 20

  //重写抽象方法:可以不写override
   def sayHi(): Unit = println("nihao1 studnet")
   def sayHi(name: String, age: Int): String = s"$name:$age"


  //重写非抽象方法：必须加上override
  override def sayHi1(): Unit = super.sayHi1()

  //重写非抽象属性
  override val name1: String = "student1"
}


object AbstractTest_4 {
  def main(args: Array[String]): Unit = {

      val s1 = new student11
      println(s1)
      s1.sayHi1()
      s1.sayHi()

    println("================")
    //抽象的第二种用法：匿名子类
    val p4_1: person4 = new person4 {
      override val name: String = "匿名子类"
      override var age: Int = _

      override def sayHi(): Unit = println("匿名子类的使用")

      override def sayHi(name: String, age: Int): String = s"$name:$age"

      //匿名子类中，自己定义的属性和方法，外部无法调用，因为它是天然的多态（父类类型不能调用子类的）
      val sex: String = "男"

    }

    p4_1.sayHi()


  }
}