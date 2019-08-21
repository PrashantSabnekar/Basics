package traits

trait Specie {

  def describe(): Unit = {
    println("This is a specie")
  }
}

trait Animal {
  def describe(): Unit = {
    println("This is an animal")
  }
}

trait Human {
  def describe(): Unit = {
    println("This is a human")
  }
}

class Person extends Specie with Animal with Human {

  // by default the super will call the right most trait ie. Human,
  // to consider a different trait we need to specify it explicitly in [ ]
  override def describe(): Unit = super[Specie].describe()

  def test(): Unit = {
    describe()
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    val p1 = new Person()
    p1.describe()

  }
}