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

    /* Je pense que ça va vraiment être la merde pour les tests de déplacement,
     * y'a beaucoup trop de possibilités (ou je suis juste con).
     */

    @Test
    public void testDeplacementPion() {
        Grille grille = new Grille();
        Piece piece = new Piece(Piece.PION);

        grille.addPiece(piece, 2, 2);

        // Mouvements valides

        // BAS
        grille.deplacer(2, 2, 2, 3);
        Assert.assertEquals(grille.getCase(2, 3).getPiece(), piece);

        // HAUT
        grille.deplacer(2, 3, 2, 2);
        Assert.assertEquals(grille.getCase(2, 2).getPiece(), piece);

        // DROITE
        grille.deplacer(2, 2, 3, 2);
        Assert.assertEquals(grille.getCase(3, 2).getPiece(), piece);

        // GAUCHE
        grille.deplacer(3, 2, 2, 2);
        Assert.assertEquals(grille.getCase(3, 2).getPiece(), piece);

        // Mouvements invalides

        // BAS
        grille.deplacer(3, 2, 3, 4);
        Assert.assertNotEquals(grille.getCase(3, 4).getPiece(), piece);

        // HAUT
        grille.deplacer(3, 2, 3, 0);
        Assert.assertNotEquals(grille.getCase(3, 0).getPiece(), piece);

        // GAUCHE
        grille.deplacer(3, 2, 0, 2);
        Assert.assertNotEquals(grille.getCase(0, 2).getPiece(), piece);

        grille.deplacer(3, 2, 2, 2);

        // DROITE
        grille.deplacer(2, 2, 4, 2);
        Assert.assertNotEquals(grille.getCase(4, 2).getPiece(), piece);
    }

    @Test
    public void testDeplacementTour() {

    }

    @Test
    public void testDeplacementCavalier() {

    }

    @Test
    public void testDeplacementFou() {

    }

    @Test
    public void testDeplacementDame() {

    }

    @Test
    public void testDeplacementRoi() {

    }
}
