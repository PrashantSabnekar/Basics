package analysis

trait Monoid[A]{
  def op(a1: A, a2: A): A
  def zero: A
}


object JobManager extends App {

  val stringMonoid = new Monoid[String] {

    def op(s1: String, s2: String) = {
      s1 + s2
    }

    def zero(): String = {
      ""
    }

  }

  val res = stringMonoid.op("One", "Two")
  val res2 = stringMonoid.zero()
  println(res)
  println(res2)


  val stringListMoniod = new Monoid[List[String]] {
    override def op(a1: List[String], a2: List[String]): List[String] = a1 ++ a2
    override def zero: List[String] = Nil
  }

  val list1 = List("One", "Two", "Three")
  val list2 = List("111", "222", "333")
  val res3 = stringListMoniod.op(list1, list2)
  println(res3)
  val res4 = stringListMoniod.zero
  println(res4)

}
