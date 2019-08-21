package traits

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A] (head: A, tail: List[A]) extends List[A]

class MyDS {

  def demo()={
    val list: List[String] = Cons("One", Cons("Two", Nil))
    println(list)
  }

}

object List {
  def sum(list: List[Int]): Int =
    list match {
      case Nil => 0
      case Cons(x, y) => x + sum(y)
    }
}


object test{

  def main(args: Array[String]): Unit = {
    val ds = new MyDS
    ds.demo()
  }
}