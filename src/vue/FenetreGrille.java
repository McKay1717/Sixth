package vue;

import controleur.ControlleurGeneral;
import controleur.EventJeuAjouPionGrille;
import controleur.EventJeuPilePion;
import model.Grille;
import model.Jeu;
import model.Joueur;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static model.Jeu.BLANC;

public class FenetreGrille extends JFrame {


    private Grille grille;
    private GrillePanel grillePanel;
    private FontPanel fontPanel;
    private ControlleurGeneral controlleurGeneral;

    private int fWidth;
    private int fHeight;

    public Joueur joueurR;
    public Joueur joueurB;
    private Jeu jeu;
    public int tourActuel;
    public int nbPionRRestant;
    public int nbPionBRestant;

    public FenetreGrille(Joueur R, Joueur B, Jeu jeu, ControlleurGeneral controlleurGeneral) throws IOException {
        joueurB = B;
        joueurR = R;
        fWidth = 1000;
        fHeight = 700;

        this.jeu = jeu;
        this.controlleurGeneral = controlleurGeneral;

        tourActuel = jeu.getTourJoueur();

        nbPionBRestant = joueurB.getNbPionsRestants();
        nbPionRRestant = joueurR.getNbPionsRestants();

        fontPanel = new FontPanel(new ImageIcon("dataImage/textureGazon.jpg").getImage(), fWidth, fHeight);

        addComponentListener(fontPanel);

        creerWidget();


        setMaximizedBounds(new Rectangle(20, 20, 1100, 750));
        setSize(fWidth, fHeight);                                // Fixe la taille par défaut
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


        JPanel pPilePiece = new JPanel(new GridLayout(3, 1));
        pPilePiece.setOpaque(false);

        Dimension d = new Dimension(75, 75);
        FontButton bPileBlanc = null;
        FontButton bPileRouge = null;
        JPanel pPileBlanc = null;
        JPanel pPileRouge = null;
        affichePiles(d, bPileBlanc, bPileRouge, pPileBlanc, pPileRouge);
        System.out.println(bPileBlanc);


        //affichage de la grille
        grille = new Grille();
        grillePanel = new GrillePanel(grille);


        //gestion des tours

        JLabel lTourActuelle = null;

        if (tourActuel == BLANC){

            //listener
            bPileBlanc.addActionListener(new EventJeuPilePion(this, jeu));

            //affichage tour actuelle
            lTourActuelle = new JLabel("TOUR DE " + joueurB.getNom());
            lTourActuelle.setForeground(Color.WHITE);
        }else {

            //listener
            bPileRouge.addActionListener(new EventJeuPilePion(this, jeu));
            //grille.addMouseListener((new EventSouris(grille,this)); //getion des events

            //affichage tour actuelle
            lTourActuelle = new JLabel("TOUR DE " + joueurR.getNom());
            lTourActuelle.setForeground(Color.RED);
        }

        affichePiles(d, bPileBlanc, bPileRouge, pPileBlanc, pPileRouge);

        Font f = new Font("Serif", Font.PLAIN, 36);
        lTourActuelle.setFont(f);

        //---Disposition des panels
        pPilePiece.add(lTourActuelle);
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

    private void affichePiles(Dimension d, FontButton bPileBlanc, FontButton bPileRouge, JPanel pPileBlanc, JPanel pPileRouge) throws IOException {
        //affichage de la pile

        bPileBlanc = new FontButton(
                String.valueOf(nbPionBRestant),
                new ImageIcon("dataImage/pieceBlanc/rond-blanc" + nbPionBRestant + ".png").getImage(),
                75, 75);
        bPileBlanc.setPreferredSize(d);
        //bPileBlanc.setBackground(Color.WHITE);

        pPileBlanc = new JPanel();
        pPileBlanc.add(bPileBlanc);
        pPileBlanc.setOpaque(false);


        bPileRouge = new FontButton(
                String.valueOf(nbPionRRestant),
                new ImageIcon("dataImage/pieceRouge/rond-rouge" + nbPionRRestant + ".png").getImage(),
                75, 75);
        bPileRouge.setPreferredSize(d);
        //bPileRouge.setBackground(Color.RED);
        bPileRouge.setForeground(Color.WHITE);

        pPileRouge = new JPanel();
        pPileRouge.add(bPileRouge);
        pPileRouge.setOpaque(false);
    }
}
