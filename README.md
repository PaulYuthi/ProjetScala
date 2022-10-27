## Tondeuse.scala :
Ce fichier permet de créer une classe Tondeuse

A partir des arguments suivants 
- max_coord => Les coordonnées de la pelouse
- coord => Les coordonnées de la tondeuse
- orientation => L'orientation de la tondeuse

On peut traiter les déplacements dans l'espace des objets tondeuse


## Main.scala :
Ce fichier permet de 
- Charger le fichier texte de consignes 
- Lire le contenu de ce fichier
- Distinguer la première ligne (dimensions de la pelouse) des lignes impaires (coordonnées et orientation de la tondeuse), et des autres lignes paires (consignes de mouvements)
- Créer un nombre d'objets tondeuse égal au nombre de lignes impaires dans le fichier texte de consignes
- Executer les consignes de mouvement en appelant la fonction run() de la classe Tondeuse
