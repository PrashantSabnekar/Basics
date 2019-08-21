package exceptions

class Process {

  def step1(input1: String) = {

    input1 match {
      case "One" => println("One")
      case _ => throw new InvalidTaskException("Invalid Task Found")
    }

  }

  def demo() = {
    try {
      step1("One")
      step1("Two")
    } catch {
      case a: InvalidTaskException => println("Invalid Task Exception Handled")
    }

  }

  def sample() = {
    demo()
  }

}

object Test extends App {
  val p1 = new Process
  p1.sample()
}
