package vue;

import model.Grille;

import javax.swing.*;
import java.awt.*;

public class FenetreGrille extends JFrame {

    private Grille grille;
    private GrillePanel grillePanel;
    public FenetreGrille() {

        creerWidget();

        setSize(800,600);                                // Fixe la taille par défaut
        setLocationRelativeTo(null);                     //position de la fenetre sur l'ordi
        setTitle("Sixth");                       //donne un titre au jFrame
        setResizable(false);                             //empaiche la redimention du JFrame
        //setIconImage(...)                              //associer une icon a la fenetre
        setVisible(true);                                // Affiche la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Gestion de la fermeture
    }

    private void creerWidget() {
        JPanel pFram = new JPanel();



        JPanel pPilePiece = new JPanel(new GridLayout(2,1));
        JButton bPileBlanc = new JButton("Blanc");
            bPileBlanc.setForeground(Color.WHITE);
        JButton bPileRouge = new JButton("Rouge");
            bPileRouge.setForeground(Color.RED);
        //affichage de la grille
        grille = new Grille();
        grillePanel = new GrillePanel(grille);
        //grille.addMouseListener((new EventSouris(grille,this)); //getion des events

        JPanel pGrille = new JPanel();

//        //disposition des panels
//        Container contp = getContentPane();
//        contp.setLayout(new GridBagLayout());
//        GridBagConstraints gbd = new GridBagConstraints();
//        gbd.ipadx = 500;
//        gbd.ipady = 500;
//        contp.add(grillePanel, gbd);

        pPilePiece.add(bPileBlanc);


        pPilePiece.add(bPileRouge);



        pGrille.add(grillePanel);
        pFram.add(pPilePiece,BorderLayout.WEST);
        pFram.add(pGrille,BorderLayout.EAST);

        setContentPane(pFram);
    }

    public GrillePanel getGrille() {
        return grillePanel;
    }
}
