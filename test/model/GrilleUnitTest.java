package model;

import exception.TailleMaximaleDepasseeException;
import org.junit.Assert;
import org.junit.Test;

import static model.Pion.BLANC;
import static org.junit.Assert.assertTrue;

/**
 * Created by ctx on 09/11/16.
 */

public class GrilleUnitTest {
    @Test
    public void testPoserPion() throws TailleMaximaleDepasseeException {
        Grille grille = new Grille();

        grille.poserPion(2, 4, new Pion(BLANC));
        Assert.assertNotEquals(grille.getCase(2, 4), null);
    }

    /* Note : A compléter + on peut pas tester toutes les possibilités,
     *        je crois qu'il va falloir utiliser des mocks
     */

    @Test
    public void testDeplacerPiecePion() throws TailleMaximaleDepasseeException {
        Grille grille = new Grille();

        grille.poserPion(2, 3, new Pion(BLANC));

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

    @Test
    public void testFinDePartie() throws TailleMaximaleDepasseeException {
        Grille grille = new Grille();
        grille.poserPion(0, 0, new Pion(BLANC));
        for (int i = 0; i < 5; i++)
            grille.getCase(0, 0).getPiece().add(new Pion(BLANC));
        assertTrue(grille.finDePartie());
    }
}