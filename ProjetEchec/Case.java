public class Case {

  private int ligne;
  private int colonne;
  private Piece piece;

  public Case (int x, int y) { // Constructeur d'une case vide
    this.ligne = x;
    this.colonne = y;
    this.piece = null;
  }

  public Case (int x, int y, Piece piece) { // Constructeur d'une case avec une pièce
    this.ligne = x;
    this.colonne = y;
    this.piece = piece;
  }

  public int getLig() {
    return this.ligne;
  }

  public int getCol() {
    return this.colonne;
  }

  public Piece getPiece() {
    return this.piece;
  }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }

  public void retirerPiece() {
      this.piece = null;
  }

  public boolean caseVide() {
        if (this.piece == null) {
            return true;
        }
        return false;
    }

}
