package sixth;

import java.util.List;

/**
 * Created by ctx on 09/11/16.
 */

public class Case {
    public static final Piece VIDE = null;

    private Piece piece;

    public Case() {
        piece = new Piece(Piece.PION);
    }

    public Case(Piece _piece) {
        piece = _piece;
    }

    public Piece getPiece() {
        return  piece;
    }
}
