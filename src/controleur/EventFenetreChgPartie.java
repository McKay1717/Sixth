package controleur;

import model.Jeu;
import vue.FenetreChgPartie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import static model.Jeu.saveParties;

public class EventFenetreChgPartie implements ActionListener {
    private ControlleurGeneral controlleurGeneral;
    private FenetreChgPartie fenetre;

    public EventFenetreChgPartie(ControlleurGeneral controlleurGeneral, FenetreChgPartie fenetre) {
        this.controlleurGeneral = controlleurGeneral;
        this.fenetre = fenetre;
        ((FenetreChgPartie) fenetre).setEventFenetreChgPartie(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < fenetre.getNbParties(); i++) {
            if (((JButton) e.getSource()).getText().equals("Charger la partie n°" + Integer.toString(i + 1)))
                controlleurGeneral.createFenetreGrille(fenetre.getJeu(i));
            else if (((JButton) e.getSource()).getText().equals("Supprimer la partie n°" + Integer.toString(i + 1))) {
                List<Jeu> jeux = fenetre.getJeux();
                jeux.remove(jeux.get(i));
                try {
                    saveParties(jeux);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                if (jeux.size() != 0)
                    controlleurGeneral.deletePartie();
                else {
                    try {
                        controlleurGeneral.aucunePartieACharger();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }
}