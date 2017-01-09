package controleur;

import model.Jeu;
import vue.FenetreGrille;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static model.Grille.LARGEUR;
import static model.Grille.LONGUEUR;
import static model.Jeu.ROUGE;

public class EventFenetreGrille implements ActionListener {
    boolean suspendPion;
    FenetreGrille fenetreGrille;
    Jeu jeu;

    public EventFenetreGrille(FenetreGrille fenetreGrille, Jeu jeu) {
        suspendPion = false;
        this.fenetreGrille = fenetreGrille;
        this.jeu = jeu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!suspendPion) {
            suspendPion = true;
            for (int i = 0; i < LONGUEUR; i++)
                for (int j = 0; j < LARGEUR; j++) {
                    if (e.getSource().equals(fenetreGrille.getGrille().getGrillButton()[i][j])) {
                        if (jeu.getTourJoueur() == ROUGE) {
                            fenetreGrille.getGrille().getGrillButton()[i][j].setImagefond(new ImageIcon("dataImage/pieceBlanc/rond-blanc.png").getImage());
                            fenetreGrille.getGrille().getGrillButton()[i][j].setHeight(600 / 5);
                            fenetreGrille.getGrille().getGrillButton()[i][j].setWidth(600 / 5);

                        } else {
                            fenetreGrille.getGrille().getGrillButton()[i][j].setImagefond(new ImageIcon("dataImage/pieceRouge/rond-rouge.png").getImage());
                            fenetreGrille.getGrille().getGrillButton()[i][j].setHeight(600 / 5);
                            fenetreGrille.getGrille().getGrillButton()[i][j].setWidth(600 / 5);
                        }

                        try {
                            jeu.addPion(i, j, jeu.getJoueur(jeu.getTourJoueur()).getPion());

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
        } else
            suspendPion = false;
    }
}