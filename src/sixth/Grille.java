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

    // ATTENTION : je me suis peut être trompé

    public void addPiece(Piece piece, int x, int y) {
        if(grille[x][y] != null) {

        }
        else {
            grille[x][y] = new Case();
            grille[x][y].add(piece);
        }
    }
}
