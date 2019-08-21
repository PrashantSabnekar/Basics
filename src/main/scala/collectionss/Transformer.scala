package collectionss

class Transformer {

  def demoMap(): Unit = {
    val cars = Vector("maruti", "mercedes", "skoda", "bmw", "audi")

    val cars2 = cars.map(x => x.capitalize)
    println(cars2)

    val cars3 = cars.map(_.toUpperCase)
    println(cars3)

    val cars4 = cars.map(_.length)
    println(cars4)

    val xmlcars = cars.map(c => c.contains('A'))
    print(xmlcars)
  }

  def flattenDemo(): Unit = {
    val l = List(List(1,2), List("Apple", "Mango"), List(100,200, "Hello"))
    val fl = l.flatten
    println(fl)

    val l2 = List("Apple", "Mango")
    val fl2 = l2.flatten
    println(fl2)

    val couples = Map("A" -> "a", "B" -> "b", "C" -> "c")
//    val all = couples.flatten
//    println(all)


  }

  def toInt(i: String): Option[Int] = {
    try {
      Some(Integer.parseInt(i.trim))
    } catch {
      case e: Exception => None
    }
  }

  def flatMapDemo(): Unit = {
    val l = List("1","2","Hello", "100")
    val res = l.flatMap(toInt).sum
    println(res)
  }

}

object main extends App {

  val o = new Transformer
  o.flatMapDemo()
  o.flattenDemo()
  o.demoMap()
}
