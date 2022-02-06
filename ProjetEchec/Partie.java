import java.util.*;
import java.util.Scanner;
import java.io.Writer;
import java.io.PrintWriter;

public class Partie{
    private Joueur j1;
    private Joueur j2;
    private Echequier plateau;
    private int compteur;


    // Constructeur  d'initialisation champs a champs
    public Partie(Joueur j1, Joueur j2, Echequier echequierPartie) {
    	this.j1 = j1;
    	this.j2 = j2;
    	this.plateau = echequierPartie;
    	this.compteur = 1;
    }
    public Partie(){
      initPartie();
    }  // constructeur qui va appeler initPartie pour créer un partie dynamiquement
    public Joueur getJ1() {
        return this.j1;
    }
    public void setJ1(Joueur j1) {
        this.j1 = j1;
    }
    public Joueur getJ2() {
        return this.j2;
    }
    public void setJ2(Joueur j2) {
        this.j2 = j2;
    }
    public int getCompteur(){
    	return this.compteur;
    }
    public void setCompteur(int c){
    	this.compteur = c;
    }
    public Echequier getEchequier() {
        return this.plateau;
    }
    public void setEchequier(Echequier echequierPartie) {
        this.plateau = echequierPartie;
    }     // tous les getteurs et setters
    
    
  public void initPartie(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Quel est le nom du joueur 1 ?");
	String NomJoueur1 = sc.nextLine();
	  System.out.println("Quel est le nom du joueur 2 ?");
	  String NomJoueur2 = sc.nextLine();
	  System.out.println("Qui commence à jouer ? (donner le nom du joueur) ");
	  String pj=sc.nextLine();
	  String CouleurJoueur1="";
	  String CouleurJoueur2="";
	  if (pj.equals(NomJoueur1)){
		CouleurJoueur1 ="blanc";
		CouleurJoueur2 ="noir";
	  }  // si c'est le j1 qui commence a jouer on lui attribut les pièces blanches et on attribut les pièces noir a l'autre joueur
	  else
		    if(pj.equals(NomJoueur2)){
		      CouleurJoueur1 ="noir";
		      CouleurJoueur2 ="blanc";
		    }
	Joueur j1 = new Joueur(CouleurJoueur1,NomJoueur1);
	Joueur j2 = new Joueur(CouleurJoueur2,NomJoueur2);   // creation des 2 joueurs (avec leurs couleurs et nom respectives)
	Echequier e = new Echequier();
	Partie p = new Partie(j1,j2,e);
	} // fin de la methode





   public void grandDeplacer(Echequier echequier, int ligD, int colD, int ligA, int colA,String couleur){
	
    	if (echequier.deplacer(echequier,ligD,colD,ligA,colA)){
    
        echequier.dessinerEchequier();    // on affiche l'echequier après déplacement
    	     
    	}     // si le deplacement s'est effectuer on imcrémente le compteur avant d'appeler "alternanceJoueur"

    	else
    			while (!(echequier.deplacer(echequier,ligD,colD,ligA,colA))){
    			
    			}        // tant que le joueur ne s'est pas déplacer, c'est a son tour de jouer

    } // fin methode grandDeplacer  
    
    public void tourJoueurBlanc(String couleur){ 
    	if (couleur == "blanc")   {
    		if (j1.getCouleur() == "blanc"){
    				
    		}
    	
    	}
    
    }
    


    /*public boolean testPat(Echequier e, String tour) {
        //MAT SANS LE PREMIER TEST//
        for(int i = 0; i<8;i++)
            for(int j = 0; j<8;j++) {
                if(e.plateau[i][j].getPiece() != null && e.plateau[i][j].getPiece().getCouleur() == tour)

                    for(int i2 = 0; i2<8; i2++)
                        for(int j2 = 0; j2<8; j2++) {

                            if(e.deplacer(e, j, i, j2, i2)) {
                                if(e.plateau[i][j].getPiece() instanceof Roi) {
                                    if(!this.testMat(e, j2, i2, tour)) {
                                        return false;
                                    }
                                }
                                else {
                                    Piece testTemp = e.plateau[i2][j2].getPiece();
                                    Piece p = e.plateau[i][j].getPiece();
                                    e.plateau[i2][j2].setPiece(p);
                                    e.plateau[i][j].retirerPiece();
                                    if(!this.testMat(e, x, y, tour)) {
                                        e.plateau[i][j].setPiece(e.plateau[i2][j2].getPiece());
                                        e.plateau[i2][j2].setPiece(testTemp);
                                        return false;
                                    }
                                    e.plateau[i][j].setPiece(e.plateau[i2][j2].getPiece());
                                    e.plateau[i2][j2].setPiece(testTemp);
                                }

                            }

                        }
                    }
        return true;
    }// fin de la méthode testPat */


  



/*
 public void sauvegarder(String nomFichier) {
      try
      {
      FileWriter fw = new FileWriter(nomFichier);
      BufferedWriter bw = new BufferedWriter(fw);
      for (int ligne=0;ligne<=7;ligne++)
        for (int colonne=0;colonne<=7;colonne++)
          if (this.getCase(ligne,colonne)!=null){
          bw.write(this.getCase(ligne,colonne).getNom()+"\t"+this.getCase(ligne,colonne).getCouleur()+"\t"+this.getCase(ligne,colonne).getLigne()+"\t"+this.getCase(ligne,colonne).getColonne()+"\n");
         }

          bw.close();
          fw.close();
          }catch (IOException e) {
      			System.err.println(e);
      		}
        }


    public void charger(String nomFichier){
      try{
      FileReader fr = new FileReader(nomFichier);
			BufferedReader br = new BufferedReader(fr);
      String line;
      line = br.readLine();
      while(line!=null){
        StringTokenizer st = new StringTokenizer(line,"\t");
        Piece p = new Piece();
        p.setNom(st.nextToken());
        p.setCouleur(st.nextToken());
        p.setLigne(Integer.parseInt(st.nextToken()));
        p.setColonne(Integer.parseInt(st.nextToken()));
        this.chargerPiece(p);
        line = br.readLine();
        }
        br.close();
        fr.close();
      }catch (IOException e) {
  			System.err.println(e);
  		}
    }

    public void chargerPiece(Piece p){
      if (p.getNomType()=="Pion") this.setCase(p.getLigne(),p.getColonne(),new Pion(p.getNom(),p.getCouleur(),p.getLigne(),p.getColonne()));
      if (p.getNomType()=="Dame") this.setCase(p.getLigne(),p.getColonne(),new Dame(p.getNom(),p.getCouleur(),p.getLigne(),p.getColonne()));
      if (p.getNomType()=="Tour") this.setCase(p.getLigne(),p.getColonne(),new Tour(p.getNom(),p.getCouleur(),p.getLigne(),p.getColonne()));
      if (p.getNomType()=="Fou") this.setCase(p.getLigne(),p.getColonne(),new Fou(p.getNom(),p.getCouleur(),p.getLigne(),p.getColonne()));
      else this.setCase(p.getLigne(),p.getColonne(),new Roi(p.getNom(),p.getCouleur(),p.getLigne(),p.getColonne()));

    }  */
    
    public static  void main(String arg[]){
    Partie p = new Partie();
    }


} // fin de la classe
