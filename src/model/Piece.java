package model;

import exception.PionDeLaListeARetireDeLaPileNonDansLaPileException;
import exception.PionNonEnHautDeLaPileException;
import exception.TailleMaximaleDepasseeException;
import exception.TailleRetireeSuperieurATaillePileException;

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

    public Piece(Pion pion) {
        this();

        try {
            add(pion);
        }
        catch (TailleMaximaleDepasseeException e) {
            e.printStackTrace();
        }
    }
    public void add(Pion pion) throws TailleMaximaleDepasseeException {
        if (taille + 1 > ROI)
            throw new TailleMaximaleDepasseeException();

        pions.add(pion);
        couleur = pion.getCouleur();
        taille++;
    }

    public int getCouleur() {
        return couleur;
    }

    public void add(List<Pion> pions) throws TailleMaximaleDepasseeException {
        if (pions.size() + taille > ROI)
            throw new TailleMaximaleDepasseeException();

        for (Pion pion : pions)
            add(pion);
    }

    public int getTaille() {
        return taille;
    }

    public void remove(Pion pion) throws PionNonEnHautDeLaPileException {
        if (pions.get(pions.size() - 1) != pion)
            throw new PionNonEnHautDeLaPileException();

        pions.remove(pion);
        couleur = pions.get(pions.size() - 1).getCouleur();
        taille--;
    }

    public void remove(List<Pion> pions) throws TailleRetireeSuperieurATaillePileException, PionDeLaListeARetireDeLaPileNonDansLaPileException, PionNonEnHautDeLaPileException {
        if (pions.size() > taille)
            throw new TailleRetireeSuperieurATaillePileException();

        for (int i = pions.size() - 1, j = taille - 1; i >= 0; i--, j--)
            if (pions.get(i) != this.pions.get(j))
                throw new PionDeLaListeARetireDeLaPileNonDansLaPileException();

        for (int i = pions.size() - 1; i >= 0; i--)
            remove(pions.get(i));
    }

    public char getLetter() {
        char letter = 'P';

        switch (taille) {
            case TOUR:
                letter = 'T';
                break;
            case CAVALIER:
                letter = 'C';
                break;
            case FOU:
                letter = 'F';
                break;
            case DAME:
                letter = 'D';
                break;
            case ROI:
                letter = 'R';
                break;
        }

        return letter;
    }
}