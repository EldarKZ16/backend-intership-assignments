package lab_1.task_5

object Boot extends App {

  case class Cat(name: String, colour: String, food: String)

  val oswald = Cat("Oswald", "Black", "Milk")

  val henderson = Cat("Henderson", "Ginger", "Milk")

  val quentin = Cat("Quentin", "Tabby and white", "Curry")

  println(oswald)

}
