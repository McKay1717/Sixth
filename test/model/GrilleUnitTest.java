package model;

import exceptions.TailleMaximaleDepasseeException;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static model.Grille.LARGEUR;
import static model.Grille.LONGUEUR;
import static model.Jeu.BLANC;
import static org.junit.Assert.*;

public class GrilleUnitTest {
    Grille grille;
    Joueur joueur;

    @Before
    public void setUp() {
        joueur = new Joueur(BLANC, "Toto");
        grille = new Grille();
    }

    @Test
    public void testAddPion() throws TailleMaximaleDepasseeException {
        Pion pion = new Pion(joueur.getCouleur(), joueur);
        grille.addPion(2, 4, pion);
        assertNotEquals(grille.getCase(2, 4), null);
    }

    @Test
    public void testDeplacerPiecePion() throws TailleMaximaleDepasseeException {
        ArrayList<Point> possibilites = new ArrayList<Point>();
        Point posDepart = new Point(2, 3);
        int i, j;

        grille.addPion(posDepart.x, posDepart.y, new Pion(joueur.getCouleur(), joueur));

        for (i = posDepart.x - 1; i <= posDepart.x + 1; i++) {
            if (i != posDepart.x)
                possibilites.add(new Point(i, posDepart.y));
        }

        for (i = posDepart.y - 1; i <= posDepart.y + 1; i++) {
            if (i != posDepart.y)
                possibilites.add(new Point(posDepart.x, i));
        }

        for (i = 0; i < LONGUEUR; i++) {
            for (j = 0; j < LARGEUR; j++) {
                if (possibilites.contains(new Point(i, j))) {
                    assertTrue(grille.deplacer(posDepart.x, posDepart.y, i, j));
                    grille.deplacer(i, j, posDepart.x, posDepart.y);
                } else
                    assertFalse(grille.deplacer(posDepart.x, posDepart.y, i, j));
            }
        }
    }

    @Test
    public void testDeplacerPieceTour() throws TailleMaximaleDepasseeException {
        ArrayList<Point> possibilites = new ArrayList<Point>();
        Point posDepart = new Point(2, 3);
        int i, j;

        grille.addPion(posDepart.x, posDepart.y, new Pion(joueur.getCouleur(), joueur));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));

        for (i = 0; i < LONGUEUR; i++) {
            if (i != posDepart.x)
                possibilites.add(new Point(i, posDepart.y));
        }

        for (i = 0; i < LARGEUR; i++) {
            if (i != posDepart.y)
                possibilites.add(new Point(posDepart.x, i));
        }

        for (i = 0; i < LONGUEUR; i++) {
            for (j = 0; j < LARGEUR; j++) {
                if (possibilites.contains(new Point(i, j))) {
                    assertTrue(grille.deplacer(posDepart.x, posDepart.y, i, j));
                    grille.deplacer(i, j, posDepart.x, posDepart.y);
                }
                else
                    assertFalse(grille.deplacer(posDepart.x, posDepart.y, i, j));
            }
        }
    }

    @Test
    public void testDeplacerPieceCavalier() throws TailleMaximaleDepasseeException {
        ArrayList<Point> possibilites = new ArrayList<Point>();
        Point posDepart = new Point(4, 0);
        int i, j;

        grille.addPion(posDepart.x, posDepart.y, new Pion(joueur.getCouleur(), joueur));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));

        for (i = posDepart.x - 2; i <= posDepart.x + 2; i += 2) {
            for (j = posDepart.y - 1; j <= posDepart.y + 1; j++) {
                if (i != posDepart.x && j != posDepart.y)
                    possibilites.add(new Point(i, j));
            }
        }

        for (i = posDepart.y - 2; i <= posDepart.y + 2; i += 2) {
            for (j = posDepart.x - 1; j <= posDepart.x + 1; j++) {
                if (i != posDepart.y && j != posDepart.x)
                    possibilites.add(new Point(j, i));
            }
        }

        for (i = 0; i < LONGUEUR; i++) {
            for (j = 0; j < LARGEUR; j++) {
                if (possibilites.contains(new Point(i, j))) {
                    assertTrue(grille.deplacer(posDepart.x, posDepart.y, i, j));
                    grille.deplacer(i, j, posDepart.x, posDepart.y);
                }
                else
                    assertFalse(grille.deplacer(posDepart.x, posDepart.y, i, j));
            }
        }
    }

    @Test
    public void testDeplacerPieceFou() throws TailleMaximaleDepasseeException {
        Grille grille = new Grille();
        ArrayList<Point> possibilites = new ArrayList<Point>();
        Point posDepart = new Point(2, 3);
        int i, j = 0, startY = 0, endY = LARGEUR;

        grille.addPion(posDepart.x, posDepart.y, new Pion(joueur.getCouleur(), joueur));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));

        if (posDepart.y > posDepart.x)
            startY = posDepart.y - posDepart.x;
        else if (posDepart.x > posDepart.y) {
            j = posDepart.x - posDepart.y;
            endY = LARGEUR - j;
        }

        for (i = startY; i < endY; i++) {
            if (i != posDepart.y && j != posDepart.x)
                possibilites.add(new Point(j, i));

            j++;
        }

        startY = 0;
        endY = LONGUEUR;
        j = LARGEUR - 1;

        if(posDepart.y > ((LARGEUR - 1) - posDepart.x)) {
            startY = posDepart.y - ((LARGEUR - 1) - posDepart.x);
            endY = LARGEUR;
        }
        else if ((LARGEUR - 1) - posDepart.x > posDepart.y) {
            j = posDepart.x + posDepart.y;
            endY = j + 1;
        }

        for(i = startY; i < endY; i++) {
            if(i != posDepart.y && j != posDepart.x)
                possibilites.add(new Point(j, i));

            j--;
        }

        for(i = 0; i < Grille.LARGEUR; i++) {
            for(j = 0; j < Grille.LARGEUR; j++) {
                if(possibilites.contains(new Point(i, j))) {
                    assertTrue(grille.deplacer(posDepart.x, posDepart.y, i, j));
                    grille.deplacer(i, j, posDepart.x, posDepart.y);
                }
                else
                    assertFalse(grille.deplacer(posDepart.x, posDepart.y, i, j));
            }
        }
    }

    @Test
    public void testDeplacerPieceDame() throws TailleMaximaleDepasseeException {
        ArrayList<Point> possibilites = new ArrayList<Point>();
        Grille grille = new Grille();
        Point posDepart = new Point(4, 0);
        int i, j, startY = 0, endY = LARGEUR;

        grille.addPion(posDepart.x, posDepart.y, new Pion(joueur.getCouleur(), joueur));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
        grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));

        // Déplacements orthogonaux

        for (i = 0; i < LONGUEUR; i++) {
            if (i != posDepart.x)
                possibilites.add(new Point(i, posDepart.y));
        }

        for (i = 0; i < LARGEUR; i++) {
            if (i != posDepart.y)
                possibilites.add(new Point(posDepart.x, i));
        }

        // Déplacements diagonaux

        i = 0; j = 0;

        if (posDepart.y > posDepart.x)
            startY = posDepart.y - posDepart.x;
        else if (posDepart.x > posDepart.y) {
            j = posDepart.x - posDepart.y;
            endY = LARGEUR - j;
        }

        for (i = startY; i < endY; i++) {
            if (i != posDepart.y && j != posDepart.x)
                possibilites.add(new Point(j, i));

            j++;
        }

        startY = 0;
        endY = LONGUEUR;
        j = LARGEUR - 1;

        if(posDepart.y > ((LARGEUR - 1) - posDepart.x)) {
            startY = posDepart.y - ((LARGEUR - 1) - posDepart.x);
            endY = LARGEUR;
        }
        else if ((LARGEUR - 1) - posDepart.x > posDepart.y) {
            j = posDepart.x + posDepart.y;
            endY = j + 1;
        }

        for(i = startY; i < endY; i++) {
            if(i != posDepart.y && j != posDepart.x)
                possibilites.add(new Point(j, i));

            j--;
        }

        for (i = 0; i < LONGUEUR; i++) {
            for (j = 0; j < LARGEUR; j++) {
                if (possibilites.contains(new Point(i, j))) {
                    assertTrue(grille.deplacer(posDepart.x, posDepart.y, i, j));
                    grille.deplacer(i, j, posDepart.x, posDepart.y);
                }
                else
                    assertFalse(grille.deplacer(posDepart.x, posDepart.y, i, j));
            }
        }
    }
}