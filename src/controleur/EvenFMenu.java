package controleur;

import vue.FenetreGrille;
import vue.FenetreMenu;

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
            //MenuJeu menuBar = new MenuJeu();
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
