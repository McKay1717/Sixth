package model;

import exceptions.TailleMaximaleDepasseeException;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static junit.framework.TestCase.assertFalse;
import static model.Jeu.BLANC;
import static model.Jeu.ROUGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JeuUnitTest {
    private Jeu jeu;

    @Before
    public void setUp() throws ParseException {
        jeu = new Jeu();
    }

    @Test
    public void testFinDePartie() throws TailleMaximaleDepasseeException, ParseException {
        Joueur joueur = new Joueur(BLANC, "Toto");
        jeu.addPion(0, 0, new Pion(joueur.getCouleur(), joueur));

        for (int i = 0; i < 5; i++)
            jeu.getPiece(0, 0).add(new Pion(joueur.getCouleur(), joueur));

        assertTrue(jeu.finDePartie());
    }

    @Test
    public void testTour() throws TailleMaximaleDepasseeException {
        Joueur joueur = new Joueur(BLANC, "Toto");
        Joueur joueur2 = new Joueur(ROUGE, "Titi");

        assertTrue(jeu.addPion(0, 0, new Pion(joueur.getCouleur(), joueur)));
        assertFalse(jeu.addPion(1, 0, new Pion(joueur.getCouleur(), joueur)));
        assertTrue(jeu.addPion(1, 0, new Pion(joueur2.getCouleur(), joueur2)));
        assertFalse(jeu.deplacer(1, 0, 0, 0, Jeu.PAS_DECOUPE, joueur2.getCouleur()));
        assertTrue(jeu.deplacer(0, 0, 1, 0, Jeu.PAS_DECOUPE, joueur.getCouleur()));
    }

    @Test
    public void testNbTour() throws TailleMaximaleDepasseeException {
        Joueur joueur = new Joueur(BLANC, "Toto");
        Joueur joueur2 = new Joueur(ROUGE, "Titi");

        assertEquals(jeu.getNbTour(), 0);

        jeu.addPion(0, 0, new Pion(joueur.getCouleur(), joueur));
        jeu.addPion(1, 0, new Pion(joueur2.getCouleur(), joueur2));

        assertEquals(jeu.getNbTour(), 2);
    }
}