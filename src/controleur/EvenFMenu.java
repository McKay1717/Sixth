package controleur;

import model.Jeu;
import model.Joueur;
import vue.FenetreGrille;
import vue.FenetreMenu;
import vue.MenuJeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EvenFMenu implements ActionListener {

    private FenetreMenu fenetreMenu ;

    public EvenFMenu(FenetreMenu fenetreMenu) {
        this.fenetreMenu = fenetreMenu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(fenetreMenu.getbPLay())){
            fenetreMenu.setVisible(false);
            Joueur R = new Joueur(Jeu.ROUGE,"toto");
            Joueur B = new Joueur(Jeu.BLANC,"toto");
            FenetreGrille fenetreGrille = null;
            try {
                fenetreGrille = new FenetreGrille(R,B);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
