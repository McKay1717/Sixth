package sixth;

/**
 * Created by ctx on 09/11/16.
 */

public class Case {
    public static final Piece VIDE = null;

    private Piece piece;

    public Case() {
        piece = VIDE;
    }

    public Case(Piece _piece) {
        piece = _piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
