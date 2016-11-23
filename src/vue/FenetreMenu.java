package vue;

import controleur.EvenFMenu;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class FenetreMenu extends JFrame {

    //Image backGround;

    private JButton bPLay ;
    private JButton bQuit ;

    private FontPanel fontPanel;

    public FenetreMenu() throws IOException {

        fontPanel = new FontPanel(new ImageIcon("dataImage/font2.jpg").getImage());
        creerWidget();

        setSize(400,400);                                // Fixe la taille par défaut
        setLocationRelativeTo(null);                     //position de la fenetre sur l'ordi
        setVisible(true);                                // Affiche la fenetre
        setTitle("Menu Sixth");                          //donne un titre au jFrame
        //setIconImage(...)                              //associer une icon a la fenetre
        setResizable(false);                             //empaiche la redimention du JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Gestion de la fermeture
    }

    private void creerWidget() {

        JPanel pCentrageMenu = new JPanel(new BorderLayout());
        pCentrageMenu.setLayout(new GridLayout(2,1));

        JPanel pButton = new JPanel();
        pButton.setLayout(new GridLayout(2,1));

        JPanel pTitel = new JPanel();

        JPanel pPLay = new JPanel();
        JPanel pQuit = new JPanel();

        JLabel lTitel = new JLabel("Sixth");
        lTitel.setFont(new Font("FreeMono",Font.PLAIN,35));

        bPLay = new JButton("Play-Game");
        bQuit = new JButton("Quitter");

        //construction de Frame
        pTitel.add(lTitel);
        pPLay.add(bPLay);
        pQuit.add(bQuit);

        pButton.add(pPLay);
        pButton.add(pQuit);

        pCentrageMenu.add(pTitel, BorderLayout.CENTER);
        pCentrageMenu.add(pButton, BorderLayout.CENTER);



        //bPLay.addActionListener(new EvenFMenu(this));
        bQuit.addActionListener(new EvenFMenu(this));

        fontPanel.add(pCentrageMenu);

        setContentPane(fontPanel);
    }

    public JButton getbPLay() {
        return bPLay;
    }

    public JButton getbQuit() {
        return bQuit;
    }

    public FontPanel getFontPanel() {
        return fontPanel;
    }
}
