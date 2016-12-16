package model;

import exceptions.TailleMaximaleDepasseeException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverse;
import static model.Grille.LARGEUR;
import static model.Grille.LONGUEUR;
import static model.Piece.ROI;

public class Jeu implements Serializable {
    public static final int BLANC = -1;
    public static final int ROUGE = -2;
    private static final int NB_PARTIES_SAUVEGARDEES = 4096;
    private static final String FILE_SAVE_PARTIE = "Ressources/save";
    private static final int NB_JOUEURS = 2;
    private static final int COULEUR_PREMIER_JOUEUR = BLANC;
    private Joueur[] joueurs;
    private Grille grille;

    public Jeu() {
        grille = new Grille();
        joueurs = new Joueur[NB_JOUEURS];
    }

    public static List<Jeu> loadPartie() throws IOException, ClassNotFoundException {
        List<Jeu> save = new ArrayList<>();
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(FILE_SAVE_PARTIE))));
        } catch (EOFException e) {
            return save;
        }

        for (int i = 0; i < NB_PARTIES_SAUVEGARDEES; i++) {
            Object line = null;
            try {
                line = ois.readObject();
            } catch (EOFException e) {
                ois.close();
                return save;
            }
            if (line != null)
                save.add((Jeu) line);
            else {
                ois.close();
                return save;
            }
        }
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

    public void savePartie() throws IOException, ClassNotFoundException {
        List<Jeu> save = loadPartie();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(FILE_SAVE_PARTIE))));
        save.add(this);
        reverse(save);
        while (save.size() > NB_PARTIES_SAUVEGARDEES)
            save.remove(save.get(save.size() - 1));
        for (Jeu jeu : save)
            oos.writeObject(jeu);
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