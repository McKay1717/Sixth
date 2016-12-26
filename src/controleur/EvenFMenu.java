package controleur;

import vue.FenetreMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;

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
            String joueur_blanc = showInputDialog(fenetreMenu, "Entrez le nom du joueur blanc", "Noms des joueurs", QUESTION_MESSAGE);
            controlleurGeneral.createFenetreGrille(joueur_rouge, joueur_blanc);
        } else if (actionEvent.getSource().equals(fenetreMenu.getbQuit())) {
            System.exit(0);
        }
    }

    public FenetreMenu getFenetreMenu() {
        return fenetreMenu;
    }
}
