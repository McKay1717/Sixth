package model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by ctx on 09/11/16.
 */

public class CaseUnitTest {
    @Test
    public void testAjouterPiece() {
        Piece piece = new Piece();
        Case _case = new Case(piece);

        assertEquals(_case.getPiece(), piece);
    }

    @Test
    public void testDeletePiece() {
        Piece piece = new Piece();
        Case _case = new Case(piece);

        _case.deletePiece();
        assertEquals(_case.getPiece(), null);
    }
}