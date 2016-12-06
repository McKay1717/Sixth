package model;

public class Pion {
    private int couleur;
    private Joueur joueur;

    public Pion(int couleur, Joueur joueur) {
        this.couleur = couleur;
        this.joueur = joueur;
    }

    public int getCouleur() {
        return couleur;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}