package lab_1.task_8

import lab_1.task_5.Boot.Cat

object ChipShop extends App {

  def willServe(cat: Cat): Boolean = {
    cat match {
      case Cat(_,_,food) if food.equals("Chips") => true
      case _ => false
    }
  }

  println(willServe(Cat("Oswald", "Blue", "Chips"))) // true

}
