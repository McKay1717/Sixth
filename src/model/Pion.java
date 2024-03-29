package model;

import java.io.Serializable;

public class Pion implements Serializable {
    private static final long serialVersionUID = 1L;
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