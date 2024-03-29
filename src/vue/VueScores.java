package vue;

import model.Scores;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import static model.Jeu.BLANC;
import static model.Jeu.ROUGE;
import static model.Scores.readScores;

public class VueScores {
    public static final String NOM_FENETRE = "Meilleurs scores";

    public static void afficheScores(JFrame jFrame) throws IOException, ClassNotFoundException {
        List<Scores> scores = readScores();
        if (scores.size() == 0) {
            showMessageDialog(jFrame, "Aucun score enregistré", NOM_FENETRE, INFORMATION_MESSAGE);
            return;
        }

        String message = "";
        for (Scores score : scores) {
            message += score.getNomJoueur() + " — ";
            switch (score.getCouleur()) {
                case ROUGE:
                    message += " ROUGE";
                    break;
                case BLANC:
                    message += "BLANC";
                    break;
            }
            message += " — " + score.getNbCoups() + "\n";
        }
        showMessageDialog(jFrame, message, NOM_FENETRE, INFORMATION_MESSAGE);
    }
}