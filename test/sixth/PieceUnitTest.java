package sixth;

/**
 * Created by ctx on 09/11/16.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static sixth.Piece.*;

public class PieceUnitTest {

    @Test
    public void testPion(){
        Piece piece = new Piece(PION);
        Piece tour = new Piece(TOUR);
        Piece cavalier = new Piece(CAVALIER);
        Piece fou = new Piece(FOU);
        Piece dame = new Piece(DAME);
        Piece roi = new Piece(ROI);

        assertEquals(piece.getPion(), PION);
        assertEquals(tour.getPion(), TOUR);
        assertEquals(cavalier.getPion(), CAVALIER);
        assertEquals(fou.getPion(), FOU);
        assertEquals(dame.getPion(), DAME);
        assertEquals(roi.getPion(), ROI);
    }

}
