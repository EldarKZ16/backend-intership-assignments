package lab_1.task_7

object Boot extends App {

  def inc(x: Int, y: Int) = x + y
  def dec(x: Int, y: Int) = x - y
  def returnCount(x: Int, y: Int): Int = x

  case class CounterCase(count: Int = 0) {

    def copy(operation: (Int, Int) => Int = returnCount, num: Int = 1) : CounterCase = CounterCase(operation(count, num))

  }

  println(CounterCase().copy(inc).copy(dec).copy(inc,3).copy(inc).copy().count) // 4

}
