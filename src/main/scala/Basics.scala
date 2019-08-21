class Basics {


}

object Test extends App {

  val x = 100
  val y = "Hello"
  val x2:AnyRef = new Integer(100)
  val x3:AnyRef = new Integer(100)
  print( x3.eq(x2))
}
