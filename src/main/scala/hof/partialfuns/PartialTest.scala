package hof.partialfuns

class PartialTest {

  def f1(a: Int, b: Double): String = {
    println("inside f1")
    a.toString + b.toString
  }

  def partial1[A,B,C](a: A, f:(A,B) => C): B => C= {
    println("inside partial1")
    (b: B) => f(a,b)
  }

  def partialDemo1(v1: Int, v2: Double) = {
    val res = partial1[Int, Double, String](v1, f1)
    val r1 = res.apply(v2)
    println(r1)
  }

  def partial2(i: Int, d: Double, l: Long): String = {
    val res = i + d.toInt + l.toInt
    res.toString
  }

  def newPartial[A,B,C,D] (a: A, b: B, c: C, f:(A,B,C) => D): (A,B,C) => D = {
        (a: A, b: B, c: C) => f(a,b,c)
  }

  def partial2Demo(v1: Int, v2: Double, v3: Long): Unit = {
    val funLiteral = newPartial[Int, Double, Long, String](v1, v2, v3, partial2)
    val res = funLiteral.apply(v1,v2,v3)
    println(res)
  }
}

object PartialTest {

  def main(args: Array[String]): Unit = {
    val p1 = new PartialTest
    p1.partialDemo1(100, 123.456)
    p1.partial2Demo(111, 123.456, 987654321)
  }
}