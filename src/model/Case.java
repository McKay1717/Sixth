package model;

import java.io.Serializable;

public class Case implements Serializable {
    protected static final Piece VIDE = null;
    private static final long serialVersionUID = 1L;
    private Piece piece;

    public Case() {
        this.piece = VIDE;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void deletePiece() {
        piece = VIDE;
    }

    public boolean isVide() {
        return (piece == VIDE);
    }
}
