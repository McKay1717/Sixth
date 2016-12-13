package model;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;

import static model.Jeu.BLANC;
import static model.Jeu.ROUGE;
import static model.Scores.readScores;
import static model.Scores.saveScores;
import static org.junit.Assert.assertEquals;

public class ScoresUnitTest {
    @Before
    public void initRessourcesScores() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Ressources/scores"))));
        oos.writeObject(new Scores(new Joueur(ROUGE, "Init"), 4));
        oos.close();
    }

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