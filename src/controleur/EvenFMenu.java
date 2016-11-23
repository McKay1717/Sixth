package controleur;

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
