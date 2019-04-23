package akka_examples

import akka.actor.{Actor, ActorLogging, Props}

object IotSupervisor {
  def props: Props = Props(new IotSupervisor)
}

class IotSupervisor extends Actor with ActorLogging {

  override def preStart(): Unit = log.info("Iot App started")

  override def postStop(): Unit = log.info("Iot App stopped")

  override def receive: Receive = Actor.emptyBehavior

}
