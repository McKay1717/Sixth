package model;

import exceptions.TailleMaximaleDepasseeException;

import java.io.*;

import static model.Grille.LARGEUR;
import static model.Grille.LONGUEUR;
import static model.Piece.ROI;

public class Jeu implements Serializable {
    public static final int BLANC = -1;
    public static final int ROUGE = -2;
    private static final String FILE_SAVE_PARTIE = "Ressources/save";
    private static final int NB_JOUEURS = 2;
    private static final int COULEUR_PREMIER_JOUEUR = BLANC;
    private Joueur[] joueurs;
    private Grille grille;

    public Jeu() {
        grille = new Grille();
        joueurs = new Joueur[NB_JOUEURS];
    }

    public static Jeu loadPartie() throws IOException, ClassNotFoundException {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(FILE_SAVE_PARTIE))));
        } catch (EOFException e) {
            return null;
        }
        Jeu save = (Jeu) ois.readObject();
        ois.close();
        return save;
    }

    public void deplacer(int x, int y, int x2, int y2) {
        grille.deplacer(x, y, x2, y2);
    }

    public void saveScores() {
    }

    public void addPion(int x, int y, Pion pion) throws TailleMaximaleDepasseeException {
        grille.addPion(x, y, pion);
    }

    public boolean finDePartie() {
        for (int i = 0; i < LONGUEUR; i++)
            for (int j = 0; j < LARGEUR; j++)
                if (grille.getPiece(i, j).getTaille() == ROI)
                    return true;
        return false;
    }

    public Case getCase(int x, int y) {
        return grille.getCase(x, y);
    }

    public Piece getPiece(int x, int y) {
        return grille.getPiece(x, y);
    }

    public void savePartie() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(FILE_SAVE_PARTIE))));
        oos.writeObject(this);
        oos.close();
    }

    public Joueur[] getJoueurs() {
        if (joueurs[0].getCouleur() == ROUGE)
            return joueurs;
        Joueur joueur = joueurs[0];
        joueurs[0] = joueurs[1];
        joueurs[1] = joueur;
        return joueurs;
    }

    public void setJoueurs(Joueur rouge, Joueur blanc) {
        joueurs[0] = rouge;
        joueurs[1] = blanc;
    }
}