package model;

import exceptions.PionDeLaListeARetireDeLaPileNonDansLaPileException;
import exceptions.PionNonEnHautDeLaPileException;
import exceptions.TailleMaximaleDepasseeException;
import exceptions.TailleRetireeSuperieurATaillePileException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static model.Jeu.BLANC;
import static model.Jeu.ROUGE;
import static org.junit.Assert.assertEquals;

public class PieceUnitTest {
    List<Pion> pions;
    Piece piece;
    Joueur joueur;

    @Before
    public void setUp() {
        joueur = new Joueur(ROUGE, "Toto");
        pions = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            pions.add(new Pion(joueur.getCouleur(), joueur));
        piece = new Piece(pions, pions.size());
    }

    @Test
    public void testCouleurPiece() {
        assertEquals(ROUGE, piece.getCouleur());
    }

    @Test
    public void testTaillePiece() {
        assertEquals(pions.size(), piece.getTaille());
    }

    @Test(expected = TailleMaximaleDepasseeException.class)
    public void testAjoueDePionTailleMaximaleDepasseeException() throws TailleMaximaleDepasseeException {
        for (int i = 0; i < 3; i++)
            piece.add(new Pion(joueur.getCouleur(), joueur));
    }

    @Test(expected = TailleMaximaleDepasseeException.class)
    public void testAjoueDePionsTailleMaximaleDepasseeException() throws TailleMaximaleDepasseeException {
        List<Pion> pions2 = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            pions2.add(new Pion(joueur.getCouleur(), joueur));
        piece.add(pions2);
    }

    @Test
    public void testReductionTaillePieceETChangementCouleurPiece() throws PionNonEnHautDeLaPileException, TailleMaximaleDepasseeException {
        Pion blanc = new Pion(BLANC, new Joueur(BLANC, "Titi"));
        piece.add(blanc);
        piece.remove(blanc);
        assertEquals(pions.size(), piece.getTaille());
        assertEquals(ROUGE, piece.getCouleur());
    }

    @Test(expected = PionNonEnHautDeLaPileException.class)
    public void testReductionTaillePiecePionNonEnHautDeLaPileException() throws PionNonEnHautDeLaPileException, TailleMaximaleDepasseeException {
        piece.add(new Pion(joueur.getCouleur(), joueur));
        piece.remove(pions.get(0));
    }

    @Test
    public void testReductionTaillePieceAvecPlusieursPions() throws PionNonEnHautDeLaPileException, TailleRetireeSuperieurATaillePileException, PionDeLaListeARetireDeLaPileNonDansLaPileException, TailleMaximaleDepasseeException {
        List<Pion> removed = new ArrayList<Pion>();
        removed.add(new Pion(joueur.getCouleur(), joueur));
        piece.add(removed);
        piece.remove(removed);
        assertEquals(pions.size(), piece.getTaille());
        assertEquals(ROUGE, piece.getCouleur());
    }

    @Test(expected = TailleRetireeSuperieurATaillePileException.class)
    public void testReductionTaillePieceAvecPlusieursPionsTailleRetireeSuperieurATaillePileException() throws PionNonEnHautDeLaPileException, TailleRetireeSuperieurATaillePileException, PionDeLaListeARetireDeLaPileNonDansLaPileException, TailleMaximaleDepasseeException {
        pions.add(new Pion(joueur.getCouleur(), joueur));
        piece.remove(pions);
    }

    @Test(expected = PionDeLaListeARetireDeLaPileNonDansLaPileException.class)
    public void testReductionTaillePieceAvecPlusieursPionsPionDeLaListeARetireDeLaPileNonDansLaPileException() throws PionNonEnHautDeLaPileException, TailleRetireeSuperieurATaillePileException, PionDeLaListeARetireDeLaPileNonDansLaPileException, TailleMaximaleDepasseeException {
        List<Pion> removed = new ArrayList<Pion>();
        removed.add(new Pion(joueur.getCouleur(), joueur));
        piece.remove(removed);
    }
}