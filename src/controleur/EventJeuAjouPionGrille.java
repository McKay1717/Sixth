package controleur;

import exceptions.TailleMaximaleDepasseeException;
import model.Jeu;
import model.Joueur;
import model.Pion;
import vue.FenetreGrille;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Created by ctx on 05/01/17.
 */
public class EventJeuAjouPionGrille implements ActionListener {

    public FenetreGrille fenetreGrille;
    public Jeu jeu;
    public Joueur joueur;
    public int i;
    public int j;

    public EventJeuAjouPionGrille(FenetreGrille fenetreGrille, Jeu jeu, Joueur joueur, int i, int j) {
        this.fenetreGrille = fenetreGrille;
        this.jeu = jeu;
        this.joueur = joueur;
        this.i = i;
        this.j = j;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (joueur.getCouleur() == -1) {
            fenetreGrille.getGrille().getGrillButton()[i][j].setImagefond(new ImageIcon("dataImage/pieceBlanc/rond-blanc.png").getImage());
            //if (jeu.getGrille().getCase(i,j).isVide()){
                fenetreGrille.getGrille().getGrillButton()[i][j].setHeight(600/5);
                fenetreGrille.getGrille().getGrillButton()[i][j].setWidth(600/5);
            //}else {
            //    fenetreGrille.getGrille().getGrillButton()[i][j].setHeight((600/5)-(15*(jeu.getGrille().getCase(i,j).getPiece().getTaille())));
             //   fenetreGrille.getGrille().getGrillButton()[i][j].setWidth((600/5)-(15*(jeu.getGrille().getCase(i,j).getPiece().getTaille())));
            //}



        }else {
            fenetreGrille.getGrille().getGrillButton()[i][j].setImagefond(new ImageIcon("dataImage/pieceRouge/rond-rouge.png").getImage());
            //if (jeu.getGrille().getCase(i,j).isVide()){
                fenetreGrille.getGrille().getGrillButton()[i][j].setHeight(600/5);
                fenetreGrille.getGrille().getGrillButton()[i][j].setWidth(600/5);
            //}else{
            //    fenetreGrille.getGrille().getGrillButton()[i][j].setHeight((600/5)-(15*(jeu.getGrille().getCase(i,j).getPiece().getTaille())));
            //    fenetreGrille.getGrille().getGrillButton()[i][j].setWidth((600/5)-(15*(jeu.getGrille().getCase(i,j).getPiece().getTaille())));
            //}
        }
        ///////////



        try {
            jeu.addPion(i, j, new Pion(joueur.getCouleur(),joueur));

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (jeu.finDePartie()){
            showMessageDialog(fenetreGrille, "Le joueur " + joueur.getNom() + " a gagné.", "C'est Gagner", INFORMATION_MESSAGE);
            //fenetreGrille.setVisible(false);

        }
    }
}
