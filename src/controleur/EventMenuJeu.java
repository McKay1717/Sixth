package controleur;


import vue.FenetreMenu;
import vue.MenuJeu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EventMenuJeu implements ActionListener {
    private MenuJeu menuJeu;
    private JFrame fenetre;

    public EventMenuJeu(MenuJeu menuJeu, JFrame fenetre) {
        this.menuJeu = menuJeu;
        this.fenetre = fenetre;
        menuJeu.setEventMenuJeu(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((JMenuItem) e.getSource()).getText().equals("Accueil")) {
            try {
                accueil();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void accueil() throws IOException {
        fenetre = new FenetreMenu();
    }
}