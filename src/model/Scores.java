package model;

import java.io.*;

public class Scores implements Serializable {
    public static final int NB_SCORES_SAUVEGARDES = 5;
    public Joueur joueur;
    public int nbCoups;

    public Scores(Joueur joueur, int nbCoups) {
        this.joueur = joueur;
        this.nbCoups = nbCoups;
    }

    public static void saveScores(Joueur joueur, int nbCoups) throws IOException {
        Scores scores = new Scores(joueur, nbCoups);
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Resources/scores"))));
        oos.writeObject(scores);
        oos.close();
    }

    public static Scores[] readScores() throws IOException, ClassNotFoundException {
        Scores[] scores = new Scores[NB_SCORES_SAUVEGARDES];
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Ressources/scores"))));
        for (int i = 0; i < NB_SCORES_SAUVEGARDES; i++)
            scores[i] = (Scores) ois.readObject();
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
}