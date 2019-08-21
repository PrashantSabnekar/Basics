package scopes.b

import scopes.a.DataA

class DataB extends DataA  {
  private val x2: Int = 2
  override  protected val y2: Int = 2

  val z2: Int = 2

  def access()={

    println("DataB access")

    val ob = new DataB
    println(ob.y)




  }
}
