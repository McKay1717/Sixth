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

        // ATTENTION LES YEUX !!!
        if((piece == Piece.PION && (x == x2 ^ y == y2) && ((x == x2 && testNbCasesDeplacement(x, x2, 1))) ^ (testNbCasesDeplacement(y, y2, 1))) ||
           (piece == Piece.TOUR && (x == x2 ^ y == y2)) ||
           (piece == Piece.CAVALIER && ((testNbCasesDeplacement(x, x2, 2) && testNbCasesDeplacement(y, y2, 1)) ^ (testNbCasesDeplacement(y, y2, 2) && testNbCasesDeplacement(x, x2, 1)))) ||
           (piece == Piece.FOU && (x != x2 && y != y2 && ((x - x2 == y - y2) ^ (-(x - x2) == y - y2) ^ (x - x2 == -(y - y2))))) ||
           (piece == Piece.DAME && ((x == x2 ^ y == y2) ^ (x != x2 && y != y2 && ((x - x2 == y - y2) ^ (-(x - x2) == y - y2) ^ (x - x2 == -(y - y2))))))) {
            grille[x2][y2] = new Case(new Piece(piece));
            grille[x][y] = null;

            return true;
        }

        return false;
    }

    private boolean testNbCasesDeplacement(int i, int j, int value) {
        int nbCasesDeplacement = i - j;
        return (nbCasesDeplacement == value || nbCasesDeplacement == -value);
    }

    public Case getCase(int x, int y) {
        return grille[x][y];
    }
}
