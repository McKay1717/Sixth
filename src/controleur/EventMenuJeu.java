package controleur;


import model.Jeu;
import vue.MenuJeu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import static controleur.ControlleurGeneral.NOM_FENETRE_CHARGEMENT_PARTIE;
import static java.lang.System.exit;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import static model.Jeu.loadPartie;
import static vue.VueScores.afficheScores;

public class EventMenuJeu implements ActionListener {
    private ControlleurGeneral controlleurGeneral;
    private MenuJeu menuJeu;
    private JFrame fenetre;

    public EventMenuJeu(MenuJeu menuJeu, ControlleurGeneral controlleurGeneral) {
        this.menuJeu = menuJeu;
        this.controlleurGeneral = controlleurGeneral;
        menuJeu.setEventMenuJeu(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (((JMenuItem) e.getSource()).getText().equals("Accueil"))
                accueil();
            else if (((JMenuItem) e.getSource()).getText().equals("Quitter"))
                exit(0);
            else if (((JMenuItem) e.getSource()).getText().equals("Meilleurs scores"))
                afficheMeilleursScores();
            else if (((JMenuItem) e.getSource()).getText().equals("Charger la dernière partie sauvegardée"))
                loadJeu();
            else if (((JMenuItem) e.getSource()).getText().equals("Sauvegarder la partie"))
                saveJeu();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public void accueil() throws IOException {
        controlleurGeneral.createFenetreMenu();
    }

    public void afficheMeilleursScores() throws IOException, ClassNotFoundException {
        afficheScores(fenetre);
    }

    public void loadJeu() throws IOException, ClassNotFoundException {
        List<Jeu> jeux = loadPartie();
        if (jeux.size() == 0)
            showMessageDialog(fenetre, "Aucune partie enregistrée", NOM_FENETRE_CHARGEMENT_PARTIE, INFORMATION_MESSAGE);
        else {
            String contenu = "";
            for (Jeu jeu : jeux)
                contenu += jeu.getDate() + "\n";
            showMessageDialog(fenetre, contenu, NOM_FENETRE_CHARGEMENT_PARTIE, INFORMATION_MESSAGE);
        }
    }

    public void saveJeu() throws IOException, ClassNotFoundException {
        controlleurGeneral.saveJeu();
    }
}