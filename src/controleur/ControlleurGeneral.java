package controleur;

import model.Jeu;
import model.Joueur;
import vue.FenetreGrille;
import vue.FenetreMenu;
import vue.MenuJeu;

import javax.swing.*;
import java.io.IOException;

public class ControlleurGeneral {
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
        try {
            fenetre = new FenetreGrille(R, B, jeu);
            ((FenetreGrille) fenetre).setJMenuBar(menuJeu);
            createMenuJeu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createMenuJeu() {
        menuJeu = new MenuJeu(fenetre);
        eventMenuJeu = new EventMenuJeu(menuJeu, this);
    }

    public void saveJeu() throws IOException {
        jeu.savePartie();
    }
}