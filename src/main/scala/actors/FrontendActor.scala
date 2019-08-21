package actors

import akka.actor.Actor

class FrontendActor extends Actor {

  override def receive: Receive = {

    case "Merge" => println("Merge message received")
      sender() ! process()

    case _ => println("Unknown message received")
  }

  def process(): String = "SomeResult"
}
