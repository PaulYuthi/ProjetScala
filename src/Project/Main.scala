package Project
import scala.collection.mutable.ListBuffer
import java.io.FileNotFoundException
import scala.io.Source

object Main extends App {

  // Chargement du fichier de consignes
  try {
    val fichier = Source.fromFile("Test_files/test.txt", "utf-8")
    val lignes: Iterator[String] = fichier.getLines()
    val liste: List[String] = lignes.toList

    // Creation de variables
    var max_coord = liste(0).split(" ")
    var position_initiale = ListBuffer[Array[String]]()
    var consignes = ListBuffer[String]()

    // Definir les lignes impaires comme étant les consignes de déplacements
    // Definir les lignes paires comme étant la position et l'orientation de la tondeuse
    for ((ligne, count) <- liste.zipWithIndex) {
      if (count > 0 && count % 2 == 1) {
        position_initiale += ligne.split(" ")
      }
      else if (count > 0 && count % 2 == 0) {
        consignes += ligne
      }
    }

    // Pour chaque tondeuse, creer un objet de la classe Tondeuse
    println("Position finale des tondeuses :")
    var i: Int = 0
    for ((position, consigne) <- position_initiale.zip(consignes)) {
      i += 1
      val tondeuse = new Tondeuse(
        (max_coord(0).toInt, max_coord(1).toInt),
        (position(0).toInt, position(1).toInt),
        position(2).charAt(0)
        )

      // Afficher le resultat final
      tondeuse.run(consigne)
      println(s"Tondeuse $i : $tondeuse")

    }
  } catch {case error: FileNotFoundException
    => println("Le fichier n'existe pas")
  case error: NumberFormatException
    => println("Les coordonnées renseignées n'ont pas le bon format")
  case error:ArrayIndexOutOfBoundsException
  => println("Les dimensions renseignées de la pelouse sont incomplètes")
  }
}
