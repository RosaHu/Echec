public class Pion extends Piece{

  public Pion(int l, int c,String couleur){
    super(l,c,"Pion",couleur);
  }
  public boolean mouvementValide(int ligne, int colonne){
      if (this.symbole() == "Pn"){
        if (this.getLigne() + 1 == ligne && this.getColonne() == colonne){
          return true;
        }
      }
      if (this.symbole() == "Pb"){
        if (this.getLigne() - 1 == ligne && this.getColonne() == colonne){
          return true;
        }
      }
      return false;

  } // fin de la methode mouvementValide

  public String symbole() {
	   if (this.getCouleur() == "blanc")
		   return "Pb";
	      else return "Pn";
	}

  public boolean obstacle(Echequier e, int ligne, int colonne) {
    return true;  // le pion ne peut jamais sauter car il se déplace toujours d'une case à la fois
  } // fin de la méthode obstacle

} // fin de la classe pion
