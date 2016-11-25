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

    /* Note : A compléter + on peut pas tester toutes les possibilités,
     *        je crois qu'il va falloir utiliser des mocks
     */

    @Test
    public void testDeplacerPiecePion() {
        Grille grille = new Grille();

        grille.poserPiece(2, 3);

        // Déplacements diagonale sur case vide

        grille.deplacerPiece(2, 3, 1, 2);
        Assert.assertEquals(grille.getCase(1, 2), null);

        grille.deplacerPiece(2, 3, 1, 4);
        Assert.assertEquals(grille.getCase(1, 4), null);

        grille.deplacerPiece(2, 3, 3, 4);
        Assert.assertEquals(grille.getCase(3, 4), null);

        grille.deplacerPiece(2, 3, 3, 2);
        Assert.assertEquals(grille.getCase(3, 2), null);

        // Déplacements orthogonaux sur case vide

        grille.deplacerPiece(2, 3, 1, 3);
        Assert.assertEquals(grille.getCase(1, 3), null);
    }
}