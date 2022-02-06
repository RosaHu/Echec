public abstract class Piece{
  private int ligne;
  private int colonne;
  private String nomType;
  private String couleur;

  public Piece(int l,int c,String type,String couleur){
    this.ligne = l;
    this.colonne = c;
    this.nomType = type;
    this.couleur = couleur;
  } // constructeur d'initialisation champs a champs

  public int getLigne(){
    return this.ligne;
  }
  public int getColonne(){
    return this.colonne;
  }

  public String getNomType(){
    return this.nomType;
  }

  public String getCouleur(){
    return this.couleur;
  } // accesseur

  public void setLigne(int l){
    this.ligne = l;
  }

  public void setColonne(int c){
    this.colonne = c;
  }

  public void setCouleur(String couleur){
    this.couleur = couleur;
  } // mutateur

  public abstract String symbole();
  public abstract boolean mouvementValide(int ligne, int colonne);
  // methode qui return true s'il n'y a pas d'obstacle
  public abstract boolean obstacle(Echequier e, int ligne, int colonne);
  // methode qui va etre utilisé dans le déplacement. Cette methode vérifie lors d'un déplacement que entre la case de dépard et celle d'arrivée il n'y a aucune
  //pièce. Si c'est le cas  (obstacle return false)  le déplacement sera refuse.  


} // fin de la classe piece
