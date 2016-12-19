package model;

import exceptions.TailleMaximaleDepasseeException;

import java.io.Serializable;

public class Grille implements Serializable {
    static final int LONGUEUR = 5;
    static final int LARGEUR = 5;
    private static final long serialVersionUID = 1L;
    private Case[][] grille;

    public Grille() {
        grille = new Case[LONGUEUR][LARGEUR];
        for (int i = 0; i < LONGUEUR; i++)
            for (int j = 0; j < LARGEUR; j++)
                grille[i][j] = new Case();
    }

    public void addPion(int x, int y, Pion pion) throws TailleMaximaleDepasseeException {
        //TODO Vérifier si la case possède déjà ou non une pièce.
        Piece piece = new Piece(pion.getCouleur(), pion);
        grille[x][y].setPiece(piece);
    }

    public boolean deplacer(int x, int y, int x2, int y2) {
        if (grille[x][y] != null) {
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
                grille[x2][y2] = grille[x][y];
                grille[x][y] = null;
                return true;
            }
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
