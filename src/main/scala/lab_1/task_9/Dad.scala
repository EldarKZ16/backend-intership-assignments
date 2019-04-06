package lab_1.task_9

import lab_1.task_6.Boot.{Director, Film}

object Dad extends App {

  def rate(film: Film):Double = {
    film match {
      case Film(_,_,_,director) if director.name.equals("Clint Eastwood") => 10.0
      case Film(_,_,_,director) if director.name.equals("John McTiernan") => 7.0
      case _ => 3.0
    }
  }

  val eastwood = Director("Clint","Eastwood", 1930)
  val mcTiernan = Director("John","McTiernan", 1951)
  val nolan = Director("Christopher","Nolan", 1970)
  val darkKnight = Film("DarkKnight", 2008, 9.0, nolan)
  val highPlainsDrifter = Film("HighPlainsDrifter", 1973, 7.7, eastwood)
  val thomasCrownAffair = Film("TheThomasCrownAffair", 1999, 6.8, mcTiernan)

  println(rate(darkKnight)) // 3.0
  println(rate(highPlainsDrifter)) // 10.0
  println(rate(thomasCrownAffair)) // 7.0
}
