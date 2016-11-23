package model;

import java.util.ArrayList;
import java.util.List;

import static model.Pion.SANS_COULEUR;

public class Piece {
    //Valeurs
    public static final int PION = 1;
    public static final int TOUR = 2;
    public static final int CAVALIER = 3;
    public static final int FOU = 4;
    public static final int DAME = 5;
    public static final int ROI = 6;

    private List<Pion> pions;
    private int couleur;
    private int taille;

    public Piece() {
        pions = new ArrayList<Pion>();
        couleur = SANS_COULEUR;
        taille = 0;
    }

    public void add(Pion pion) {
        pions.add(pion);
        couleur = pion.getCouleur();
        taille++;
    }

    public int getCouleur() {
        return couleur;
    }

    public void add(List<Pion> pions) {
        for (Pion pion : pions)
            add(pion);
    }

    public int getTaille() {
        return taille;
    }
}