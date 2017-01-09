package controleur;

import vue.FenetreMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.*;

public class EvenFMenu implements ActionListener {

    private FenetreMenu fenetreMenu;
    private ControlleurGeneral controlleurGeneral;

    public EvenFMenu(FenetreMenu fenetreMenu, ControlleurGeneral controlleurGeneral) {
        this.fenetreMenu = fenetreMenu;
        this.controlleurGeneral = controlleurGeneral;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(fenetreMenu.getbPLay())) {
            String joueur_rouge = showInputDialog(fenetreMenu, "Entrez le nom du joueur rouge.", "Noms des joueurs", QUESTION_MESSAGE);
            while (joueur_rouge.equals("")) {
                showMessageDialog(fenetreMenu, "Vous n'avez pas entré de pseudonyme.", "Noms des joueurs", INFORMATION_MESSAGE);
                joueur_rouge = showInputDialog(fenetreMenu, "Entrez le nom du joueur rouge.", "Noms des joueurs", QUESTION_MESSAGE);
            }
            String joueur_blanc = showInputDialog(fenetreMenu, "Entrez le nom du joueur blanc", "Noms des joueurs", QUESTION_MESSAGE);
            while (joueur_blanc.equals("")) {
                showMessageDialog(fenetreMenu, "Vous n'avez pas entré de pseudonyme.", "Noms des joueurs", INFORMATION_MESSAGE);
                joueur_blanc = showInputDialog(fenetreMenu, "Entrez le nom du joueur blanc", "Noms des joueurs", QUESTION_MESSAGE);
            }
            while (joueur_blanc.equals(joueur_rouge)) {
                showMessageDialog(fenetreMenu, "Vous avez entré le même pseudonyme que pour le joueur rouge.", "Noms des joueurs", INFORMATION_MESSAGE);
                joueur_blanc = showInputDialog(fenetreMenu, "Entrez le nom du joueur blanc", "Noms des joueurs", QUESTION_MESSAGE);
            }
            controlleurGeneral.createFenetreGrille(joueur_rouge, joueur_blanc);
        } else if (actionEvent.getSource().equals(fenetreMenu.getbQuit())) {
            System.exit(0);
        }
    }

    public FenetreMenu getFenetreMenu() {
        return fenetreMenu;
    }
}
