package sixth;

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

    public boolean deplacer(int x, int y, int x2, int y2) {
        if((x < 0 || y < 0 || x >= LARGEUR || y >= LARGEUR) ||
           (x2 < 0 || y2 < 0 || x2 >= LARGEUR || y2 >= LARGEUR))
            return false;

        int piece = grille[x][y].getPiece().getPiece();

        switch(piece) {
            case Piece.PION:
                if(x != x2 && y != y2)
                    return  false;

                if(x != x2 && !testNbCasesDeplacement(x, x2, 1))
                    return false;
                else if(!testNbCasesDeplacement(y, y2, 1))
                    return false;
                break;
            case Piece.TOUR:
                if(x != x2 && y != y2)
                    return  false;
                break;
            case Piece.CAVALIER:
                // Si horizontal d'abord true, sinon false

                boolean typeDeplacement = true;

                if(!testNbCasesDeplacement(x, x2, 2))
                    typeDeplacement = false;
                if(!testNbCasesDeplacement(y, y2, 2))
                    return false;

                if((typeDeplacement && !testNbCasesDeplacement(y, y2, 1)) || !testNbCasesDeplacement(x, x2, 1))
                    return false;
            case Piece.FOU:
                    if(x != x2 && y != y2) {
                        if(x - x2 == y - y2);
                    }
                    else
                        return false;
                break;
            case Piece.DAME:
                // A completer
                if(x != x2 && y != y2) {
                    if(x - x2 == y - y2);
                }
                break;
        }

        return true;
    }

    private boolean testNbCasesDeplacement(int i, int j, int value) {
        int nbCasesDeplacement = i - j;
        return (nbCasesDeplacement == value || nbCasesDeplacement == -value);
    }
}
