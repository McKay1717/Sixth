import vue.FenetreMenu;

import java.io.IOException;

public class GameAppli {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater( new Runnable() {

            public void run() {

                try {
                    FenetreMenu f = new FenetreMenu();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });
    }
}
