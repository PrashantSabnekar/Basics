package asynchronous

import scala.concurrent.{Future, Promise}
import scala.util.Success

class AsyncDemo {

  def asyncAdd(x: Int, y: Int, callbackFun: (Int) => Unit)={
    println("Thread Id: " + Thread.currentThread().getId + ", Heavy computations starts here ...")
    val thread = new Thread(new Runnable {
      override def run(): Unit = {
        Thread.sleep(10000)
        val res = x + y
        println("Thread Id: " + Thread.currentThread().getId + ", Thread processing is completed ...")
        callbackFun(res)
      }
    }
    )

    thread.start()
    thread
  }

  def callback(result: Int)={
    println("Thread Id: " + Thread.currentThread().getId + ", The result is: " + result)
  }

  def demo()={
    val th = asyncAdd(100,200, callback)
    //while(true) {
      println("Thread Id: " + Thread.currentThread().getId + ", Performing other activities while callback function gets called")
      //Thread.sleep(1000)
    //}
    th.join()
    println("Thread Id: " + Thread.currentThread().getId + ", Done")
  }

  def asyncAddWithPromise(x: Int, y: Int): Future[Int] = {
    val promise = Promise[Int]()
    val th = new Thread(new Runnable {
      override def run(): Unit = {
        Thread.sleep(2000)
        promise.success(x+y)
      }
    })
    th.start()
    promise.future
  }

  def promiseDemo()={
    val future = asyncAddWithPromise(10,20)
    Thread.sleep(5000)
    val Some(Success(result)) = future.value

    println("Res = " + result)
  }
}

object AsyncDemo {
  def main(args: Array[String]): Unit = {
    val asyc = new AsyncDemo()
    asyc.demo()
    asyc.promiseDemo()
  }
}