import java.util.Scanner.*;
public class Joueur{
  private String couleur;
  private String nom;
//  private int nombreCoup;

  public Joueur(String c, String n){
    this.couleur = c;
    this.nom = n;

  }  // constructeur d'initialisation champs a champs

  public String getCouleur(){
    return this.couleur;
  }
  public void setCouleur(String c){
    this.couleur = c;
  }
  public String getNom(){
    return this.nom;
  }
  public void setNom(String n){
    this.nom = n;
  }
/*  public int getNombreCoup(){
    return this.nombreCoup;
  }
  public void setNombreCoup(int nb){
    this.nombreCoup = nb;
  }  // tous les getteurs et setters */



} // fin de la classe joueur
