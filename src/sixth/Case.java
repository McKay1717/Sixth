package sixth;

import java.util.List;

/**
 * Created by ctx on 09/11/16.
 */

public class Case {
    public static final Piece VIDE = null;
    public static final int NB_PIECES_MAX = 6;

    private Piece[] pieces;

    public Case() {
        pieces = new Piece[NB_PIECES_MAX];
    }

    public Case(Piece[] _pieces) {
        pieces = _pieces;
    }
}
