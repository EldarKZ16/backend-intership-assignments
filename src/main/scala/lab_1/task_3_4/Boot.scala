package lab_1.task_3_4

object Boot extends App {

  class Counter(val count: Int) {

    def inc: Counter = new Counter(count+1)

    def dec: Counter = new Counter(count-1)

    // Task 4
    // Overloading methods

    def inc(num: Int = 1): Counter = new Counter(count+num)

    def dec(num: Int = 1): Counter = new Counter(count-num)

    def copy(count: Int = this.count) = new Counter(count)

  }

  println(new Counter(10).inc.dec.inc.inc.count)

}
