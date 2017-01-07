package controleur;

import model.Jeu;
import model.Joueur;
import vue.FenetreGrille;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class EventJeuDeplacerPiece implements ActionListener {
    public FenetreGrille fenetreGrille;
    public Jeu jeu;
    public Joueur joueur;
    int i;
    int j;

    public EventJeuDeplacerPiece(FenetreGrille fenetreGrille, Jeu jeu, Joueur joueur, int i, int j) {
        this.fenetreGrille = fenetreGrille;
        this.jeu = jeu;
        this.joueur = joueur;
        this.i = i;
        this.j = j;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        ///////////////

        if (jeu.finDePartie()){
            showMessageDialog(fenetreGrille, "Le joueur " + joueur.getNom() + " a gagné.", "C'est Gagner", INFORMATION_MESSAGE);
            //fenetreGrille.setVisible(false);
        }

    }
}
