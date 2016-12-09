package vue;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Menu extends JMenuBar {
    private List<JMenu> jMenus;
    private List<List<JMenuItem>> jMenuItems;
    private JFrame fenetre;

    public Menu(JFrame fenetre) {
        this.fenetre = fenetre;
        initMenu();
    }

    private void initMenu() {
        jMenus = new ArrayList<>();
        jMenuItems = new ArrayList<>();

        //Options
        jMenus.add(new JMenu("Options"));
        jMenuItems.add(new ArrayList<>());
        jMenuItems.get(jMenus.size() - 1).add(new JMenuItem("Accueil"));
        jMenuItems.get(jMenus.size() - 1).add(new JMenuItem("Quitter"));

        //Scores
        jMenus.add(new JMenu("Scores"));
        jMenuItems.add(new ArrayList<>());
        jMenuItems.get(jMenus.size() - 1).add(new JMenuItem("Meilleurs scores"));
    }

    private void creerMenu() {
        int i = 0;
        for (List<JMenuItem> ljMenuItem : jMenuItems) {
            for (JMenuItem jMenuItem : ljMenuItem)
                jMenus.get(i).add(jMenuItem);
            i++;
        }
    }
}