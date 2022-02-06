public class Roi extends Piece {

  public Roi(int l, int c,String couleur){
    super(l,c,"Roi",couleur);
  }

  public boolean mouvementValide(int ligne, int colonne){
    boolean deplacement = false;
    if (ligne == (this.getLigne()-1) && colonne == (this.getColonne()-1)) deplacement = true;            // on verifie si le deplacement prevu correspond a l'un des
    else if (ligne == (this.getLigne()-1) && colonne == (this.getColonne()+1) ) deplacement = true;      // 8 deplacement possible pour le roi
    else if (ligne == (this.getLigne()-1) && colonne == this.getColonne()) deplacement = true;           // si oui on retourne true, sinon, on retourne false
    else if (ligne == (this.getLigne()+1) && colonne == this.getColonne()) deplacement = true;
    else if (ligne == this.getLigne() && colonne == (this.getColonne()-1)) deplacement = true;
    else if (ligne == this.getLigne() && colonne == (this.getColonne()+1)) deplacement = true;
    else if (ligne == (this.getLigne()+1) && colonne == (this.getColonne()+1)) deplacement = true;
    else if (ligne == (this.getLigne()+1) && colonne == (this.getColonne()-1)) deplacement = true;

    if (deplacement == true){  return true;  }

    else return false;
} // fin de la methode deplacer

public String symbole() {
	if (this.getCouleur() == "blanc")
		return "Rb";
	else return "Rn";
	}

  public boolean obstacle(Echequier e, int ligne, int colonne) {
    return true;
  } // fin de la méthode obstacle

/*public boolean mouvementPossible(Echequier e){  // cette methode servira pour verifier si il y a echec et mat
  int lig = 0;
  while (lig < 8){
   int colonne = 0;
   while (col < 8){
       if (this.couleur=="noir"){    // si le roi est noir
            if(e[lig][col]  =="  "|| e[lig][col]=="Rb"|| e[lig][col]=="Pb"|| e[lig][col]=="Fb"|| e[lig][col]=="Tb"|| e[lig][col]=="Cb"|| e[lig][col] =="Db"){
                  if (this.mouvementValide(lig,colonne)) {return true; }
            }  // fin du 2ème if
       } // fin du 1er if
       else{  // sinon (si il (le Roi) est blanc)
              if(e[lig][col]==" "|| e[lig][col]=="Rn"|| e[lig][col]=="Pn"|| e[lig][col]=="Fn"|| e[lig][col]=="Tn"|| e[lig][col]=="Cn"|| e[lig][col]=="Dn"){
                    if (this.mouvementValide(lig,col)) {return true; }
              }
      }
      colonne +=1;
       } // fin boucle 2 (colonnes)
    ligne +=1;
    } // fin boucle 1 (lignes)
     return false;
 } // fin methode mouvementPossible  */
} // fin de la classe roi
