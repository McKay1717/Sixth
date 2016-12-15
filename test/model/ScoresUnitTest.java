package model;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static model.Jeu.BLANC;
import static model.Scores.readScores;
import static model.Scores.saveScores;
import static org.junit.Assert.assertEquals;

public class ScoresUnitTest {
    @Test
    public void testScores() throws IOException, ClassNotFoundException {
        Joueur joueur = new Joueur(BLANC, "toto");
        int nbCoups = 5;
        saveScores(joueur, nbCoups);

        List<Scores> scores = readScores();
        for (Scores score : scores) {
            assertEquals(joueur.getCouleur(), score.getCouleur());
            assertEquals(joueur.getNom(), score.getNomJoueur());
            assertEquals(nbCoups, score.getNbCoups());
        }
    }
}