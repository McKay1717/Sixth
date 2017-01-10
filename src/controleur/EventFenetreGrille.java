package controleur;

import model.Jeu;
import vue.FenetreGrille;
import vue.FenetrePiece;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import static model.Grille.LARGEUR;
import static model.Grille.LONGUEUR;
import static model.Jeu.BLANC;
import static model.Jeu.ROUGE;

public class EventFenetreGrille implements ActionListener {
    public int sizeofDeplace;
    boolean suspendPion;
    FenetreGrille fenetreGrille;
    Jeu jeu;
    ControlleurGeneral controlleurGeneral;
    boolean deplace;
    int x, y;

    public EventFenetreGrille(FenetreGrille fenetreGrille, Jeu jeu, ControlleurGeneral controlleurGeneral) {
        suspendPion = false;
        this.fenetreGrille = fenetreGrille;
        this.jeu = jeu;
        this.controlleurGeneral = controlleurGeneral;
        deplace = false;
        x = -1;
        y = -1;
        sizeofDeplace = -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (suspendPion) {
            for (int i = 0; i < LONGUEUR; i++)
                for (int j = 0; j < LARGEUR; j++) {
                    if (e.getSource().equals(fenetreGrille.getGrille().getGrillButton()[i][j])) {
                        try {
                            if (!jeu.addPion(i, j, jeu.getJoueur(jeu.getTourJoueur()).getPion()))
                                return;
                            fenetreGrille.tourJoueur();
                            fenetreGrille.repaint();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        if (jeu.getTourJoueur() == ROUGE) {
                            fenetreGrille.getGrille().getGrillButton()[i][j].setImagefond(new ImageIcon("dataImage/pieceBlanc/rond-blanc.png").getImage());
                            fenetreGrille.getGrille().getGrillButton()[i][j].setHeight(600 / 5);
                            fenetreGrille.getGrille().getGrillButton()[i][j].setWidth(600 / 5);
                        } else {
                            fenetreGrille.getGrille().getGrillButton()[i][j].setImagefond(new ImageIcon("dataImage/pieceRouge/rond-rouge.png").getImage());
                            fenetreGrille.getGrille().getGrillButton()[i][j].setHeight(600 / 5);
                            fenetreGrille.getGrille().getGrillButton()[i][j].setWidth(600 / 5);
                        }

                        fenetreGrille.bPileBlanc.setImagefond(new ImageIcon("dataImage/pieceBlanc/rond-blanc" + jeu.getJoueur(BLANC).getNbPionsRestants() + ".png").getImage());
                        fenetreGrille.bPileRouge.setImagefond(new ImageIcon("dataImage/pieceRouge/rond-rouge" + jeu.getJoueur(ROUGE).getNbPionsRestants() + ".png").getImage());
                    }
                }
            suspendPion = false;
        } else if (e.getSource().equals(fenetreGrille.bPileBlanc) && jeu.getTourJoueur() == BLANC)
            suspendPion = true;
        else if (e.getSource().equals(fenetreGrille.bPileRouge) && jeu.getTourJoueur() == ROUGE)
            suspendPion = true;
        else {
            for (int i = 0; i < LONGUEUR; i++)
                for (int j = 0; j < LARGEUR; j++)
                    if (e.getSource().equals(fenetreGrille.getGrille().getGrillButton()[i][j])) {
                        if (deplace) {
                            jeu.deplacer(x, y, i, j, sizeofDeplace, jeu.getTourJoueur());

                            //reset des valeurs
                            deplace = false;
                            x = -1;
                            y = -1;
                            sizeofDeplace = -1;
                            try {
                                fenetreGrille.tourJoueur();
                                fenetreGrille.repaint();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            new FenetrePiece(jeu.getPiece(i, j).getTaille(), controlleurGeneral);
                            deplace = true;
                            x = i;
                            y = j;
                        }
                    }
        }

        if (jeu.finDePartie()) {
            showMessageDialog(fenetreGrille, "Le joueur " + jeu.getJoueur(jeu.getTourJoueur()).getNom() + " a gagné.", "C'est gagner", INFORMATION_MESSAGE);
            try {
                controlleurGeneral.createFenetreMenu();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}