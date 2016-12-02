package model;

import exception.TailleMaximaleDepasseeException;

import static model.Piece.ROI;

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

        for(int i = 0; i < LARGEUR; i++) {
            for(int j = 0; j < LARGEUR; j++) {
                if(grille[i][j] != null)
                    System.out.println("not null value" + grille[i][j]);
            }
        }
    }

    public Grille(Case[][] _grille) {
        grille = _grille;
    }

    public void poserPion(int x, int y, Pion pion){
        Piece piece = new Piece(pion);
        grille[x][y] = new Case(piece);
    }

    public boolean deplacerPiece(int x, int y, int x2, int y2) {
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
            boolean deplacerFou = ((y - y2 == x - x2) || (y - y2 == -(x - x2)));
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

    public Case[][] getCases() {
        return grille;
    }
    
    public Case getCase(int x, int y) {
        return grille[x][y];
    }

    public boolean finDePartie() {
        for (int i = 0; i < LARGEUR; i++)
            for (int j = 0; j < LARGEUR; j++)
                if (grille[i][j].getPiece().getTaille() == ROI)
                    return true;
        return false;
    }
}
