package controleur;

import model.Grille;
import vue.FenetreGrille;
import vue.FenetreMenu;
import vue.GrillePanel;

import java.awt.*;
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
            //Menu menuBar = new Menu();
            FenetreGrille fenetreGrille = new FenetreGrille();
            //EventMenuScore eventMenu = new EventMenuScore();
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
