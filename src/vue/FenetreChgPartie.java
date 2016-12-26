package vue;

import model.Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import static javax.swing.BoxLayout.LINE_AXIS;
import static javax.swing.BoxLayout.Y_AXIS;
import static model.Jeu.loadPartie;

public class FenetreChgPartie extends JFrame {
    private FontPanel fontPanel;
    private JPanel panelChgPartie;
    private int width;
    private int height;
    private List<Jeu> jeux;
    private JButton[] jButtons;

    public FenetreChgPartie() throws IOException, ClassNotFoundException {
        width = 1000;
        height = 700;
        fontPanel = new FontPanel(new ImageIcon("dataImage/textureGazon.jpg").getImage(), width, height);
        addComponentListener(fontPanel);
        creerWidget();

        setMaximizedBounds(new Rectangle(20, 20, 1100, 750));
        setSize(width, height);
        setLocationRelativeTo(null);
        setTitle("Sixth");
        setMinimumSize(new Dimension(750, 700));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public int getNbParties() {
        return jeux.size();
    }

    public Jeu getJeu(int i) {
        return jeux.get(i);
    }

    private void creerWidget() throws IOException, ClassNotFoundException {
        panelChgPartie = new JPanel(new BorderLayout());
        panelChgPartie.setLayout(new BoxLayout(panelChgPartie, Y_AXIS));
        panelChgPartie.setOpaque(false);

        jeux = loadPartie();
        JPanel[] jPanelsParties = new JPanel[jeux.size()];
        jButtons = new JButton[jeux.size() * 2];
        for (int i = 0, j = 0; i < jPanelsParties.length; i++, j++) {
            jPanelsParties[i] = new JPanel(new BorderLayout());
            jPanelsParties[i].setLayout(new BoxLayout(jPanelsParties[i], LINE_AXIS));
            jPanelsParties[i].setOpaque(false);

            jPanelsParties[i].add(new JLabel(jeux.get(i).getDate()));
            jButtons[j] = new JButton("Charger la partie n°" + Integer.toString(i + 1));
            jPanelsParties[i].add(jButtons[j]);
            j++;
            jButtons[j] = new JButton("Supprimer la partie n°" + Integer.toString(i + 1));
            jPanelsParties[i].add(jButtons[j]);
        }

        for (JPanel jPanelsParty : jPanelsParties)
            panelChgPartie.add(jPanelsParty);

        setContentPane(panelChgPartie);
    }

    public void setEventFenetreChgPartie(ActionListener actionListener) {
        for (JButton jButton : jButtons)
            jButton.addActionListener(actionListener);
    }

    public List<Jeu> getJeux() {
        return jeux;
    }
}