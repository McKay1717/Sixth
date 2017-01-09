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
import static model.Jeu.ROUGE;

/**
 * Created by ctx on 05/01/17.
 */
public class EventJeuAjouPionGrille implements ActionListener {

    public FenetreGrille fenetreGrille;
    public Jeu jeu;
    public int i;
    public int j;

    public EventJeuAjouPionGrille(FenetreGrille fenetreGrille, Jeu jeu, int i, int j) {
        this.fenetreGrille = fenetreGrille;
        this.jeu = jeu;
        this.i = i;
        this.j = j;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (jeu.getTourJoueur() == ROUGE) {
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
            jeu.addPion(i, j, jeu.getJoueur(jeu.getTourJoueur()).getPion());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
