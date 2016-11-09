import java.security.PrivateKey;

/**
 * Created by ctx on 09/11/16.
 */
public class Pion {
    private static int tour = 1;
    private static int cavalier = 2;
    private static int fou = 3;
    private static int dame = 4;
    private static int roi = 5;

    private int pion;

    public int getPion() {
        return pion;
    }

    public Pion(int pion) {
        this.pion = pion;
    }
}
