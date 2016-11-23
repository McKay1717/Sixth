package model;

public class Pion {
    //Couleurs
    public static final int SANS_COULEUR = 0;
    public static final int ROUGE = -1;
    public static final int BLANC = -2;

    private int couleur;

    public Pion(int couleur) {
        this.couleur = couleur;
    }

    public int getCouleur() {
        return couleur;
    }
}
