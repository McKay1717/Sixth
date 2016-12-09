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

        fontPanel = new FontPanel(new ImageIcon("dataImage/font.png").getImage());

        creerWidget();

        setSize(1000,1000);                                // Fixe la taille par défaut
        setLocationRelativeTo(null);                     //position de la fenetre sur l'ordi
        setVisible(true);                                // Affiche la fenetre
        setTitle("MenuJeu Sixth");                          //donne un titre au jFrame
        //setIconImage(...)                              //associer une icon a la fenetre
        setResizable(false);                             //empaiche la redimention du JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Gestion de la fermeture
    }

    private void creerWidget() {

        JPanel pPrinc = new JPanel();
            pPrinc.setOpaque(false);

        JPanel pCentrageMenu = new JPanel(new BorderLayout());
            pCentrageMenu.setLayout(new GridLayout(2,1));
            pCentrageMenu.setOpaque(false);

        JPanel pButton = new JPanel();
            pButton.setLayout(new GridLayout(2,1));
            pButton.setOpaque(false);

        JPanel pTitel = new JPanel();
            pTitel.setOpaque(false);

        JPanel pPLay = new JPanel();
            pPLay.setOpaque(false);
        JPanel pQuit = new JPanel();
            pQuit.setOpaque(false);

        //JLabel lTitel = new JLabel("Sixth");
         //   lTitel.setFont(new Font("FreeMono",Font.PLAIN,35));

        bPLay = new JButton("Play");
            bPLay.setPreferredSize(new Dimension(200,80));
            bPLay.setFont(new Font("FreeMono",Font.PLAIN,35));
        bQuit = new JButton("Quitter");
            bQuit.setPreferredSize(new Dimension(200,80));
            bQuit.setFont(new Font("FreeMono",Font.PLAIN,35));
        //construction de Frame
        //pTitel.add(lTitel);
        pPLay.add(bPLay, BorderLayout.CENTER);
        pQuit.add(bQuit, BorderLayout.CENTER);

        pButton.add(pPLay, BorderLayout.CENTER);
        pButton.add(pQuit, BorderLayout.CENTER);

        pCentrageMenu.add(pTitel, BorderLayout.CENTER);
        pCentrageMenu.add(pButton, BorderLayout.CENTER);

        Box boxCentrage = Box.createVerticalBox();
        boxCentrage.add(Box.createVerticalStrut(250));
        boxCentrage.add(pCentrageMenu, BorderLayout.CENTER);


        bPLay.addActionListener(new EvenFMenu(this));
        bQuit.addActionListener(new EvenFMenu(this));

        fontPanel.add(boxCentrage, BorderLayout.CENTER);

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
