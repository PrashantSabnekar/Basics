package tasks

import monix.eval.Task
import scala.concurrent.Await
import scala.concurrent.duration.Duration

class TasksDemo {

  def taskUser() = {

  }

}

object TaskInvestigation extends App {

  val taskA = Task {
    debug("Starting taskA")
    Thread.sleep(1000)
    debug("Finished taskA")
  }

  val taskB = Task {
    debug("Starting taskB")
    Thread.sleep(2000)
    debug("Finished taskB")
  }

  import monix.execution.Scheduler.Implicits.global

  debug("Starting Main")
  val futureA = taskA.runAsync
  val futureB = taskB.runAsync
  debug("Continuing Main")

  Await.result(futureA zip futureB, Duration.Inf)

  def debug(msg: String): Unit = {
    val now = java.time.format.DateTimeFormatter.ISO_INSTANT
      .format(java.time.Instant.now)
      .substring(11, 23)
    val thread = Thread.currentThread.getName()
    println(s"$now [$thread] $msg")
  }

}