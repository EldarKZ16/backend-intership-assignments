package lab_2

object Boot extends App {

  case class Film( name: String,
                   yearOfRelease: Int,
                   imdbRating: Double)
  case class Director( firstName: String,
                       lastName: String,
                       yearOfBirth: Int,
                       films: Seq[Film])

  val memento = new Film("Memento", 2000, 8.5)
  val darkKnight = new Film("Dark Knight", 2008, 9.0)
  val inception = new Film("Inception", 2010, 8.8)
  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9)
  val unforgiven = new Film("Unforgiven", 1992, 8.3)
  val granTorino = new Film("Gran Torino", 2008, 8.2)
  val invictus = new Film("Invictus", 2009, 7.4)
  val predator = new Film("Predator", 1987, 7.9)
  val dieHard = new Film("Die Hard", 1988, 8.3)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8)
  val eastwood = new Director("Clint", "Eastwood", 1930,
    Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))
  val mcTiernan = new Director("John", "McTiernan", 1951,
    Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))
  val nolan = new Director("Christopher", "Nolan", 1970,
    Seq(memento, darkKnight, inception))
  val someGuy = new Director("Just", "Some Guy", 1990,
    Seq())
  val directors = Seq(mcTiernan, nolan, someGuy, eastwood)


  // Task 1
  val numberOfFilms = 2
  val directorsWhoHasALotOfFilmsList = (numberOfFilms: Int) => {
    directors.filter(director => director.films.size > numberOfFilms)
  }
  val directorsWhoHasALotOfFilmsString = directorsWhoHasALotOfFilmsList(numberOfFilms).map(director => s"${director.firstName} ${director.lastName}").mkString(", ")
  println(s"Task 1: All directors who have directed more than $numberOfFilms films: $directorsWhoHasALotOfFilmsString\n")

  // Task 2
  val year = 1960
  def directorsWhoBornBeforeYear(year: Int) = {
    directors.find(director => director.yearOfBirth < year)
  }
  val directorsWhoBornBeforeYearString = directorsWhoBornBeforeYear(year) match {
    case Some(director) => s"${director.firstName} ${director.lastName}"
    case _ => s"No director"
  }
  println(s"Task 2: A director who was born before $year is $directorsWhoBornBeforeYearString\n")


  // Task 3
  val yearOfBirth = 1990
  val numbOfFilms = 3
  val directorWithFilmsAndYearList = (year: Int, numberOfFilms: Int) => {
    directors.filter(director => director.yearOfBirth < year && director.films.size > numberOfFilms)
  }
  val directorWithFilmsAndYearString = directorWithFilmsAndYearList(yearOfBirth, numbOfFilms).map(director => s"${director.firstName} ${director.lastName}").mkString(", ")
  println(s"Task 3: Directors who were born before $yearOfBirth who have also directed more than than $numbOfFilms films : $directorWithFilmsAndYearString\n")

  // Task 4
  val ascending = false
  def directorSortAgeList(ascending: Boolean = true) = {
    if (ascending)
      directors.sortWith(_.yearOfBirth < _.yearOfBirth)
    else
      directors.sortWith(_.yearOfBirth > _.yearOfBirth)
  }
  val ascOrDes = if (ascending) "ascending" else "descending"
  val directorSortAgeString = directorSortAgeList(ascending).map(director => s"${director.firstName} ${director.lastName} in ${director.yearOfBirth}").mkString(", ")
  println(s"Task 4: Sort the directors by age in the $ascOrDes order\n$directorSortAgeString\n")

  // Task 5
  val nolanFilmsList = nolan.films.map(film => film.name)
  val nolanFilmsString = nolanFilmsList.mkString(", ")
  println(s"Task 5: The names of the films directed by Christopher Nolan: $nolanFilmsString\n")

  // Task 6
  val directorsFilmsList = directors.flatMap(director => director.films).map(film => film.name)
  val directorsFilmsString = directorsFilmsList.mkString(", ")
  println(s"Task 6: The names of all films by all directors: \n$directorsFilmsString\n")

  // Task 7
  val mcTiernanVintage = mcTiernan.films.minBy(film => film.yearOfRelease)
  println(s"Task 7: The date of the earliest McTiernan's film is ${mcTiernanVintage.yearOfRelease}\n")

  // DirectorsListOfFilms for tasks 8,9,11
  val directorsListOfFilms = directors.flatMap(director => director.films)

  // Task 8
  val directorsFilmsIMDBList = directorsListOfFilms.sortWith(_.imdbRating > _.imdbRating)
  val directorsFilmsIMDBString = directorsFilmsIMDBList.map(film => s"${film.name} ${film.imdbRating}").mkString(", ")
  println(s"Task 8: All films sorted by descending IMDB rating:\n$directorsFilmsIMDBString\n")

  // Task 9
  val directorsFilmAverageScore = (directorsListOfFilms.foldLeft(0.0)((acc, films) => acc + films.imdbRating)) / directorsListOfFilms.size
  println(f"Task 9: Average score across all films is $directorsFilmAverageScore%.1f\n")

  // Task 10
  def directorsPrintFilm() = directors.foreach(director => director.films.foreach(film => println(s"Tonight only! ${film.name} by ${director.firstName} ${director.lastName}!")))
  println("Task 10: Tonight’s Listings.")
  directorsPrintFilm()
  println()

  // Task 11
  val directorsEarliestFilm = directorsListOfFilms.minBy(film => film.yearOfRelease)
  println(s"Task 11: From the Archives.\nThe earlist film is ${directorsEarliestFilm.name} released in ${directorsEarliestFilm.yearOfRelease}.")

}