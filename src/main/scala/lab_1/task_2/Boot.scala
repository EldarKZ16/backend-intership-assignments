package lab_1.task_2

object Boot extends App {

  class Director(firstName: String, lastName: String, val yearOfBirth: Int) {

    def name: String = firstName + " " + lastName

    override def toString: String = s"Director($name, $yearOfBirth)"

  }

  class Film(name: String, yearOfRelease: Int, imdbRating: Double, val director: Director) {

    def directorsAge: Int = yearOfRelease - director.yearOfBirth

    def isDirectedBy(director2: Director): Boolean = director == director2

    def copy(name: String = this.name,
             yearOfRelease: Int = this.yearOfRelease,
             imdbRating: Double = this.imdbRating,
             director: Director = this.director) = new Film(name, yearOfRelease, imdbRating, director)

    // ${'"'} for inserting symbol "
    override def toString: String = s"Film(${'"'}$name${'"'},$yearOfRelease,$imdbRating,$director)"

  }

  val eastwood = new Director("Clint","Eastwood", 1930)
  val mcTiernan = new Director("John","McTiernan", 1951)
  val nolan = new Director("Christopher","Nolan", 1970)
  val someBody = new Director("Just","SomeBody", 1990)
  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("DarkKnight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)
  val highPlainsDrifter  = new Film("HighPlainsDrifter", 1973, 7.7, eastwood)
  val outlawJoseyWales   = new Film("TheOutlawJoseyWales", 1976, 7.9, eastwood)
  val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = new Film("GranTorino", 2008, 8.2, eastwood)
  val invictus = new Film("Invictus", 2009, 7.4, eastwood)
  val predator = new Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = new Film("DieHard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = new Film("TheHuntforRedOctober", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = new Film("TheThomasCrownAffair", 1999, 6.8, mcTiernan)

  println(eastwood.yearOfBirth) //should be 1930
  println(dieHard.director.name) //should be "JohnMcTiernan"
  println(invictus.isDirectedBy(nolan)) // should be false

  println(highPlainsDrifter.copy(name ="L'hommedeshautesplaines")) // returns Film("L'hommedeshautesplaines",1973,7.7,/*etc*/)
  println(thomasCrownAffair.copy(yearOfRelease = 1968,director = new Director("Norman","Jewison", 1926))) // returnsFilm("TheThomasCrownAffair",1926,/*etc*/)
  println(inception.copy().copy().copy()) // returns a new copy of`inception`
}
