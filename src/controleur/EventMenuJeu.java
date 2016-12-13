package controleur;


import vue.MenuJeu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static java.lang.System.exit;
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
}