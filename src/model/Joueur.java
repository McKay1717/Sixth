package model;

import java.io.Serializable;
import java.util.Stack;

public class Joueur implements Serializable {
    private static final int NB_PIONS = 15;
    private static long serialVersionUID = 1L;
    private int couleur;
    private Stack<Pion> pions;
    private int nb_coups;
    private String nom;

    public Joueur(int couleur, String nom) {
        this.couleur = couleur;
        this.nom = nom;
        nb_coups = 0;
        pions = new Stack<Pion>();
        for (int i = 0; i < NB_PIONS; i++) {
            pions.push(new Pion(couleur, this));
        }
    }

    public int getCouleur() {
        return couleur;
    }

    public Stack<Pion> getPions() {
        return pions;
    }

    public int getNb_coups() {
        return nb_coups;
    }

    public String getNom() {
        return nom;
    }

    public int getNbPionsRestants() {
        return pions.size();
    }

    public void joue() {
        nb_coups++;
    }
}