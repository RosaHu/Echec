public class Dame extends Piece{

	public Dame(int x, int y, String couleur) {
		super(x, y,"Dame", couleur);
	}


	public boolean mouvementValide(int ligne,int colonne) {
		// deplacement en diagonale
    int diffLigne = Math.abs(this.getLigne() - ligne);
    int diffColonne = Math.abs(this.getColonne() - colonne);
    if (diffLigne == diffColonne)
      return true;

    //deplacement en ligne ou en colonne
    if (this.getLigne() == ligne || this.getColonne() == colonne)
      return true;

		return false;
	}

	public String symbole() {
		if (this.getCouleur() == "b")
			return "Db";
		return "Dn";
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
    }

    // deplacement en ligne ou en colonne
    // deplacement en colonne
    if (ligne == this.getLigne()){
      if (colonne > this.getColonne()){
        for (int i = colonne; i > this.getColonne(); i--){
          if(e.plateau[ligne][i].caseVide()){
            return true;
          }
          return false;
        }// fin du for
      }
      if (colonne < this.getColonne()){
        for (int i = colonne; i < this.getColonne(); i ++){
          if (e.plateau[ligne][i].caseVide()){
            return true;
          }
          return false;
        }// fin du for
      }
		}

    // deplacement en ligne
    if (colonne == this.getColonne()){
      if (ligne > this.getLigne()){
        for (int i = ligne; i > this.getLigne(); i--){
          if (e.plateau[i][colonne].caseVide()){
            return true;
          }
          return false;
        }// fin du for
      }
      if (ligne < this.getLigne()){
        for (int i = ligne; i < this.getLigne(); i++){
          if (e.plateau[i][colonne].caseVide()){
            return true;
          }
          return false;
        }// fin du for
      }
    } return false;

	}    // fin de la méthode obstacle

}// fin de la classe Dame
