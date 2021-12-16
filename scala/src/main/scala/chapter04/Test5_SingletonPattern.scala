package chapter04




/*  object + class叫做伴生对象    只有object 叫做单例对象     class 叫做伴生类
（1）单例对象采用object关键字声明。
（2）单例对象对应的类称之为伴生类，伴生对象的名称应该和伴生类名一致。
（3）单例对象中的属性和方法都可以通过伴生对象名（类名）直接调用访问。
    （单例对象中的属性和方法相当于是静态的）
*/
object person5 {
    var name="object_person"
    var age =10

  def objectSay()=println("object方法")

  def apply(): person5 = new person5()

  //apply方法，可以写任何代码
//  def apply(): Unit = println("我是apply")
}

class person5 (){
  val name="class_person"
  println(person5.age)
  person5.objectSay()

}


object SingletonPattern_5 {
  def main(args: Array[String]): Unit = {
      //通过   类.属性（方法）  调用 单例对象中的属性方法
      println(person5.name)
      val p5_1 = new person5

    //创建对象的另一种方法：在object中写apply()方法，然后person5.apply()就返回一个对象
    val p5_2: person5 = person5.apply()

    //这个是上面的省略方法名 写法，
      val p5_3: person5 = person5()
    println(p5_2.name)
    println(p5_3.name)


    println("============")

    val s1 = singleton5.apply()
    val s2 = singleton5.apply()
    println(s1.equals(s2))

    //eq专门比较地址值
    println(s1.eq(s2))

  }

}


//单例模式:饿汉式  私有化构造器，只创建一个对象
// 如果想让主构造器变成私有的，可以在()之前加上private。

object singleton5{

   private val ins=new singleton5 ()

  def apply(): singleton5 = ins
}
class singleton5 private (){

}






