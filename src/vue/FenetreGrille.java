package vue;

import model.Grille;
import model.Joueur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.awt.print.Printable;
import java.io.IOException;

public class FenetreGrille extends JFrame {


    private Grille grille;
    private GrillePanel grillePanel;
    private FontPanel fontPanel;

    private int fWidth;
    private int fLength;

    private Joueur joueurR ;
    private Joueur joueurB ;

    public FenetreGrille(Joueur R, Joueur B) throws IOException {
        joueurB = B;
        joueurR = R;
        fWidth = 1000;
        fLength = 700;

        fontPanel = new FontPanel(new ImageIcon("dataImage/textureGazon.jpg").getImage(), fWidth, fLength);

        addComponentListener(fontPanel);

        creerWidget();

        setSize(fWidth,fLength);                                // Fixe la taille par défaut
        setLocationRelativeTo(null);                     //position de la fenetre sur l'ordi
        setTitle("Sixth");                       //donne un titre au jFrame
        //setResizable(false);                             //empaiche la redimention du JFrame
        setMinimumSize(new Dimension(750, 700));
        //setIconImage(...)                              //associer une icon a la fenetre
        setVisible(true);                                // Affiche la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Gestion de la fermeture
    }

    private void creerWidget() throws IOException {
        JPanel pFram = new JPanel();
            pFram.setOpaque(false);

        JPanel pPrinc = new JPanel();
            pPrinc.setOpaque(false);


        //affichage de la pile
        JPanel pPilePiece = new JPanel(new GridLayout(2,1));
            pPilePiece.setOpaque(false);

            Dimension d = new Dimension(75, 75);

            FontButton bPileBlanc = new FontButton(
                    String.valueOf(joueurB.getNbPionsRestants()),
                    new ImageIcon("dataImage/pieceBlanc/rond-blanc"+joueurB.getNbPionsRestants()+".png").getImage(),
                    75, 75 );
                bPileBlanc.setPreferredSize(d);
                //bPileBlanc.setBackground(Color.WHITE);

                JPanel pPileBlanc = new JPanel();
                    pPileBlanc.add(bPileBlanc);
                    pPileBlanc.setOpaque(false);


            FontButton bPileRouge = new FontButton(
                    String.valueOf(joueurR.getNbPionsRestants()),
                    new ImageIcon("dataImage/pieceRouge/rond-rouge"+joueurR.getNbPionsRestants()+".png").getImage(),
                    75, 75);
                bPileRouge.setPreferredSize(d);
                //bPileRouge.setBackground(Color.RED);
                bPileRouge.setForeground(Color.WHITE);

                JPanel pPileRouge = new JPanel();
                    pPileRouge.add(bPileRouge);
                    pPileRouge.setOpaque(false);

        //affichage de la grille
        grille = new Grille();
        grillePanel = new GrillePanel(grille);
        //grille.addMouseListener((new EventSouris(grille,this)); //getion des events


        //---Disposition des panels
        pPilePiece.add(pPileBlanc);
        pPilePiece.add(pPileRouge);

        JPanel pGrille = new JPanel();
            pGrille.setOpaque(false);
            pGrille.add(grillePanel);

        pPrinc.add(pPilePiece, BorderLayout.WEST);
        pPrinc.add(pGrille, BorderLayout.EAST);

        pFram.add(pPrinc);

        Box boxCentrage = Box.createVerticalBox();
        boxCentrage.add(Box.createVerticalStrut(0));
        boxCentrage.add(pFram, BorderLayout.CENTER);

        //Ecouteur lisner



        //affiche back ground
        fontPanel.add(boxCentrage, BorderLayout.CENTER);


        setContentPane(fontPanel);
    }

    public GrillePanel getGrille() {
        return grillePanel;
    }
}
