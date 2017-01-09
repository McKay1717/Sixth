package vue;

import controleur.ControlleurGeneral;
import controleur.EventFenetrePiece;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static model.Piece.*;

public class FenetrePiece extends JFrame {
    public FenetrePiece(int taille, ControlleurGeneral controlleurGeneral) {
        creerWidget(taille, controlleurGeneral);

        setSize(200, 200);
        setLocationRelativeTo(null);
        setTitle("Déplacement");
        setResizable(false);
        setVisible(true);
    }

    private void creerWidget(int taille, ControlleurGeneral controlleurGeneral) {
        List<JButton> jButtons = new ArrayList<>();
        if (taille >= PION)
            jButtons.add(new JButton("Pion"));
        if (taille >= TOUR)
            jButtons.add(new JButton("Tour"));
        if (taille >= CAVALIER)
            jButtons.add(new JButton("Cavalier"));
        if (taille >= FOU)
            jButtons.add(new JButton("Fou"));
        if (taille >= DAME)
            jButtons.add(new JButton("Dame"));
        if (taille >= ROI)
            jButtons.add(new JButton("Roi"));

        JPanel jPanel = new JPanel();
        EventFenetrePiece eventFenetrePiece = new EventFenetrePiece(this, controlleurGeneral);
        for (JButton jButton : jButtons) {
            jButton.addActionListener(eventFenetrePiece);
            jPanel.add(jButton);
        }

        setContentPane(jPanel);
    }
}