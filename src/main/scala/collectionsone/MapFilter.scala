package collectionsone

class MapFilter {

}

object Demo extends App {


  val input = scala.collection.mutable.Map[String, Int]()

  input += ("One" -> 1)
  input += ("Two" -> 2)
  input += ("Three" -> 3)
  input += ("Four" -> 4)
  input += ("resp-queue" -> 100)
  input += ("resp-path" -> 200)
  input += ("next-chain-body" -> 300)

  println("Original Map")
  println(input)


  val cleanedInput = input.-("resp-queue", "resp-path", "next-chain-body")

  println("Cleaned Map")
  println(input)
  println(cleanedInput)







}
