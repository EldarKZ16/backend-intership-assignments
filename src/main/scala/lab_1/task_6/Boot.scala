package lab_1.task_6

object Boot extends App {

  // What we can cut out ?

  // 1. val before yearOfBirth and director
  // 2. copy method
  // 3. toString method
  // 4. isDirectedBy method (instead of invictus.isDirectedBy(nolan), we can simply write invictus.director == nolan)
  // 5. new (instead of new Director, write Director)

  case class Director(firstName: String, lastName: String, yearOfBirth: Int) {

    def name: String = firstName + " " + lastName

  }

  case class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {

    def directorsAge: Int = yearOfRelease - director.yearOfBirth

  }

  val eastwood = Director("Clint","Eastwood", 1930)
  val mcTiernan = Director("John","McTiernan", 1951)
  val nolan = Director("Christopher","Nolan", 1970)
  val someBody = Director("Just","SomeBody", 1990)
  val memento = Film("Memento", 2000, 8.5, nolan)
  val darkKnight = Film("DarkKnight", 2008, 9.0, nolan)
  val inception = Film("Inception", 2010, 8.8, nolan)
  val highPlainsDrifter = Film("HighPlainsDrifter", 1973, 7.7, eastwood)
  val outlawJoseyWales = Film("TheOutlawJoseyWales", 1976, 7.9, eastwood)
  val unforgiven = Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = Film("GranTorino", 2008, 8.2, eastwood)
  val invictus = Film("Invictus", 2009, 7.4, eastwood)
  val predator = Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = Film("DieHard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = Film("TheHuntforRedOctober", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = Film("TheThomasCrownAffair", 1999, 6.8, mcTiernan)

  println(eastwood.yearOfBirth) //should be 1930
  println(dieHard.director.name) //should be "JohnMcTiernan"
  println(invictus.director == nolan) // should be false

  println(highPlainsDrifter.copy(name ="L'hommedeshautesplaines")) // returns Film("L'hommedeshautesplaines",1973,7.7,/*etc*/)
  println(thomasCrownAffair.copy(yearOfRelease = 1968, director = Director("Norman","Jewison", 1926))) // returnsFilm("TheThomasCrownAffair",1926,/*etc*/)
  println(inception.copy().copy().copy()) // returns a new copy of`inception`
}

