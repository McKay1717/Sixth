package vue;

import model.Grille;

import javax.management.loading.PrivateClassLoader;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GrillePanel extends JPanel{
    private static final int TAILLE_GRILLE = 5;
    private Grille grille;



    private FontButton[][] grillButton;

    public GrillePanel(Grille grille) {
        super();
        this.grille = grille;

        try {
            initAtribut();
        } catch (IOException e) {
            e.printStackTrace();
        }
        creerWidget();

        setBackground(Color.GREEN);
    }

    private void initAtribut() throws IOException {
        grillButton = new FontButton[TAILLE_GRILLE][TAILLE_GRILLE];

         //FontButton fontWood = new FontButton(new ImageIcon("dataImage/texture-planche").getImage());

        for (int i = 0 ; i < TAILLE_GRILLE ; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {

                if (String.valueOf(grille.getPiece(i,j)) != null)
                    if (i%2 == 0){
                        if (j%2 == 0) {
                            grillButton[i][j] = new FontButton( String.valueOf(grille.getPiece(i, j)), new ImageIcon("dataImage/texture-planche.jpg").getImage(), (600/5)*2, (600/5)*2);

                        }else {
                            grillButton[i][j] = new FontButton( String.valueOf(grille.getPiece(i, j)), new ImageIcon("dataImage/texture-bois.jpg").getImage(), (600/5)*2, (600/5)*2);

                        }
                    }else{
                        if (j % 2 == 1) {
                            grillButton[i][j] = new FontButton( String.valueOf(grille.getPiece(i, j)), new ImageIcon("dataImage/texture-planche.jpg").getImage(), (600/5)*2, (600/5)*2);

                        } else {
                            grillButton[i][j] = new FontButton( String.valueOf(grille.getPiece(i, j)), new ImageIcon("dataImage/texture-bois.jpg").getImage(), (600/5)*2, (600/5)*2);

                        }
                    }else{
                        grillButton[i][j] = null ;

                    }
            }
        }
    }

    private void creerWidget() {
        JPanel pGrille = new JPanel(new GridLayout(TAILLE_GRILLE , TAILLE_GRILLE ));
        for (int i = 0 ; i < TAILLE_GRILLE ; i++)
            for (int j = 0 ; j < TAILLE_GRILLE  ; j++) {
                pGrille.add(grillButton[i][j]);
                pGrille.setPreferredSize(new Dimension(600,600));
            }


        add(pGrille);
    }

    public FontButton[][] getGrillButton() {
        return grillButton;
    }

}
