package controleur;

import model.Jeu;
import model.Joueur;
import vue.FenetreGrille;
import vue.FenetreMenu;
import vue.MenuJeu;

import javax.swing.*;
import java.io.IOException;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class ControlleurGeneral {
    public static final String NOM_FENETRE_CHARGEMENT_PARTIE = "Chargement de partie";
    public JFrame fenetre;
    public EvenFMenu evenFMenu;
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
        evenFMenu = new EvenFMenu((FenetreMenu) fenetre, this);
        ((FenetreMenu) fenetre).addEvenFMenu(evenFMenu);
        createMenuJeu();
    }

    public void createFenetreGrille() {
        evenFMenu = null;
        if (fenetre != null) {
            fenetre.setVisible(false);
            fenetre.removeAll();
        }
        R = new Joueur(Jeu.ROUGE, "toto");
        B = new Joueur(Jeu.BLANC, "toto");
        jeu = new Jeu();
        jeu.setJoueurs(R, B);
        try {
            fenetre = new FenetreGrille(R, B, jeu);
            createMenuJeu();
            ((FenetreGrille) fenetre).setJMenuBar(menuJeu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFenetreGrille(Jeu jeu) {
        evenFMenu = null;
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

    public void createMenuJeu() {
        menuJeu = new MenuJeu(fenetre);
        eventMenuJeu = new EventMenuJeu(menuJeu, this);
    }

    public void saveJeu() throws IOException, ClassNotFoundException {
        jeu.savePartie();
    }
}