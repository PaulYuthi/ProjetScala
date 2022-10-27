package Project

// Creation de la classe Tondeuse qui traite les consignes puis renvoie les coordonnées et l'orientation des objets tondeuse
class Tondeuse(val max_coord:(Int, Int),
               var coord:(Int, Int),
               var orientation:Char
               ){

  // Definir le format de sortie des coordonnees de la tondeuse
  override def toString: String = {
    s"${this.coord._1} ${this.coord._2} ${this.orientation}"
  }

  // Si la tondeuse avance, definir son mouvement dans l'espace
  def avancer: Unit = {
    this.coord = this.orientation match {

      case 'N' if this.coord._2 + 1 <= this.max_coord._2
      => (this.coord._1, this.coord._2 + 1)

      case 'E' if this.coord._1 + 1 <= this.max_coord._2
      => (this.coord._1 + 1, this.coord._2)

      case 'W' if this.coord._1 - 1 >= 0
      => (this.coord._1 - 1, this.coord._2)

      case 'S' if this.coord._2 - 1 >= 0
      => (this.coord._1, this.coord._2 - 1)

      case autre
      => this.coord
    }
  }

  // Definir l'orientation de la tondeuse en cas de rotation vers la gauche
  def gauche: Unit = {
    orientation = orientation match {
      case 'N' => 'W'
      case 'E' => 'N'
      case 'W' => 'S'
      case 'S' => 'E'
      case autre => orientation
    }
  }

  // Definir l'orientation de la tondeuse en cas de rotation vers la droite
  def droite: Unit = {
    orientation = orientation match {
      case 'N' => 'E'
      case 'E' => 'S'
      case 'W' => 'N'
      case 'S' => 'W'
      case autre => orientation
    }
  }

  // Appeler la fonction correspondant a la consigne indiquée dans le fichier
  def action(consigne: Char): Unit = {
    consigne match {
      case 'A' => this.avancer
      case 'G' => this.gauche
      case 'D' => this.droite
      case autre => orientation
    }
  }

  // Effectuer les consignes de mouvement
  def run(consigne: String): Unit = {
    for (c <- consigne) {
      this.action(c)
    }
  }

}
