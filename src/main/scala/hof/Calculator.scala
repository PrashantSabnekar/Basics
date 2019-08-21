package hof

class Calculator {

  //monomorphic add
  def add(x: Int, y: Int): Int = {
    x + y
  }

  def genericFun[A](x: A, y: A): Unit = {
    println(x)
    println(y)
  }

  def task(name: String, x: Int, y: Int, f: (Int, Int) => Int): Unit = {
    val res = f(x,y)
    println("Result of task: " + name + " is: " + res)
  }

  def hofDemo(): Unit = {
    task("Addition", 1,2, add)
  }

  def genericTask[A](a: A, b: A, f:(A,A) => Unit): Unit = {
    f(a,b)
  }

  def genericHofDemo(): Unit = {
    genericTask[String]("Hello", "Generic", genericFun)
    genericTask[Int](100, 200, genericFun)

  }
}

object Calculator {

  def main(args: Array[String]): Unit = {
    val c1 = new Calculator()
    c1.hofDemo()
    c1.task("new addition", 1,1, c1.add)
    c1.genericHofDemo()

    val greaterThan = new Function2[Int, Int, Boolean] {
      override def apply(v1: Int, v2: Int): Boolean = v1 > v2
    }

    val t = new Function2[String, String, String] {
      override def apply(v1: String, v2: String): String = v1 + v2
    }

    val res = greaterThan.apply(10, 20)
    println("Result = " + res)

    println(t.apply("one", "two"))
  }
}