/**
 * 
 */
package model;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author nicolas
 *
 */
public class JoueurUnitTest {

	/**
	 * Test method for {@link model.Joueur#setNom(java.lang.String)}.
	 */
	@Test
	public void testSetNom() {
		Joueur joueur = new Joueur("toto", Pion.BLANC);
		joueur.setNom("toto2");
		Assert.assertTrue(joueur.getNom() == "toto2");
	}

	/**
	 * Test method for {@link model.Joueur#setColor(int)}.
	 */
	@Test
	public void testSetColor() {
		Joueur joueur = new Joueur("toto", Pion.BLANC);
		joueur.setColor(Pion.ROUGE);
		Assert.assertTrue(joueur.getColor() == Pion.ROUGE);
	}

	/**
	 * Test method for {@link model.Joueur#setScore(int)}.
	 */
	@Test
	public void testSetScore() {
		Joueur joueur = new Joueur("toto", Pion.BLANC);
		joueur.setScore(50);
		Assert.assertTrue(joueur.getScore() == 50);
	}

	/**
	 * Test method for {@link model.Joueur#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Joueur joueur = new Joueur("toto", Pion.BLANC);
		Joueur joueur2 = new Joueur("toto", Pion.BLANC);
		Assert.assertTrue(joueur.equals(joueur2));
	}

	@Test
	public void testJoue() {
		Joueur joueur = new Joueur("toto", Pion.BLANC);
		joueur.joue();
		Assert.assertEquals(1, joueur.getScore());
	}

}
