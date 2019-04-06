package lab_1.task_1

object Boot extends App {

  class Cat(name: String, colour: String, food: String)

  val oswald = new Cat("Oswald", "Black", "Milk")

  val henderson = new Cat("Henderson", "Ginger", "Milk")

  val quentin = new Cat("Quentin", "Tabby and white", "Curry")

  println(oswald)

}
