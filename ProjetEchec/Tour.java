public class Tour extends Piece{

  public Tour (int ligne, int colonne,String couleur) {
    super(ligne, colonne,"Tour", couleur);
  }

  public boolean mouvementValide(int ligne, int colonne) {
    while (this.getLigne() == ligne || this.getColonne() == colonne) {
          return true;
    } // fin du while
   return false;
  }

  public String symbole() {
    if (this.getCouleur() == "blanc")
      return "Tb";
    else return "Tn";
  }

    public boolean obstacle(Echequier e, int ligne, int colonne) {
    int i = 0;
    boolean[] tab;
    if (this.getLigne() == ligne) {
      tab = new boolean[(Math.abs(this.getColonne() - colonne))];}
    else {
      tab = new boolean[(Math.abs(this.getLigne() - ligne))];}
    while (i < (Math.abs(this.getLigne() - ligne)) || i < (Math.abs(this.getColonne() - colonne))){
     if (e.plateau[this.getLigne() + i][this.getColonne()].caseVide() || e.plateau[this.getLigne()][this.getColonne() + i].caseVide())
        tab[i] = true;
     else
        tab[i] = false;
      i+= 1;
      for(int j = 0; i < tab.length;j++){
        if (tab[j] == true) {
          return true;
        } // fin if
        return false;
      } // fin de la boucle for
    } // fin du while
    return false;
  }

}// fin classe Tour
