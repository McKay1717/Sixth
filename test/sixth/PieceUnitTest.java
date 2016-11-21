package sixth;

/**
 * Created by ctx on 09/11/16.
 */

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static sixth.Piece.*;

public class PieceUnitTest {

    @Test
    public void testPiece(){
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

    @Test
    public void testDeplacementPion() {
        Grille grille = new Grille();
        Piece piece = new Piece(Piece.PION);

        grille.addPiece(piece, 2, 2);

        grille.deplacer(2, 2, 2, 3);
        Assert.assertEquals(grille.getGrille()[2][3], piece);
    }
}
