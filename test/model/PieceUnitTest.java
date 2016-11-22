package model;

/**
 * Created by ctx on 09/11/16.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static model.Piece.*;

public class PieceUnitTest {

    @Test
    public void testPiece() {
        Piece piece = new Piece(PION);
        Piece tour = new Piece(TOUR);
        Piece cavalier = new Piece(CAVALIER);
        Piece fou = new Piece(FOU);
        Piece dame = new Piece(DAME);
        Piece roi = new Piece(ROI);

        assertEquals(piece.getPiece(), PION);
        assertEquals(tour.getPiece(), TOUR);
        assertEquals(cavalier.getPiece(), CAVALIER);
        assertEquals(fou.getPiece(), FOU);
        assertEquals(dame.getPiece(), DAME);
        assertEquals(roi.getPiece(), ROI);
    }

    @Test
    public void testCouleur() {
        Piece rouge = new Piece(PION, ROUGE);
        Piece blanc = new Piece(PION, BLANC);

        assertEquals(rouge.getCouleur(), ROUGE);
        assertEquals(blanc.getCouleur(), BLANC);
    }

    /* Je pense que ça va vraiment être la merde pour les tests de déplacement,
     * y'a beaucoup trop de possibilités (ou je suis juste con).
     */

    @Test
    public void testDeplacementTour() {

    }

    @Test
    public void testDeplacementCavalier() {

    }

    @Test
    public void testDeplacementFou() {

    }

    @Test
    public void testDeplacementDame() {

    }

    @Test
    public void testDeplacementRoi() {

    }
}