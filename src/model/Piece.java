package model;

import exceptions.PionDeLaListeARetireDeLaPileNonDansLaPileException;
import exceptions.PionNonEnHautDeLaPileException;
import exceptions.TailleMaximaleDepasseeException;
import exceptions.TailleRetireeSuperieurATaillePileException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Piece implements Serializable {
    public static final int PION = 1;
    public static final int TOUR = 2;
    public static final int CAVALIER = 3;
    public static final int FOU = 4;
    public static final int DAME = 5;
    public static final int ROI = 6;
    private static final long serialVersionUID = 1L;
    private java.util.List<Pion> pions;
    private int taille;

    public Piece(Pion pion) throws TailleMaximaleDepasseeException {
        pions = new ArrayList<Pion>();
        add(pion);
        taille = pions.size();
    }

    public Piece(List<Pion> pions) {
        this.pions = pions;
        this.taille = pions.size();
    }

    public int getCouleur() {
        return pions.get(taille - 1).getCouleur();
    }

    public int getTaille() {
        return pions.size();
    }

    public Pion getPion(int i) { return pions.get(i); }

    public List<Pion> getPions() {
        return pions;
    }

    public List<Pion> getPions(int debut, int fin) {
        List<Pion> pions = new ArrayList<Pion>();

        for(int i = debut - 1; i < fin; i++) {
            pions.add(this.pions.get(i));
        }

        return pions;
    }

    public void add(Pion pion) throws TailleMaximaleDepasseeException {
        if (taille + 1 > ROI)
            throw new TailleMaximaleDepasseeException();

        pions.add(pion);
        taille++;
    }

    public void add(List<Pion> pions) throws TailleMaximaleDepasseeException {
        if (pions.size() + taille > ROI)
            throw new TailleMaximaleDepasseeException();

        for (Pion pion : pions)
            add(pion);
    }

    public void remove(Pion pion) throws PionNonEnHautDeLaPileException {
        if (pions.get(pions.size() - 1) != pion)
            throw new PionNonEnHautDeLaPileException();

        pions.remove(pion);
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

    public String toString() {
        switch (getTaille()) {
            case PION:
                return "P";
            case TOUR:
                return "T";
            case CAVALIER:
                return "C";
            case FOU:
                return "F";
            case DAME:
                return "D";
            case ROI:
                return "R";
            default:
                return "";
        }
    }
}