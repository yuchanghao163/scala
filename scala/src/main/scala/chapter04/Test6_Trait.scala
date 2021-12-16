package chapter04


//abstract类:可以有构造器，可以有抽象和非抽象的属性和方法
//使用： class A extends abstractB

//trait：不可以有构造器，可以有抽象和非抽象的属性和方法
//使用：
// 1、class A extends  traitB。
// 2、如果多特质   class A extends  traitB  with  traitC   with  traitD
// 3、单继承多特质 class A extends  classB  with  traitC   with  traitD
trait person61{

  //抽象的属性和方法
    val name:String
    var age:Int
  def sayHi():Unit

  //非抽象的属性和方法
  val name1="ych1"
  var age1=25
  def sayHi1()=println("nihao 1")
}



trait person60{}
trait person59{
  //特质自身类型：这个就表示person59 extends person60
  //用了这个，在实现特质时 with person60 不能省略  ：class A extends person59  with person60
  _: person60=>
}

class person62 extends person61{
  override val name: String = "person62"
  override var age: Int = _

  override def sayHi(): Unit = ???
}





/*
 继承的时候 父类和特质不能有相同的具体属性,会发生冲突报错,报错的
 如果是val常量,可以通过重写解决。如果是var变量,只能去修改父类或者特质
 如果继承的属性 一个是抽象的一个是非抽象的  不会发生冲突  需要注意var的属性不能重写
 //（3）所有的Java接口都可以当做Scala特质使用
class Teacher14 extends java.io.Serializable{}
 */
object Trait_6 {
  def main(args: Array[String]): Unit = {
        val p6_2 = new person62()

        //特质混入:在创建对象时，可以直接在后面with一个特质。
        val p1 = new person62 with person60
  }
}


object expend{
  def main(args: Array[String]): Unit = {
/*
（1）obj.isInstanceOf[T]：判断obj是不是T类型。 相当于Java中   if(A instanceof B)

（2）obj.asInstanceOf[T]：将obj强转成T类型。相当于Java中  (类型A) 类型B

（3）classOf获取类模板。
*/
    val s: Class[String] = classOf[String]
    println(s)

  }

}



//枚举类
object traitA extends Enumeration{
  private val RED: traitA.Value = Value(1,"red")
}

//应用类
object traitB extends App{
  println("我可以不写main方法直接打印，")

//定义新类型: 类型ss为person62
  type ss=person62

  val a:ss=new person62

}

