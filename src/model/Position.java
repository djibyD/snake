package model;

public class Position {
	
	private int abcisse;
	private int ordonnee;
	
	public Position(int abcisse, int ordonnee) {
		super();
		this.abcisse = abcisse;
		this.ordonnee = ordonnee;
	}

	public Position() {
		super();
	}

	public int getAbcisse() {
		return abcisse;
	}

	public void setAbcisse(int abcisse) {
		this.abcisse = abcisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}
	
	
	

}
