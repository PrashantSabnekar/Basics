package json


case class Job(jobName: String)
case class Input(input: Job)
class Marshelling {

  def getJson(): String = {

    val job1 = Job("Test-Job")
    val input1 = Input(job1)

//    val mapper = new ObjectMapper()
 //   mapper.registerModule(DefaultScalaModule)

""
  }

}

object Test extends App {

  val marshel = new Marshelling()
  println(marshel.getJson())

}
