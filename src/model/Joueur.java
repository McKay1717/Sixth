package model;

public class Joueur {

	private String nom = "";
	private int color = Pion.SANS_COULEUR; // -1 Rouge -2 Blanc
	private int score;
	public static final int MAX_PION = 15;

	public Joueur(String nom, int color) {
		super();
		this.nom = nom;
		this.color = color;
	}

	public void joue() {
		score += 1;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Joueur)) {
			return false;
		}
		Joueur other = (Joueur) obj;
		if (color != other.color) {
			return false;
		}
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}
		if (score != other.score) {
			return false;
		}
		return true;
	}

}
