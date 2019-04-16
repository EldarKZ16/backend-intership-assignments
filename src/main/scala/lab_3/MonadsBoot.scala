package lab_3

object MonadsBoot extends App {

  // Task 1
  def division(x: Int, y: Int): Option[Int] = {
    y match {
      case 0 => None
      case num: Int => Some(x / num)
    }
  }

  // Task 2
  def readInt(str: String): Option[Int] =
    if(str matches "\\d+") Some(str.toInt) else None

  def calculator(operand1: String, operator: String, operand2: String): Option[Int] = {
    for {
      value1 <- readInt(operand1)
      value2 <- readInt(operand2) if (operator != "/" || value2 != 0)
    } yield {
      operator match {
        case "+" => value1 + value2
        case "-" => value1 - value2
        case "*" => value1 * value2
        case "/" => value1 / value2
      }
    }
  }

  calculator("10", "*", "2") match {
    case Some(value) => println(s"Success result is $value")
    case None => println(s"Error happened")
  }

  calculator("10", "/", "0") match {
    case Some(value) => println(s"Success result is $value")
    case None => println(s"Error happened")
  }

  def sumOfOptions(opt1: Option[Int], opt2: Option[Int], opt3: Option[Int]): Option[Int] = {
    for {
      value1 <- opt1
      value2 <- opt2
      value3 <- opt3
    } yield value1 + value2 + value3
  }

  val calculator1 = calculator("10", "*", "2")
  val calculator2 = calculator("5", "/", "5")
  val calculator3 = calculator("20", "+", "30")

  sumOfOptions(calculator1, calculator2, calculator3) match {
    case Some(value) => println(s"Success result is $value")
    case None => println(s"Error happened")
  }

  val calculator4 = calculator("10", "*", "2")
  val calculator5 = calculator("5", "+", "5")
  val calculator6 = calculator("20", "/", "0")

  sumOfOptions(calculator4, calculator5, calculator6) match {
    case Some(value) => println(s"Success result is $value")
    case None => println(s"Error happened")
  }
}
