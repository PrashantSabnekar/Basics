package actors

import akka.actor.{ActorSystem, Props}

object Demo extends App {

  val actorsystem = ActorSystem("mySystem")
  val fa = actorsystem.actorOf(Props[FrontendActor], "frontendActor")
  val ba = actorsystem.actorOf(Props(new BackendActor(fa)), "backendActor")

  ba ! "SendMessageToFrontendActor"

}
