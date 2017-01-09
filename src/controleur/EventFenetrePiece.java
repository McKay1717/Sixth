package controleur;

import vue.FenetrePiece;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static model.Piece.*;

public class EventFenetrePiece implements ActionListener {
    FenetrePiece fenetrePiece;
    ControlleurGeneral controlleurGeneral;

    public EventFenetrePiece(FenetrePiece fenetrePiece, ControlleurGeneral controlleurGeneral) {
        this.fenetrePiece = fenetrePiece;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
            case "Pion":
                ((EventFenetreGrille) controlleurGeneral.event).sizeofDeplace = PION;
                break;
            case "Tour":
                ((EventFenetreGrille) controlleurGeneral.event).sizeofDeplace = TOUR;
                break;
            case "Cavalier":
                ((EventFenetreGrille) controlleurGeneral.event).sizeofDeplace = CAVALIER;
                break;
            case "Fou":
                ((EventFenetreGrille) controlleurGeneral.event).sizeofDeplace = FOU;
                break;
            case "Dame":
                ((EventFenetreGrille) controlleurGeneral.event).sizeofDeplace = DAME;
                break;
            case "Roi":
                ((EventFenetreGrille) controlleurGeneral.event).sizeofDeplace = ROI;
                break;
        }
        fenetrePiece.removeAll();
        fenetrePiece.setVisible(false);
    }
}
