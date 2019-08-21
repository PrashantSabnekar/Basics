package asynchronous

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.ExecutionContext.global
import scala.concurrent.duration._

class FuturesDemo {

  implicit val baseTime = System.currentTimeMillis

  implicit val executor =  scala.concurrent.ExecutionContext.global

  val i1 = List("One", "Two", "Three")

  def getData(): String = {
    "Some Data"
  }

  def someTask(list: List[String]): Future[String] = {

    list.map(x => println(x))
    val f1 = Future{
      getData()
    }

    //    val resultf1 = Await.result(f1, 1 second)
    //    resultf1
    f1
  }

  def take1(): Unit = {
    val x = someTask(i1)
    println(x)


  }

  def someTask1(list: List[String]): String = {
    val f2 = Future {
      getData()
    }

    val result = Await.result(f2, Duration.Inf)
    result
  }
}

object FuturesDemo extends App {

  val fd = new FuturesDemo
  //println("Asynchronous" + fd.someTask(List("One", "Two", "Three")))
  //print("Synchronous" + fd.someTask1(List("One", "Two", "Three")))
  fd.take1()

}
