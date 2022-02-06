import java.util.*;
public class Echequier {
  public Case [][] plateau = new Case [8][8];

  public Echequier (){ // Constructeur d'un echequier avec pieceBlanche, pieceNoire et caseVide
    setCaseVide();
    setPieceBlanche();
    setPieceNoire();
  }


  public void setCaseVide() {
    for (int lig = 0; lig < 8; lig ++) {
      for (int col = 0; col < 8; col++){
        plateau [lig] [col] = new Case (lig,col);
      }
    }
  }

  public void setPieceNoire() {
    plateau [0][0].setPiece(new Tour(0,0,"noir"));
    plateau [0][1].setPiece(new Cavalier(0,1,"noir"));
    plateau [0][2].setPiece(new Fou(0,2,"noir"));
    plateau [0][3].setPiece(new Roi(0,3,"noir"));
    plateau [0][4].setPiece(new Dame(0,4,"noir"));
    plateau [0][5].setPiece(new Fou(0,5,"noir"));
    plateau [0][6].setPiece(new Cavalier(0,6,"noir"));
    plateau [0][7].setPiece(new Tour(0,7,"noir"));

    for (int col = 0; col < 8; col++){
      plateau[1][col].setPiece(new Pion(1,col,"noir"));
    }
  }

  public void setPieceBlanche() {
    plateau [7][1].setPiece(new Cavalier(7,1,"blanc"));
    plateau [7][2].setPiece(new Fou(7,2,"blanc"));
    plateau [7][3].setPiece(new Roi(7,3,"blanc"));
    plateau [7][0].setPiece(new Tour(7,0,"blanc"));
    plateau [7][4].setPiece(new Dame(7,4,"blanc"));
    plateau [7][5].setPiece(new Fou(7,5,"blanc"));
    plateau [7][6].setPiece(new Cavalier(7,6,"blanc"));
    plateau [7][7].setPiece(new Tour(7,7,"blanc"));

    for (int col = 0; col < 8; col++){
      plateau[6][col].setPiece(new Pion(6,col,"blanc"));
    }
  }

  public ArrayList getCadriage(){
    ArrayList <Case> list = new ArrayList();
    for(int lig =0; lig <8; lig++){
        for (int col=0; col < 8; col++){
          list.add(this.plateau[lig][col]);
        }
    }    return list;
  }

  public boolean deplacer(Echequier echequier, int ligD, int colD, int ligA, int colA) {
    if( ligD < 8 && ligD >=0 && colD < 8 && colD >= 0) {
      if (echequier.plateau[ligD][colD].getPiece().obstacle(echequier,ligA,colA)) {   // on verifie si il y a un obstacle (car une pièce ne peut sauter sur une autre sauf le cavalier)
        if (echequier.plateau[ligD][colD].getPiece().mouvementValide(ligA,colA)) { // si pas d'obstacle  on verifie que le mouvement est valide
      	   if (echequier.plateau[ligA][colA].caseVide()) {   // si oui si la case d'arriver est vide :
             Piece p = echequier.plateau[ligD][colD].getPiece();
             echequier.plateau[ligA][colA].setPiece(p);                  // on deplace tout simplement la pièce
             echequier.plateau[ligD][colD].retirerPiece();
             p.setLigne(ligA);
             p.setColonne(colA);            // on change les coordonnées de la pièces qui s'est déplacée
           }

           else {                                                 // sinon (si la case d'arriver n'est pas vide)
             String couleur = echequier.plateau[ligA][colA].getPiece().getCouleur();
             if(echequier.plateau[ligD][colD].getPiece().getCouleur() != couleur) {     // si la case d'arrivée est occupé par une pièce adverse:
               Piece p = echequier.plateau[ligD][colD].getPiece();
               echequier.plateau[ligA][colA].setPiece(p);                                // on se déplace et on mange donc la pièce sur la case d'arrivée
               echequier.plateau[ligD][colD].retirerPiece();
               p.setLigne(ligA);
               p.setColonne(colA);   }    // on change les coordonnées de la pièce qui s'est déplacée
        			}  // fin du else
            return true;
        }// fin du troisième if
        return false;   // si mouvement pas valide
      }// fin du deuxième if
      return false;   // si il y a un obstacle
    } // fin du premier if
    return false;
  }// fin de la méthode deplacer

  public void dessinerEchequier(){
   for(int lig = 0; lig < 8; lig ++){
      System.out.println("   --------------------------------------- ");
      System.out.print(8-lig);
      System.out.print(" | ");
      for(int col = 0; col < 8; col++){
        if (this.plateau[lig][col].getPiece() != null)
        	System.out.print(this.plateau[lig][col].getPiece().symbole());
        else
        	System.out.print("  ");
      System.out.print(" | ");
      }
      System.out.println();
   }
   System.out.println("   --------------------------------------- ");
   System.out.println("     a    b    c    d    e    f    g    h");
   System.out.println();
 }

public static void main (String [] args) {

	Echequier e = new Echequier();
	e.deplacer(e,1,0,2,0);
	e.deplacer(e,2,0,3,0);
	e.deplacer(e,3,0,4,0);
	e.deplacer(e,7,4,5,4);
	//e.deplacer(e,3,0,4,0);
  e.dessinerEchequier();
	}

}// fin classe Echiquier
