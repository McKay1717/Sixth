package vue;

import model.Grille;

import javax.management.loading.PrivateClassLoader;
import javax.swing.*;
import java.awt.*;

/**
 * Created by ctx on 02/12/16.
 */
public class GrillePanel extends JPanel{
    private static final int TAILLE_GRILLE = 5;
    private Grille grille;
    private JButton[][] grillButton;

    public GrillePanel(Grille grille) {
        super();
        this.grille = grille;

        initAtribut();
        creerWidget();
    }

    private void initAtribut() {
        grillButton = new JButton[TAILLE_GRILLE][TAILLE_GRILLE];

        for (int i = 0 ; i < TAILLE_GRILLE ; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {

                if (String.valueOf(grille.getPiece(i,j)) != null)
                    grillButton[i][j] = new JButton(String.valueOf(grille.getPiece(i, j)));
                 else
                    grillButton[i][j] = null ;


            }
        }

    }

    private void creerWidget() {
        JPanel pGrille = new JPanel(new GridLayout(TAILLE_GRILLE , TAILLE_GRILLE ));
        for (int i = 0 ; i < TAILLE_GRILLE ; i++)
            for (int j = 0 ; j < TAILLE_GRILLE  ; j++) {
                pGrille.add(grillButton[i][j]);
            }


        add(pGrille);
    }
}
