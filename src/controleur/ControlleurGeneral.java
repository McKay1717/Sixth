package controleur;

import model.Jeu;
import model.Joueur;
import vue.FenetreChgPartie;
import vue.FenetreGrille;
import vue.FenetreMenu;
import vue.MenuJeu;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import static javax.swing.JOptionPane.*;

public class ControlleurGeneral {
    public static final String NOM_FENETRE_CHARGEMENT_PARTIE = "Chargement de partie";
    public JFrame fenetre;
    public ActionListener event;
    public Jeu jeu;
    MenuJeu menuJeu;
    EventMenuJeu eventMenuJeu;
    Joueur R;
    Joueur B;

    public ControlleurGeneral() throws IOException {
        createFenetreMenu();
        createMenuJeu();
    }

    public void createFenetreMenu() throws IOException {
        if (fenetre != null) {
            fenetre.setVisible(false);
            fenetre.removeAll();
        }
        fenetre = new FenetreMenu();
        event = new EvenFMenu((FenetreMenu) fenetre, this);
        ((FenetreMenu) fenetre).addEvenFMenu(event);
        createMenuJeu();
    }

    public void aucunePartieACharger() throws IOException {
        createFenetreMenu();
        showMessageDialog(fenetre, "Partie supprimée", NOM_FENETRE_CHARGEMENT_PARTIE, INFORMATION_MESSAGE);
    }

    public void createFenetreGrille() {
        event = null;
        if (fenetre != null) {
            fenetre.setVisible(false);
            fenetre.removeAll();
        }
        R = new Joueur(Jeu.ROUGE, "toto");
        B = new Joueur(Jeu.BLANC, "toto");
        try {
            jeu = new Jeu();
            jeu.setJoueurs(R, B);
            fenetre = new FenetreGrille(R, B, jeu);
            createMenuJeu();
            ((FenetreGrille) fenetre).setJMenuBar(menuJeu);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            showMessageDialog(fenetre, e.getMessage(), "Jeu — dateParse", ERROR_MESSAGE);
        }
    }

    public void createFenetreGrille(Jeu jeu) {
        event = null;
        if (fenetre != null) {
            fenetre.setVisible(false);
            fenetre.removeAll();
        }
        Joueur[] joueurs = jeu.getJoueurs();
        R = joueurs[0];
        B = joueurs[1];
        this.jeu = jeu;
        try {
            fenetre = new FenetreGrille(R, B, jeu);
            createMenuJeu();
            ((FenetreGrille) fenetre).setJMenuBar(menuJeu);
            showMessageDialog(fenetre, "Partie chargée", NOM_FENETRE_CHARGEMENT_PARTIE, INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFenetreChgPartie() {
        event = null;
        if (fenetre != null) {
            fenetre.setVisible(false);
            fenetre.removeAll();
        }
        try {
            fenetre = new FenetreChgPartie();
            createMenuJeu();
            ((FenetreChgPartie) fenetre).setJMenuBar(menuJeu);
            event = new EventFenetreChgPartie(this, (FenetreChgPartie) fenetre);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deletePartie() {
        createFenetreChgPartie();
        showMessageDialog(fenetre, "Partie supprimée", NOM_FENETRE_CHARGEMENT_PARTIE, INFORMATION_MESSAGE);
    }

    public void createMenuJeu() {
        menuJeu = new MenuJeu(fenetre);
        eventMenuJeu = new EventMenuJeu(menuJeu, this);
    }

    public void saveJeu() throws IOException, ClassNotFoundException {
        jeu.savePartie();
    }
}