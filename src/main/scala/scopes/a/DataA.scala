package scopes.a

class DataA {
  private[scopes] val x: Int = 1

  protected val y: Int = 1
  protected[this] val y2: Int = 1

  val z: Int = 1

  private[this] val name = "Prashant"
  private val last_name = "Sabnekar"

  def access(otherInstance: DataA)= {
    println(name)
    println(otherInstance.last_name)
    //println(otherInstance.name)
  }
}
object Test {
  var x = 100
}

class DataAA extends DataA {

  def access2(otherInstance: DataAA) = {
    println(y2)
    //println(otherInstance.y2)

  }
}
