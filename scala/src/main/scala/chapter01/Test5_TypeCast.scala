package chapter01

object Test5_TypeCast {
  def main(args: Array[String]): Unit = {

    //强制类型转换，调用方法  toByte toInt 等
    var a:Int = 100
    var c: Byte = a.toByte
    println(c)

    //基本数据类型转化成String   调用  toString 方法
    var str: String = a.toString
    println(str)

    //String转化成基本数据类型
    val b: Int = str.toInt
    println(b)
    //String 转成基本数据类型只能一步一步的转
    var d: String = "5.0"  //转成Int类型，需要先转成Double，再转成Int
    val dd: Int = d.toDouble.toInt
    println(dd)
  }

}
