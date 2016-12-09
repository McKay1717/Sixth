package controleur;

import vue.FenetreGrille;
import vue.FenetreMenu;
import vue.MenuJeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvenFMenu implements ActionListener {

    private FenetreMenu fenetreMenu ;

    public EvenFMenu(FenetreMenu fenetreMenu) {
        this.fenetreMenu = fenetreMenu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(fenetreMenu.getbPLay())){
            fenetreMenu.setVisible(false);
            FenetreGrille fenetreGrille = new FenetreGrille();
            MenuJeu menuBar = new MenuJeu(fenetreGrille);
            EventMenuScore eventMenu = new EventMenuScore();
        }
        else
        if (actionEvent.getSource().equals(fenetreMenu.getbQuit())){
            System.exit(0);
        }
    }

    public FenetreMenu getFenetreMenu() {
        return fenetreMenu;
    }
}
