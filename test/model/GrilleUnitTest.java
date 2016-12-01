package model;

import exception.TailleMaximaleDepasseeException;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

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

    @Test
    public void testDeplacerPiecePion() throws TailleMaximaleDepasseeException {
        Grille grille = new Grille();
        ArrayList<Point> possibilites = new ArrayList<Point>();
        Point posDepart = new Point(2, 3);
        Pion pion = new Pion(BLANC);
        int i, j;

        grille.poserPion(posDepart.x, posDepart.y, pion);

        for(i = posDepart.x - 1; i <= posDepart.x + 1; i++) {
            if(i != posDepart.x)
                possibilites.add(new Point(i, posDepart.y));
        }

        for(i = posDepart.y - 1; i <= posDepart.y + 1; i++) {
            if(i != posDepart.y)
                possibilites.add(new Point(posDepart.x, i));
        }

        for(i = 0; i < Grille.LARGEUR; i++) {
            for(j = 0; j < Grille.LARGEUR; j++) {
                if(possibilites.contains(new Point(i, j))) {
                    Assert.assertTrue(grille.deplacerPiece(posDepart.x, posDepart.y, i, j));
                    grille.deplacerPiece(i, j, posDepart.x, posDepart.y);
                }
                else
                    Assert.assertFalse(grille.deplacerPiece(posDepart.x, posDepart.y, i, j));
            }
        }
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