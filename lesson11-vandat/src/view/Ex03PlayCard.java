package view;

import static utils.Utils.generate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import bean.Card;
import bean.Pips;
import bean.Suits;

public class Ex03PlayCard {

	public static void main(String[] args) {
		var cards = mockCards();
		
		Collections.shuffle(cards);
		distributeCards(cards);
		generate("Standard 52-card deck", cards);
	}
	
	private static void distributeCards(List<Card> cards) {
		var	players = new LinkedHashMap<String, List<Card>>();
		
		players.put("Player01", new ArrayList<Card>());
		players.put("Player02", new ArrayList<Card>());
		players.put("Player03", new ArrayList<Card>());
		players.put("Player04", new ArrayList<Card>());
		
		int index = 0;
		for (var player: players.entrySet()) {
			int count = index;
			while (player.getValue().size() <= 12) {
				player.getValue().add(cards.get(count));
				count += 4;
			}
			index++;
		}
		
		generate("Each player's cards:", players);
	}
	
	private static List<Card> mockCards() {
		var cards = new ArrayList<Card>();
		for (Suits suit: Suits.values())
			for (Pips pip: Pips.values())
				cards.add(new Card(pip, suit));
		return cards;
	}
}
