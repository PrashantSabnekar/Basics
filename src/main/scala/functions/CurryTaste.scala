package functions

object CurryTaste extends App {

  def filter(inputList: List[Int], f: Int => Boolean ): List[Int] = {
    if(inputList.isEmpty)
      inputList
    else if(f(inputList.head)) inputList.head :: filter(inputList.tail, f)
    else filter(inputList.tail, f)
  }

  def f(num: Int) (den: Int) = num % den ==0

  def demo() = {
    val l1 = List(1,2,3,4,5,6,7,8,9,10)
    val result1 = filter(l1, f(2))
    val result2 = filter(l1, f(3))
    println(result1)
    println(result2)


    abstract class Parent()
    case class Child(name: String) extends Parent()

    val c = Child("Child")
    println(c.name)

  }

  demo()
}





