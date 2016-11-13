package sixth;

/**
 * Created by ctx on 09/11/16.
 */

public class Piece {
    public  static int PION = 1;
    public static int TOUR = 2;
    public static int CAVALIER = 3;
    public static int FOU = 4;
    public static int DAME = 5;
    public static int ROI = 6;

    private int pion;

    public Piece(int pion) {
        this.pion = pion;
    }

    public int getPion() {
        return pion;
    }
}
