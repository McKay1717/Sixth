package model;

import exceptions.TailleMaximaleDepasseeException;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

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
    public void testDeplacerPieceCaseVide() throws TailleMaximaleDepasseeException {
        Pion pion = new Pion(joueur.getCouleur(), joueur);
        grille.addPion(2, 4, pion);

        assertFalse(grille.deplacer(2, 4, 3, 4));
    }

    @Test
    public void testDeplacerPiecePion() throws TailleMaximaleDepasseeException {
        int i, j;

        // Parcours de toutes les cases

        for(i = 0; i < LONGUEUR; i++) {
            for(j = 0; j < LARGEUR; j++) {
                ArrayList<Point> possibilites = new ArrayList<Point>();
                Point posDepart = new Point(i, j);
                int debut, fin, k, l;

                grille.addPion(posDepart.x, posDepart.y, new Pion(joueur.getCouleur(), joueur));

                debut = ((posDepart.x == 0) ? posDepart.x : posDepart.x - 1);
                fin = ((posDepart.x == LARGEUR - 1) ? posDepart.x : posDepart.x + 1);

                for (k = debut; k <= fin; k++) {
                    if (k != posDepart.x) {
                        possibilites.add(new Point(k, posDepart.y));
                    }
                }

                debut = ((posDepart.y == 0) ? posDepart.y : posDepart.y - 1);
                fin = ((posDepart.y == LONGUEUR - 1) ? posDepart.y : posDepart.y + 1);

                for (k = debut; k <= fin; k++) {
                    if (k != posDepart.y) {
                        possibilites.add(new Point(posDepart.x, k));
                    }
                }

                for(k = 0; k < LONGUEUR; k++) {
                    for(l = 0; l < LARGEUR; l++) {
                        if (possibilites.contains(new Point(k, l))) {
                            grille.addPion(k, l, new Pion(joueur.getCouleur(), joueur));
                            assertTrue(grille.deplacer(posDepart.x, posDepart.y, k, l));
                            grille.getCase(k, l).deletePiece();
                            grille.addPion(posDepart.x, posDepart.y, new Pion(joueur.getCouleur(), joueur));
                            System.out.println("k = " + k + "; l = " + l + "; posDepart.x = " + posDepart.x + "; posDepart.y = " + posDepart.y);
                        }
                        else
                            assertFalse(grille.deplacer(posDepart.x, posDepart.y, i, j));
                    }
                }

                grille.getCase(posDepart.x, posDepart.y).deletePiece();
            }
        }
    }

    @Test
    public void testDeplacerPieceTour() throws TailleMaximaleDepasseeException {
        int i, j;

        for(i = 0; i < LONGUEUR; i++) {
            for(j = 0; j < LARGEUR; j++) {
                ArrayList<Point> possibilites = new ArrayList<Point>();
                Point posDepart = new Point(i, j);
                int k, l;

                grille.addPion(posDepart.x, posDepart.y, new Pion(joueur.getCouleur(), joueur));
                grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));

                for (k = 0; k < LONGUEUR; k++) {
                    if (k != posDepart.x)
                        possibilites.add(new Point(k, posDepart.y));
                }

                for (k = 0; k < LARGEUR; k++) {
                    if (k != posDepart.y)
                        possibilites.add(new Point(posDepart.x, k));
                }

                for (k = 0; k < LONGUEUR; k++) {
                    for (l = 0; l < LARGEUR; l++) {
                        if (possibilites.contains(new Point(k, l))) {
                            grille.addPion(k, l, new Pion(joueur.getCouleur(), joueur));
                            assertTrue(grille.deplacer(posDepart.x, posDepart.y, k, l));
                            grille.getCase(k, l).deletePiece();
                            grille.addPion(posDepart.x, posDepart.y, new Pion(joueur.getCouleur(), joueur));
                            grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
                        }
                        else
                            assertFalse(grille.deplacer(posDepart.x, posDepart.y, k, l));
                    }
                }

                grille.getCase(posDepart.x, posDepart.y).deletePiece();
            }
        }
    }

    @Test
    public void testDeplacerPieceCavalier() throws TailleMaximaleDepasseeException {
        int i, j;

        for(i = 0; i < LONGUEUR; i++) {
            for(j = 0; j < LARGEUR; j++) {
                ArrayList<Point> possibilites = new ArrayList<Point>();
                Point posDepart = new Point(i, j);
                int debutX, finX, debutY, finY, k, l;

                grille.addPion(posDepart.x, posDepart.y, new Pion(joueur.getCouleur(), joueur));
                grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
                grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));

                debutX = ((posDepart.x > 1) ? posDepart.x - 2 : posDepart.x);
                finX = ((posDepart.x < LONGUEUR - 2) ? posDepart.x + 2 : posDepart.x);
                debutY = ((posDepart.y > 0) ? posDepart.y - 1 : posDepart.y);
                finY = ((posDepart.y < LARGEUR - 1) ? posDepart.y + 1 : posDepart.y);

                for (k = debutX; k <= finX; k += 2) {
                    for (l = debutY; l <= finY; l++) {
                        if (k != posDepart.x && l != posDepart.y)
                            possibilites.add(new Point(k, l));
                    }
                }

                debutY = ((posDepart.y > 1) ? posDepart.y - 2 : posDepart.y);
                finY = ((posDepart.y < LARGEUR - 2) ? posDepart.y + 2 : posDepart.y);
                debutX = ((posDepart.x > 0) ? posDepart.x - 1 : posDepart.x);
                finX = ((posDepart.x < LONGUEUR - 1) ? posDepart.x + 1 : posDepart.x);

                for (k = debutY; k <= finY; k += 2) {
                    for (l = debutX; l <= finX; l++) {
                        if (k != posDepart.y && l != posDepart.x)
                            possibilites.add(new Point(l, k));
                    }
                }

                for (k = 0; k < LONGUEUR; k++) {
                    for (l = 0; l < LARGEUR; l++) {
                        if (possibilites.contains(new Point(k, l))) {
                            grille.addPion(k, l, new Pion(joueur.getCouleur(), joueur));
                            assertTrue(grille.deplacer(posDepart.x, posDepart.y, k, l));
                            grille.getCase(k, l).deletePiece();
                            grille.addPion(posDepart.x, posDepart.y, new Pion(joueur.getCouleur(), joueur));
                            grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
                            grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
                        }
                        else
                            assertFalse(grille.deplacer(posDepart.x, posDepart.y, k, l));
                    }
                }

                grille.getCase(posDepart.x, posDepart.y).deletePiece();
            }
        }
    }

    @Test
    public void testDeplacerPieceFou() throws TailleMaximaleDepasseeException {
        int i, j;

        for(i = 0; i < LONGUEUR; i++) {
            for(j = 0; j < LARGEUR; j++) {
                ArrayList<Point> possibilites = new ArrayList<Point>();
                Point posDepart = new Point(i, j);
                int k, l = 0, debutY = 0, finY = LARGEUR;

                grille.addPion(posDepart.x, posDepart.y, new Pion(joueur.getCouleur(), joueur));
                grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
                grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
                grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));

                if (posDepart.y > posDepart.x)
                    debutY = posDepart.y - posDepart.x;
                else if (posDepart.x > posDepart.y) {
                    l = posDepart.x - posDepart.y;
                    finY = LARGEUR - l;
                }

                for (k = debutY; k < finY; k++) {
                    if (k != posDepart.y && l != posDepart.x)
                        possibilites.add(new Point(l, k));

                    l++;
                }

                debutY = 0;
                finY = LONGUEUR;
                l = LARGEUR - 1;

                if(posDepart.y > ((LARGEUR - 1) - posDepart.x)) {
                    debutY = posDepart.y - ((LARGEUR - 1) - posDepart.x);
                    finY = LARGEUR;
                }
                else if ((LARGEUR - 1) - posDepart.x > posDepart.y) {
                    l = posDepart.x + posDepart.y;
                    finY = l + 1;
                }

                for(k = debutY; k < finY; k++) {
                    if(k != posDepart.y && l != posDepart.x)
                        possibilites.add(new Point(l, k));

                    l--;
                }

                for(k = 0; k < Grille.LARGEUR; k++) {
                    for(l = 0; l < Grille.LARGEUR; l++) {
                        if(possibilites.contains(new Point(k, l))) {
                            grille.addPion(k, l, new Pion(joueur.getCouleur(), joueur));
                            assertTrue(grille.deplacer(posDepart.x, posDepart.y, k, l));
                            grille.getCase(k, l).deletePiece();
                            grille.addPion(posDepart.x, posDepart.y, new Pion(joueur.getCouleur(), joueur));
                            grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
                            grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
                            grille.getCase(posDepart.x, posDepart.y).getPiece().add(new Pion(joueur.getCouleur(), joueur));
                        }
                        else
                            assertFalse(grille.deplacer(posDepart.x, posDepart.y, k, l));
                    }
                }

                grille.getCase(posDepart.x, posDepart.y).deletePiece();
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