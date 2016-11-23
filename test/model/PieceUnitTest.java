package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static model.Pion.BLANC;
import static model.Pion.ROUGE;
import static org.junit.Assert.assertEquals;

public class PieceUnitTest {
    @Test
    public void testCouleurPiece() {
        Piece piece = new Piece();
        piece.add(new Pion(ROUGE));
        assertEquals(ROUGE, piece.getCouleur());

        List<Pion> pions = new ArrayList<Pion>();
        pions.add(new Pion(ROUGE));
        pions.add(new Pion(BLANC));
        Piece piece2 = new Piece();
        piece2.add(pions);
        assertEquals(BLANC, piece2.getCouleur());
    }

    @Test
    public void testTaillePiece() {
        List<Pion> pions = new ArrayList<Pion>();
        pions.add(new Pion(ROUGE));
        pions.add(new Pion(BLANC));

        Piece piece = new Piece();
        piece.add(pions);
        assertEquals(2, piece.getTaille());
    }

    @Test
    public void testReductionTaillePieceETChangementCouleurPiece() throws PionNonEnHautDeLaPileException {
        Pion rouge = new Pion(ROUGE);
        Pion blanc = new Pion(BLANC);
        List<Pion> pions = new ArrayList<Pion>();
        pions.add(rouge);
        pions.add(blanc);

        Piece piece = new Piece();
        piece.add(pions);
        piece.remove(blanc);
        assertEquals(1, piece.getTaille());
        assertEquals(ROUGE, piece.getCouleur());
    }

    @Test(expected = PionNonEnHautDeLaPileException.class)
    public void testReductionTaillePiecePionNonEnHautDeLaPileException() throws PionNonEnHautDeLaPileException {
        Pion rouge = new Pion(ROUGE);
        Pion blanc = new Pion(BLANC);
        List<Pion> pions = new ArrayList<Pion>();
        pions.add(rouge);
        pions.add(blanc);

        Piece piece = new Piece();
        piece.add(pions);
        piece.remove(rouge);
    }

    @Test
    public void testReductionTaillePieceAvecPlusieursPions() throws PionNonEnHautDeLaPileException, TailleRetireeSuperieurATaillePileException, PionDeLaListeARetireDeLaPileNonDansLaPileException {
        Pion pion = new Pion(ROUGE);
        Pion pion1 = new Pion(BLANC);
        Pion pion2 = new Pion(ROUGE);

        List<Pion> add = new ArrayList<Pion>();
        add.add(pion);
        add.add(pion1);
        add.add(pion2);

        List<Pion> removed = new ArrayList<Pion>();
        removed.add(pion1);
        removed.add(pion2);

        Piece piece = new Piece();
        piece.add(add);
        piece.remove(removed);
        assertEquals(1, piece.getTaille());
        assertEquals(ROUGE, piece.getCouleur());
    }

    @Test(expected = TailleRetireeSuperieurATaillePileException.class)
    public void testReductionTaillePieceAvecPlusieursPionsTailleRetireeSuperieurATaillePileException() throws PionNonEnHautDeLaPileException, TailleRetireeSuperieurATaillePileException, PionDeLaListeARetireDeLaPileNonDansLaPileException {
        List<Pion> add = new ArrayList<Pion>();
        for (int i = 0; i < 4; i++)
            add.add(new Pion(ROUGE));

        List<Pion> removed = new ArrayList<Pion>();
        for (int i = 0; i < 5; i++)
            removed.add(new Pion(ROUGE));

        Piece piece = new Piece();
        piece.add(add);
        piece.remove(removed);
    }

    @Test(expected = PionDeLaListeARetireDeLaPileNonDansLaPileException.class)
    public void testReductionTaillePieceAvecPlusieursPionsPionDeLaListeARetireDeLaPileNonDansLaPileException() throws PionNonEnHautDeLaPileException, TailleRetireeSuperieurATaillePileException, PionDeLaListeARetireDeLaPileNonDansLaPileException {
        Pion pion = new Pion(ROUGE);
        Pion pion1 = new Pion(BLANC);
        Pion pion2 = new Pion(ROUGE);

        List<Pion> add = new ArrayList<Pion>();
        add.add(pion);
        add.add(pion1);
        add.add(pion2);

        List<Pion> removed = new ArrayList<Pion>();
        removed.add(pion1);
        removed.add(new Pion(ROUGE));

        Piece piece = new Piece();
        piece.add(add);
        piece.remove(removed);
    }
}