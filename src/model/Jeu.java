package model;

import exceptions.TailleMaximaleDepasseeException;

import static model.Grille.LARGEUR;
import static model.Grille.LONGUEUR;
import static model.Piece.ROI;

public class Jeu {
    public static final int BLANC = -1;
    public static final int ROUGE = -2;
    private static final int NB_JOUEURS = 2;
    private static final int COULEUR_PREMIER_JOUEUR = BLANC;
    private Joueur[] joueurs;
    private Grille grille;

    public Jeu() {
        grille = new Grille();
        joueurs = new Joueur[NB_JOUEURS];
    }

    public void deplacer(int x, int y, int x2, int y2) {
        grille.deplacer(x, y, x2, y2);
    }

    public void saveScores() {
    }

    public void addPion(int x, int y, Pion pion) throws TailleMaximaleDepasseeException {
        grille.addPion(x, y, pion);
    }

    public boolean finDePartie() {
        for (int i = 0; i < LONGUEUR; i++)
            for (int j = 0; j < LARGEUR; j++)
                if (grille.getPiece(i, j).getTaille() == ROI)
                    return true;
        return false;
    }

    public Case getCase(int x, int y) {
        return grille.getCase(x, y);
    }

    public Piece getPiece(int x, int y) {
        return grille.getPiece(x, y);
    }
}