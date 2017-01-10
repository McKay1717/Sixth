package model;

import exceptions.TailleMaximaleDepasseeException;

import java.io.Serializable;
import java.util.List;

public class Grille implements Serializable {
    public static final int LONGUEUR = 5;
    public static final int LARGEUR = 5;
    private static final long serialVersionUID = 1L;
    private Case[][] grille;

    public Grille() {
        grille = new Case[LONGUEUR][LARGEUR];
        for (int i = 0; i < LONGUEUR; i++)
            for (int j = 0; j < LARGEUR; j++)
                grille[i][j] = new Case();
    }

    public boolean addPion(int x, int y, Pion pion) throws TailleMaximaleDepasseeException {
        if(grille[x][y].isVide()) {
            grille[x][y].setPiece(new Piece(pion));
            return true;
        }

        return false;
    }

    private boolean deplacer(int x, int y, int x2, int y2) {
        Piece piece = grille[x][y].getPiece();
        int taillePiece = piece.getTaille();

            /*
            * @deplacerPion : teste s'il est déplacé d'une case en diagonale
            * @deplacerTour : teste si elle est bien déplacée orthogonalement
            * @deplacerCavalier : teste s'il est déplacé horizontalement de 2 cases, puis verticalement d'une case OU
            *                           s'il est déplacé verticalement de 2 cases, puis horizontalement d'une case
            * @deplacerFou : teste s'il est bien déplacé en diagonale
            * @deplacerDame : teste si elle effectue un déplacement de tour OU SOIT un déplacement de fou
            */

        boolean XEq = (x == x2), YEq = (y == y2);
        boolean deplacerPion = ((YEq && (x2 - x == 1 || x2 - x == -1)) ^ (XEq && (y2 - y == 1 || y2 - y == -1)));
        boolean deplacerTour = ((YEq && (x2 != x)) ^ (XEq && (y2 != y)));
        boolean deplacerCavalier = (
                ((x2 - x == 2 || x2 - x == -2) && (y2 - y == 1 || y2 - y == -1)) ||
                        ((y2 - y == 2 || y2 - y == -2) && (x2 - x == 1 || x2 - x == -1))
        );
        boolean deplacerFou = ((y - y2 == x - x2) ^ (y - y2 == -(x - x2)));
        boolean deplacerDame = deplacerTour ^ deplacerFou;

        if ((taillePiece == Piece.PION && deplacerPion) ||
                (taillePiece == Piece.TOUR && deplacerTour) ||
                (taillePiece == Piece.CAVALIER && deplacerCavalier) ||
                (taillePiece == Piece.FOU && deplacerFou) ||
                (taillePiece == Piece.DAME && deplacerDame)) {

            if (!grille[x2][y2].isVide()) {
                try {
                    grille[x2][y2].getPiece().add(grille[x][y].getPiece().getPions());
                    grille[x][y].deletePiece();
                    return true;
                } catch (TailleMaximaleDepasseeException e) {
                    e.getMessage();
                }

                return true;
            }
        }

        return false;
    }

    private boolean deplacerCondBase(int x, int y, int x2, int y2, int couleurJoueur) {
        return (grille[x][y] != null && grille[x][y].getPiece().getCouleur() == couleurJoueur &&
                x2 >= 0 && x2 < LONGUEUR && y2 >= 0 && y2 < LARGEUR);
    }

    public boolean deplacer(int x, int y, int x2, int y2, int couleurJoueur) {
        if(deplacerCondBase(x, y, x2, y2, couleurJoueur))
            return deplacer(x, y, x2, y2);

        return false;
    }

    // Déplace une pièce tout en la découpant

    public boolean deplacer(int x, int y, int x2, int y2, int decoupe, int couleurJoueur) {
        if (deplacerCondBase(x, y, x2, y2, couleurJoueur) && grille[x][y].getPiece().getTaille() > 1 &&
                decoupe >= 1 && decoupe < grille[x][y].getPiece().getTaille()) {
            List<Pion> tasBas = grille[x][y].getPiece().getPions(1, decoupe);
            List<Pion> tasHaut = grille[x][y].getPiece().getPions(decoupe + 1, grille[x][y].getPiece().getTaille());

            grille[x][y].setPiece(new Piece(tasHaut));

            if (!deplacer(x, y, x2, y2, couleurJoueur))
                return false;

            grille[x][y].setPiece(new Piece(tasBas));
            return true;
        }

        return false;
    }

    public Case getCase(int x, int y) {
        return grille[x][y];
    }

    public Piece getPiece(int x, int y) {
        return getCase(x, y).getPiece();
    }
}
