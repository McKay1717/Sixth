package model;

/**
 * Created by ctx on 09/11/16.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GrilleUnitTest {

    @Test
    public void testDeplacementPion() {
        Grille grille = new Grille();
        Piece piece = new Piece(Piece.PION);

        grille.addPiece(piece, 2, 2);

        // Mouvements valides

        // BAS
        grille.deplacer(2, 2, 2, 3);
        assertEquals(grille.getCase(2, 3).getPiece(), piece);

        // HAUT
        grille.deplacer(2, 3, 2, 2);
        assertEquals(grille.getCase(2, 2).getPiece(), piece);

        // DROITE
        grille.deplacer(2, 2, 3, 2);
        assertEquals(grille.getCase(3, 2).getPiece(), piece);

        // GAUCHE
        grille.deplacer(3, 2, 2, 2);
        assertEquals(grille.getCase(3, 2).getPiece(), piece);

        // Mouvements invalides

        // BAS
        grille.deplacer(3, 2, 3, 4);
        assertNotEquals(grille.getCase(3, 4).getPiece(), piece);

        // HAUT
        grille.deplacer(3, 2, 3, 0);
        assertNotEquals(grille.getCase(3, 0).getPiece(), piece);

        // GAUCHE
        grille.deplacer(3, 2, 0, 2);
        assertNotEquals(grille.getCase(0, 2).getPiece(), piece);

        grille.deplacer(3, 2, 2, 2);

        // DROITE
        grille.deplacer(2, 2, 4, 2);
        assertNotEquals(grille.getCase(4, 2).getPiece(), piece);
    }
}