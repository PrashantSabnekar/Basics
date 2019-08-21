package moniods

trait Moniod[A] {
  def op(a1: A, a2: A): A
  def zero: A
}

class StringMoniod extends Moniod [String] {

  override def op(a1: String, a2: String): String = {
    a1 + a2
  }

  override def zero: String = { "" }
}

class ListMonoid extends Moniod[List[String]] {
  override def op(a1: List[String], a2: List[String]): List[String] = {
    a1 ::: a2
  }

  override def zero: List[String] = Nil
}


object Test extends App {

  val s1 = "PartA"
  val s2 = "PartB"
  val sm = new StringMoniod
  val s3 = sm.op(s1,s2)
  println(s3)

  val l1 = List("One", "Two", "Three")
  val l2 = List("Four", "Five", "Six")

  val lm = new ListMonoid
  val res2 = lm.op(l1,l2)
  println(res2)

  val l3 = List("a", "b", "c")

  val res3 = lm.op(l3, lm.op(l1,l2))
  println(res3)

  val res4 = l3 ::: l1 ::: l2
  println(res4)
}
