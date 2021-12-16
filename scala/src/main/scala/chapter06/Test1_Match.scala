package chapter06

object Test1_Match {
  def main(args: Array[String]): Unit = {
    var a=5
    var b=2
    val f='/'

    //case _  相当于Java中的default
    //匹配常量
    val res: Any = f match {
      case '+' => a + b
      case '-' => a - b
      case '*' => a * b
      case '/' => a / b
      case _ => println("符号错误")
    }
    println(res)


    //匹配类型
    def typeJudge(s:Any)={
      s match {
        case s:Int => "int类型"
        case s:Double => "浮点类型"
        case s:String => "String类型"
        case _ => "其他类型"
      }
    }
    println(typeJudge(1.2))
    println(typeJudge(""))






    //数组匹配： x  y _  都表示任意一个元素
    val arr1: Array[Array[_ >: Int]] = Array(Array(0), Array(1, 0), Array(0, 1, 0),
      Array(1, 1, 0), Array(1, 1, 0, 1), Array("hello", 90))
    for (elem <- arr1) {
    elem match {
      case Array(0) => println("只要一个元素0的数组")
      case Array(1,_) => println("第一个元素为0，第二个元素任意的数组")
      case Array(0,_*) => println("第一个元素为0的数组")
      case Array(x,_,y) => println(s"有三个元素的数组，第一个元素为$x ,最后一个元素为$y")
      case _ => println("其他数组")
    }
    }


    println("==========")

    //匹配列表 （匹配集合数组等的类型）
    def func1(x:AnyRef):String = {
      x match {
        case x:Array[Int] => "泛型为整数"
        case x:Array[Char] => "泛型为字符"
        case x:Array[String] => "string类型的数组"
        case x:List[String] => "String类型的集合"
        case _ => "其他"
      }
    }

    println(func1(List("a", "b")))
    println(func1(Array("a", "b")))
  }
}






//匹配对象
object objectMatch{
  def main(args: Array[String]): Unit = {
    val p1 = new person6("张三",10)

    //匹配对象
    p1 match {
      case person6("张三",10) => println("找到张三了")
    }
  }
}


//如果不加case上面匹配不到，因为加上case 就相当于在单例对象object中写了 unapply解析方法和apply方法
//这样的类称为  样例类，
case class person6(name:String,age:Int){
}







//偏函数：  将正常的match匹配格式简化为  {case xxxx} 就是偏函数。
//它会自动过滤掉不符合的。
object partialFunc{
  def main(args: Array[String]): Unit = {

    //将该List(1,2,3,4,5,6,"test")中的Int类型的元素加一，并去掉字符串。
    val l1 = List(1,2,3,4,5,6,"test")

    //方法一、不用偏函数，正常的match匹配
    //过滤掉字符串
    val l2: List[Any] = l1.filter(((s: Any) =>
      s match {
        case s: Int => true
        case s: String => false
        case _ => false
      }
      ))
    println(l2)
    //将集合元素 + 1
    val l3: List[Int] = l2.map((s: Any) => s match {
      case s: Int => s + 1
      case _ => -1
    })
    println(l3)


    //方法二、用偏函数。  map()方法不支持写偏函数，collect() 方法支持
    //这里指明匹配  Int类型，不符合的就会过滤掉，所有不用判断
    val l4: List[Int] = l1.collect({
      case i: Int => i + 1
    })
    println(l4)

  }
}
