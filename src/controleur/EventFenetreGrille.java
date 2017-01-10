package controleur;

import model.Jeu;
import vue.FenetreGrille;
import vue.FenetrePiece;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.JOptionPane.*;
import static model.Grille.LARGEUR;
import static model.Grille.LONGUEUR;
import static model.Jeu.*;

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
                            fenetreGrille.getGrille().getGrillButton()[i][j].setImagefond(new ImageIcon("dataImage/pieceBlanc/rond-blanc1.png").getImage());
                            fenetreGrille.getGrille().getGrillButton()[i][j].setHeight(600 / 5);
                            fenetreGrille.getGrille().getGrillButton()[i][j].setWidth(600 / 5);
                        } else {
                            fenetreGrille.getGrille().getGrillButton()[i][j].setImagefond(new ImageIcon("dataImage/pieceRouge/rond-rouge1.png").getImage());
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
                            if (sizeofDeplace == jeu.getPiece(x, y).getTaille())
                                sizeofDeplace = PAS_DECOUPE;
                            if (jeu.deplacer(x, y, i, j, sizeofDeplace, jeu.getTourJoueur())) {
                                try {
                                    if (jeu.getPiece(x, y) != null) {
                                        if (jeu.getPiece(x, y).getCouleur() == BLANC)
                                            fenetreGrille.getGrille().getGrillButton()[x][y].setImagefond(new ImageIcon("dataImage/pieceBlanc/rond-blanc" + jeu.getPiece(x, y).getTaille() + ".png").getImage());
                                        else if (jeu.getPiece(x, y).getCouleur() == ROUGE)
                                            fenetreGrille.getGrille().getGrillButton()[x][y].setImagefond(new ImageIcon("dataImage/pieceRouge/rond-rouge" + jeu.getPiece(x, y).getTaille() + ".png").getImage());
                                    } else if (x % 2 != 0 && y % 2 != 0)
                                        fenetreGrille.getGrille().getGrillButton()[x][y].setImagefond(new ImageIcon("dataImage/texture-planche.jpg").getImage(), (600 / 5) * 2, (600 / 5) * 2);
                                    else
                                        fenetreGrille.getGrille().getGrillButton()[x][y].setImagefond(new ImageIcon("dataImage/texture-bois.jpg").getImage(), (600 / 5) * 2, (600 / 5) * 2);

                                    if (jeu.getPiece(i, j).getCouleur() == BLANC)
                                        fenetreGrille.getGrille().getGrillButton()[i][j].setImagefond(new ImageIcon("dataImage/pieceBlanc/rond-blanc" + jeu.getPiece(i, j).getTaille() + ".png").getImage());
                                    else if (jeu.getPiece(i, j).getCouleur() == ROUGE)
                                        fenetreGrille.getGrille().getGrillButton()[i][j].setImagefond(new ImageIcon("dataImage/pieceRouge/rond-rouge" + jeu.getPiece(i, j).getTaille() + ".png").getImage());

                                    fenetreGrille.tourJoueur();
                                    fenetreGrille.repaint();
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                            } else
                                showMessageDialog(fenetreGrille, "Déplacement impossible", "Déplacement", ERROR_MESSAGE);

                            //reset des valeurs
                            deplace = false;
                            x = -1;
                            y = -1;
                            sizeofDeplace = -1;
                        } else {
                            if (jeu.getPiece(i, j) != null) {
                                new FenetrePiece(jeu.getPiece(i, j).getTaille(), controlleurGeneral);
                                deplace = true;
                                x = i;
                                y = j;
                            }
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