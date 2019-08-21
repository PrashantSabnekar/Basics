package scopes

class Access {

  private def test()={
    println("Accessed")
  }

  def demo(obj: Access)={
    obj.test()
  }

}

object Test extends App {

  val x = new Access
  x.demo(x)


}