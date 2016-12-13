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
    Joueur init = new Joueur(ROUGE, "Init");
    int nbCoupsinit = 5;

    @Before
    public void initRessourcesScores() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Ressources/scores"))));
        oos.writeObject(new Scores(init, nbCoupsinit));
        oos.close();
    }

    @Test
    public void testScores() throws IOException, ClassNotFoundException {
        Joueur joueur = new Joueur(BLANC, "toto");
        int nbCoups = 5;
        saveScores(joueur, nbCoups);

        List<Scores> scores = readScores();
        int i = 0;
        for (Scores score : scores) {
            if (i == 0) {
                assertEquals(init.getCouleur(), score.getCouleur());
                assertEquals(init.getNom(), score.getNomJoueur());
                assertEquals(nbCoupsinit, score.getNbCoups());
            } else {
                assertEquals(joueur.getCouleur(), score.getCouleur());
                assertEquals(joueur.getNom(), score.getNomJoueur());
                assertEquals(nbCoups, score.getNbCoups());
            }
            i++;
        }
    }
}