package model;

import exceptions.TailleMaximaleDepasseeException;
import org.junit.Test;

import java.text.ParseException;

import static model.Jeu.BLANC;
import static org.junit.Assert.assertTrue;

public class JeuUnitTest {
    @Test
    public void testFinDePartie() throws TailleMaximaleDepasseeException, ParseException {
        Jeu jeu = new Jeu();
        Joueur joueur = new Joueur(BLANC, "Toto");
        jeu.addPion(0, 0, new Pion(joueur.getCouleur(), joueur));

        for (int i = 0; i < 5; i++)
            jeu.getPiece(0, 0).add(new Pion(joueur.getCouleur(), joueur));

        assertTrue(jeu.finDePartie());
    }
}