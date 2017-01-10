package vue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MenuJeu extends JMenuBar {
    private List<JMenu> jMenus;
    private List<List<JMenuItem>> jMenuItems;
    private JFrame fenetre;

    public MenuJeu(JFrame fenetre) {
        this.fenetre = fenetre;
        initMenu();
        creerMenu();
    }

    private void initMenu() {
        jMenus = new ArrayList<>();
        jMenuItems = new ArrayList<>();

        //Options
        jMenus.add(new JMenu("Options"));
        jMenuItems.add(new ArrayList<JMenuItem>());
        jMenuItems.get(jMenus.size() - 1).add(new JMenuItem("Accueil"));
        jMenuItems.get(jMenus.size() - 1).add(new JMenuItem("Quitter"));

        /*//Scores
        jMenus.add(new JMenu("Scores"));
        jMenuItems.add(new ArrayList<JMenuItem>());
        jMenuItems.get(jMenus.size() - 1).add(new JMenuItem("Meilleurs scores"));

        //Partie
        jMenus.add(new JMenu("Partie"));
        jMenuItems.add(new ArrayList<JMenuItem>());
        jMenuItems.get(jMenus.size() - 1).add(new JMenuItem("Charger une partie"));
        if (fenetre instanceof FenetreGrille)
            jMenuItems.get(jMenus.size() - 1).add(new JMenuItem("Sauvegarder la partie"));*/
    }

    private void creerMenu() {
        int i = 0;
        for (List<JMenuItem> ljMenuItem : jMenuItems) {
            for (Object jMenuItem : ljMenuItem)
                jMenus.get(i).add((JMenuItem) jMenuItem);
            i++;
        }

        for (JMenu jMenu : jMenus)
            add(jMenu);

        fenetre.setJMenuBar(this);
    }

    public void setEventMenuJeu(ActionListener actionListener) {
        for (List<JMenuItem> ljMenuItem : jMenuItems)
            for (JMenuItem jMenuItem : ljMenuItem)
                jMenuItem.addActionListener(actionListener);
    }
}