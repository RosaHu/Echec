public class Fou extends Piece{

  public Fou(int l, int c,String couleur){
    super(l,c,"Fou",couleur);   // constructeur d'initialisation champs a champs avec super (qui va appeller le constructeur de la classe mere "piece")
  }

  // le fou se deplace comme il veut sur les diagonales, du moment que la case d'arrivée est de sa couleur
  public boolean mouvementValide(int ligne, int colonne){
    int diffLigne = Math.abs(this.getLigne()-ligne);
    int diffColonne = Math.abs(this.getColonne()-colonne);
    while (diffLigne == diffColonne){
      return true;
    }
    return false;
  } // fin de la methode mouvementValide

  public String symbole() {
    if (this.getCouleur() == "blanc")
      return "Fb";
    else return "Fn";
  }

  // return true s'il n'y a pas d'obstacle
  public boolean obstacle(Echequier e, int ligne, int colonne) {
    // deplacement en diagonale
    // deplacement vers le haut droit
    if (ligne < this.getLigne() && colonne > this.getColonne()) {
    		while (this.getLigne() != ligne + 1 && this.getColonne() != colonne - 1){
    			if(e.plateau[ligne+1][colonne-1].caseVide()){
    				return true;
    			}
    			ligne ++;
    			colonne --;
    		}// fin du while
    		return false;
    }

    // deplacement vers le haut gauche
    if (ligne < this.getLigne() && colonne < this.getColonne()){
      while(this.getLigne() != ligne + 1 && this.getColonne() != colonne + 1){
        if(e.plateau[ligne + 1][colonne + 1].caseVide()){
          return true;
        }
        ligne ++;
        colonne ++;
      }// fin du while
      return false;
    }

    // deplacement vers le bas droite
    if (ligne > this.getLigne() && colonne > this.getColonne()) {
    		while (this.getLigne() != ligne - 1 && this.getColonne() != colonne - 1){
    			if(e.plateau[ligne - 1][colonne - 1].caseVide()){
    				return true;
    			}
    			ligne --;
    			colonne --;
    		}// fin du while
    		return false;
    }

    // deplacement vers le bas gauche
    if (ligne > this.getLigne() && colonne < this.getColonne()){
      while(this.getLigne() != ligne - 1 && this.getColonne() != colonne + 1){
        if(e.plateau[ligne - 1][colonne + 1].caseVide()){
          return true;
        }
        ligne --;
        colonne ++;
      }// fin du while
      return false;
    }   return false;

	} // fin de la méthode obstacle


} // fin de la classe fou
