package controleur;

import vue.FenetreMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            controlleurGeneral.createFenetreGrille();
        } else if (actionEvent.getSource().equals(fenetreMenu.getbQuit())) {
            System.exit(0);
        }
    }

    public FenetreMenu getFenetreMenu() {
        return fenetreMenu;
    }
}
