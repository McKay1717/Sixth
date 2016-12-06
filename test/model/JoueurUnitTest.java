package model;

import org.junit.Test;

import static model.Jeu.BLANC;
import static org.junit.Assert.assertEquals;

public class JoueurUnitTest {
    @Test
    public void testJoue() {
        Joueur joueur = new Joueur(BLANC, "Toto");
        joueur.joue();
        assertEquals(joueur.getNb_coups(), 1);
    }
}