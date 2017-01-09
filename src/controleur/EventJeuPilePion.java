package controleur;

import model.Grille;
import model.Jeu;
import model.Joueur;
import vue.FenetreGrille;
import vue.FontButton;
import vue.GrillePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventJeuPilePion implements ActionListener {

    public FenetreGrille fenetreGrille;
    public Jeu jeu;

    public Boolean suspendPion;

    public EventJeuPilePion(FenetreGrille fenetreGrille, Jeu jeu){
        this.fenetreGrille = fenetreGrille;
        this.jeu = jeu;

        suspendPion = false;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (!suspendPion){
            suspendPion = true;

            for (int i = 0 ; i < 5 ; i++)
                for (int j = 0 ; j < 5 ; j++)
                    fenetreGrille.getGrille().getGrillButton()[i][j].addActionListener(new EventJeuAjouPionGrille(fenetreGrille, jeu, i, j));

        }else{
           suspendPion = false;
        }
    }
}
