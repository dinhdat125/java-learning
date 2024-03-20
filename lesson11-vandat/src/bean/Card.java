package bean;

public class Card {

	private Pips pip;
	private Suits suit;
	
	public Card() {
	}

	public Card(Pips pip, Suits suit) {
		this.pip = pip;
		this.suit = suit;
	}

	public Pips getPip() {
		return pip;
	}

	public void setPip(Pips pip) {
		this.pip = pip;
	}

	public Suits getSuit() {
		return suit;
	}

	public void setSuit(Suits suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		return pip + "_" + suit;
	}

}
