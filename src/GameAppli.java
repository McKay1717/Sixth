import controleur.ControlleurGeneral;

import java.io.IOException;

import static javax.swing.SwingUtilities.invokeLater;

public class GameAppli {
    public static void main(String[] args) {
        invokeLater(new Runnable() {
            public void run() {
                try {
                    new ControlleurGeneral();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}