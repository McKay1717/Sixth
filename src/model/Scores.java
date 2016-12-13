package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class Scores implements Serializable, Comparable<Scores> {
    private static final String FILE_SCORES = "Ressources/scores";
    private static final int NB_SCORES_SAUVEGARDES = 5;
    private static long serialVersionUID = 1L;
    private Joueur joueur;
    private int nbCoups;

    public Scores(Joueur joueur, int nbCoups) {
        this.joueur = joueur;
        this.nbCoups = nbCoups;
    }

    public static void saveScores(Joueur joueur, int nbCoups) throws IOException, ClassNotFoundException {
        List<Scores> scores = readScores();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(FILE_SCORES))));
        if (scores != null) {
            scores.add(new Scores(joueur, nbCoups));
            sort(scores);
            while (scores.size() > NB_SCORES_SAUVEGARDES)
                scores.remove(scores.get(scores.size() - 1));
            for (Scores score : scores)
                oos.writeObject(score);
        } else
            oos.writeObject(new Scores(joueur, nbCoups));
        oos.close();
    }

    public static List<Scores> readScores() throws IOException, ClassNotFoundException {
        List<Scores> scores = new ArrayList<>();
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(FILE_SCORES))));
        boolean score_lu = false;
        for (int i = 0; i < NB_SCORES_SAUVEGARDES; i++) {
            Object line = null;
            try {
                line = ois.readObject();
            } catch (EOFException e) {
                ois.close();
                if (score_lu)
                    return scores;
                return null;
            }
            if (line != null) {
                scores.add((Scores) line);
                score_lu = true;
            } else if (score_lu) {
                ois.close();
                return scores;
            } else {
                ois.close();
                return null;
            }
        }
        ois.close();
        return scores;
    }

    public int getCouleur() {
        return joueur.getCouleur();
    }

    public String getNomJoueur() {
        return joueur.getNom();
    }

    public int getNbCoups() {
        return nbCoups;
    }

    @Override
    public int compareTo(Scores scores) {
        if (nbCoups < scores.nbCoups)
            return 0;
        return 1;
    }
}