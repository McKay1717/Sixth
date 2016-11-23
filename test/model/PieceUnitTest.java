package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static model.Pion.BLANC;
import static model.Pion.ROUGE;
import static org.junit.Assert.assertEquals;

public class PieceUnitTest {
    @Test
    public void testCouleurPiece() {
        Piece piece = new Piece();
        piece.add(new Pion(ROUGE));
        assertEquals(ROUGE, piece.getCouleur());

        List<Pion> pions = new ArrayList<Pion>();
        pions.add(new Pion(ROUGE));
        pions.add(new Pion(BLANC));
        Piece piece2 = new Piece();
        piece2.add(pions);
        assertEquals(BLANC, piece2.getCouleur());
    }

    @Test
    public void testTaillePiece() {
        List<Pion> pions = new ArrayList<Pion>();
        pions.add(new Pion(ROUGE));
        pions.add(new Pion(BLANC));

        Piece piece = new Piece();
        piece.add(pions);
        assertEquals(2, piece.getTaille());
    }
}