package types

class GrandParent(description: String) {
  def info() = {
    println(description)
  }
}

class Parent(desc: String) extends GrandParent(desc) {}
class Child(description: String) extends GrandParent(description: String) {}

class Invariant[A] {
    def describe(a: A): Unit ={

    }
}

class Covariant[+A]
class ContraVariant[-A]



class TypesDemo {

  def test() ={
    val c = new Child("Child")
    c.info()
    val p = new Parent("Parent")
    p.info()
    val gp = new GrandParent("Grand Parent")
    gp.info()
  }

  def invariantType(it: Invariant[Parent]): Unit = { }
  def covariantType(ct: Covariant[Parent]): Unit= {}
  def contravariantType(ct: ContraVariant[Parent]): Unit = {}

}

object Main extends App {

  val td = new TypesDemo
  td.test()

  val c = new Child("Child")
  val p = new Parent("Parent")
  val gp = new GrandParent("Grand Parent")

  val ct = new Covariant[Parent]
  val iv = new Invariant[Parent]
  val cv = new ContraVariant[Parent]



  td.contravariantType(cv)
  td.covariantType(ct)


}
