package model;

/**
 * Created by ctx on 09/11/16.
 */

public class Grille {
    // On compte en commençant d'en haut à gauche

    public static final int LARGEUR = 5;
    public static final int PION_MAX = 30;

    private Case grille[][] = new Case[5][5];

    public Grille() {
        grille = new Case[LARGEUR][LARGEUR];
    }

    public Grille(Case[][] _grille) {
        grille = _grille;
    }

    public void addPiece(Piece piece, int x, int y) {
        grille[x][y] = new Case(piece);
    }

    // Retourne true s'il y a bien eu un déplacement, false sinon

    private boolean testNbCasesDeplacement(int i, int j, int value) {
        int nbCasesDeplacement = i - j;
        return (nbCasesDeplacement == value || nbCasesDeplacement == -value);
    }

    public Case getCase(int x, int y) {
        return grille[x][y];
    }
}