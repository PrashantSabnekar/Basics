package hof.currying

class CurryDemo {

  def add(x: Int)(y:Int): Int = {
    x + y
  }

  def add2(x: Int) = {
    (y: Int) => x + y
  }

  def name(firstName: String) = {
    (lastName: String) => firstName + " " + lastName
  }

  def demo(): Unit = {
    val res = add(1)(2)
    println(res)

    val f = add2(10)(20)
    println(f)

    val funLiteral = add2(100)
    println(funLiteral)

    val res1 = funLiteral.apply(200)
    println(res1)

    val fullName = name("Prashant")("Sabnekar")
    println(fullName)

    val funLiteral2 = name("Prashant")
    val funnName2 = funLiteral2.apply("Sabnekar")
    println(funnName2)
  }



}

object CurryDemo {
  def main(args: Array[String]): Unit = {
    val c = new CurryDemo()
    c.demo()
  }
}
