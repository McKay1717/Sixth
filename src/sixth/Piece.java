package sixth;

/**
 * Created by ctx on 09/11/16.
 */

public class Piece {
    //Couleurs
    public static final int ROUGE = -1;
    public static final int BLANC = -2;

    //Valeurs
    public static final int PION = 1;
    public static final int TOUR = 2;
    public static final int CAVALIER = 3;
    public static final int FOU = 4;
    public static final int DAME = 5;
    public static final int ROI = 6;

    public static final int NUM_PIECE_MIN = PION;
    public static final int NUM_PIECE_MAX = ROI;

    private int piece;
    private int couleur;

    public Piece(int piece) {
        this.piece = piece;
    }

    public Piece(int piece, int couleur) {
        this(piece);
        this.couleur = couleur;
    }

    public int getPiece() {
        return piece;
    }

    public int getCouleur() {
        return couleur;
    }
}