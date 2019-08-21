package collectionss

class CollectionsDemo {

  def demo() = {
    val l = List(1,2,3,4,5,6,7,8,9,10)
    val en = l.filter(_ %2 == 0)
    println(en)
  }
}

object Main extends App {
  val x = new CollectionsDemo
  x.demo()
}
