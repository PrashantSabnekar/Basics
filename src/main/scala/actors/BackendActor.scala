package actors

import akka.actor.{Actor, ActorRef}

class BackendActor(fa: ActorRef) extends Actor {

  override def receive: Receive = {
    case "SendMessageToFrontendActor" => fa ! "Merge"
    case "SomeResult" => println("Received message: SomeResult")
    case "BackendMerge" => println("Merge message received by backend actor")
    case _ => println("Unknown message received by backend actor")
  }
}
