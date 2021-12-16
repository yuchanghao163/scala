package chapter01






  //main(String [] args)  ---Java中的main方法

  //Unit：返回值类型，相当于void
  object Test1_HelloScala {
  def main(args: Array[String]): Unit = {
      System.out.println("HelloScala")


      val helloJava = new Test1_HelloScala
      helloJava.main1(args)
  }
}

//可以理解为object 中的都是静态的, class中的都不是静态的
//object HelloScala {}   伴生对象
//class HelloScala{}     伴生类      如果伴生对象没有对应的伴生类，则object又称为单例对象
class Test1_HelloScala{//main1不是静态的
  def main1(args: Array[String]): Unit = {
    println("HelloJava")
  }
}



