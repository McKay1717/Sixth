package controleur;


import vue.MenuJeu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static java.lang.System.exit;

public class EventMenuJeu implements ActionListener {
    private ControlleurGeneral controlleurGeneral;
    private MenuJeu menuJeu;

    public EventMenuJeu(MenuJeu menuJeu, ControlleurGeneral controlleurGeneral) {
        this.menuJeu = menuJeu;
        this.controlleurGeneral = controlleurGeneral;
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
        } else if (((JMenuItem) e.getSource()).getText().equals("Quitter"))
            exit(0);
    }

    public void accueil() throws IOException {
        controlleurGeneral.createFenetreMenu();
    }
}