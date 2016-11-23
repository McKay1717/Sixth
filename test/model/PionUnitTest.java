package model;

import org.junit.Test;

import static model.Pion.BLANC;
import static model.Pion.ROUGE;
import static org.junit.Assert.assertEquals;

public class PionUnitTest {
    @Test
    public void testCouleurPion() {
        Pion pion1 = new Pion(ROUGE);
        Pion pion2 = new Pion(BLANC);

        assertEquals(ROUGE, pion1.getCouleur());
        assertEquals(BLANC, pion2.getCouleur());
    }
}