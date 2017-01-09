package model;

import exceptions.TailleMaximaleDepasseeException;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Calendar.*;
import static java.util.Collections.reverse;
import static model.Grille.LARGEUR;
import static model.Grille.LONGUEUR;
import static model.Piece.ROI;

public class Jeu implements Serializable {
    public static final int BLANC = 1;
    public static final int ROUGE = 0;
    public static final int PAS_DECOUPE = 0;
    private static final int NB_PARTIES_SAUVEGARDEES = 4096;
    private static final int NB_JOUEURS = 2;
    private static final int COULEUR_PREMIER_JOUEUR = BLANC;
    private static final long serialVersionUID = 1L;
    private static final String FILE_SAVE_PARTIE = "Ressources/save";
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    private Joueur[] joueurs;
    private Grille grille;
    private Date date;
    private int tourJoueur;
    private int nbTour;

    public Joueur getJoueur(int color) {
        return joueurs[color];
    }

    public Jeu() throws ParseException {
        grille = new Grille();
        joueurs = new Joueur[NB_JOUEURS];
        date = SIMPLE_DATE_FORMAT.parse(Integer.toString(getInstance().get(HOUR)) + ":" + Integer.toString(getInstance().get(MINUTE)) + ":" + Integer.toString(getInstance().get(SECOND)));
        tourJoueur = COULEUR_PREMIER_JOUEUR;
    }

    public static List<Jeu> loadPartie() throws IOException, ClassNotFoundException {
        List<Jeu> save = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(FILE_SAVE_PARTIE))));
        } catch (EOFException e) {
            return save;
        }
        try {
            java.lang.Object line = null;
            while ((line = ois.readObject()) != null)
                save.add((Jeu) line);
        } catch (EOFException ignored) {
        }
        ois.close();
        return save;
    }

    public static void saveParties(List<Jeu> jeux) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(FILE_SAVE_PARTIE))));
        for (Jeu jeu : jeux)
            oos.writeObject(jeu);
        oos.close();
    }

    public String getDate() {
        return SIMPLE_DATE_FORMAT.format(date);
    }

    private void changerJoueur() {
        if(tourJoueur == BLANC)
            tourJoueur = ROUGE;
        else
            tourJoueur = BLANC;
    }

    public boolean deplacer(int x, int y, int x2, int y2, int decoupe, int couleurJoueur) {
        if(couleurJoueur != tourJoueur)
            return false;

        boolean deplacement = false;

        if(decoupe != PAS_DECOUPE)
            deplacement = grille.deplacer(x, y, x2, y2, decoupe, couleurJoueur);
        else
            deplacement = grille.deplacer(x, y, x2, y2, couleurJoueur);

        if(deplacement)
            changerJoueur();

        nbTour++;

        return deplacement;
    }

    public void saveScores() {
    }

    public boolean addPion(int x, int y, Pion pion) throws TailleMaximaleDepasseeException {
        if(pion.getCouleur() != tourJoueur)
            return false;

        grille.addPion(x, y, pion);
        changerJoueur();
        nbTour++;

        return true;
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

    public int getNbTour() {
        return nbTour;
    }

    public Grille getGrille() {
        return grille;
    }

    public int getTourJoueur() {
        return tourJoueur;
    }

}