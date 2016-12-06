package model;

import org.junit.Test;

import static model.Jeu.ROUGE;
import static org.junit.Assert.assertEquals;

public class PionUnitTest {
    @Test
    public void testCouleurJoueurPion() {
        Joueur joueur = new Joueur(ROUGE, "Toto");
        Pion pion = new Pion(joueur.getCouleur(), joueur);
        assertEquals(pion.getCouleur(), ROUGE);
        assertEquals(pion.getJoueur(), joueur);
    }
}