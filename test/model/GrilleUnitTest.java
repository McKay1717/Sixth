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
    public void testDeplacerPiecePion() {
        Grille grille = new Grille();
        ArrayList<Point> possibilites = new ArrayList<Point>();
        Point posDepart = new Point(2, 3);
        int i, j;

        grille.poserPion(posDepart.x, posDepart.y, new Pion(BLANC));

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
    public void testDeplacerPieceTour() throws TailleMaximaleDepasseeException {
        Grille grille = new Grille();
        ArrayList<Point> possibilites = new ArrayList<Point>();
        Point posDepart = new Point(2, 3);
        int i, j;

        grille.poserPion(posDepart.x, posDepart.y, new Pion(BLANC));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(BLANC));

        for(i = 0; i < Grille.LARGEUR; i++) {
            if(i != posDepart.x)
                possibilites.add(new Point(i, posDepart.y));
        }

        for(i = 0; i < Grille.LARGEUR; i++) {
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
    public void testDeplacerPieceCavalier() throws TailleMaximaleDepasseeException {
        Grille grille = new Grille();
        ArrayList<Point> possibilites = new ArrayList<Point>();
        Point posDepart = new Point(2, 2);
        int i, j;

        grille.poserPion(posDepart.x, posDepart.y, new Pion(BLANC));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(BLANC));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(BLANC));

        for(i = posDepart.x - 2; i <= posDepart.x + 2; i += 2) {
            for(j = posDepart.y - 1; j <= posDepart.y + 1; j++) {
                if(i != posDepart.x && j != posDepart.y)
                    possibilites.add(new Point(i, j));
            }
        }

        for(i = posDepart.y - 2; i <= posDepart.y + 2; i += 2) {
            for(j = posDepart.x - 1; j <= posDepart.x + 1; j++) {
                if(i != posDepart.y && j != posDepart.x)
                    possibilites.add(new Point(j, i));
            }
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

    // TODO : Compléter les if
    @Test
    public void testDeplacerPieceFou() throws TailleMaximaleDepasseeException {
        Grille grille = new Grille();
        ArrayList<Point> possibilites = new ArrayList<Point>();
        Point posDepart = new Point(2, 3);
        int i, j;

        grille.poserPion(posDepart.x, posDepart.y, new Pion(BLANC));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(BLANC));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(BLANC));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(BLANC));

        if(posDepart.x > posDepart.y) {
            i = posDepart.x - posDepart.y; j = 0;
        }
        else if(posDepart.y > posDepart.x) {
            i = 0; j = posDepart.y - posDepart.x;

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