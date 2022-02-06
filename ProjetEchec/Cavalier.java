public class Cavalier extends Piece{

	public Cavalier(int x, int y, String couleur) {
		super(x, y,"Cavalier", couleur);
	}

	public boolean mouvementValide(int ligne, int colonne) {
	    int diffX = Math.abs(this.getLigne() - ligne);
	    int diffY = Math.abs(this.getColonne() - colonne);
	    if (diffX != 0 && diffY != 0 && (diffX + diffY) == 3 ){
	      return true; }

	    return false;
	}


	public String symbole() {
		if (this.getCouleur() == "blanc")
			return "Cb";
		return "Cn";
	}

	public boolean obstacle(Echequier e, int ligne, int colonne) {
    	return true;   // le cavalier a le droit de sauter 
  } // fin de la méthode obstacle

}// fin de la classe Cavalier
