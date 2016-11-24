package model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ctx on 09/11/16.
 */

public class GrilleUnitTest {
    @Test
    public void testPoserPiece() {
        Grille grille = new Grille();

        grille.poserPiece(2, 4);
        Assert.assertNotEquals(grille.getCase(2, 4), null);
    }

    // TODO : A compléter
    @Test
    public void testDeplacerPiece() {
        Grille grille = new Grille();

        grille.poserPiece(2, 3);
        grille.deplacerPiece(2, 3, 1, 3);

        Assert.assertEquals(grille.getCase(1, 3), null);
    }
}