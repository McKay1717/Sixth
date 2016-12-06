package model;

import exceptions.TailleMaximaleDepasseeException;
import org.junit.Before;
import org.junit.Test;

import static model.Case.VIDE;
import static model.Jeu.ROUGE;
import static org.junit.Assert.assertEquals;

public class CaseUnitTest {
    Joueur joueur;
    Piece piece;
    Case _case;

    @Before
    public void setUp() throws TailleMaximaleDepasseeException {
        joueur = new Joueur(ROUGE, "Toto");
        piece = new Piece(joueur.getCouleur(), new Pion(joueur.getCouleur(), joueur));
        _case = new Case();
        _case.setPiece(piece);
    }

    @Test
    public void testSetPiece() {
        assertEquals(_case.getPiece(), piece);
    }

    @Test
    public void testDeletePiece() {
        _case.deletePiece();
        assertEquals(_case.getPiece(), VIDE);
    }
}