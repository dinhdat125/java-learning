package view;

import java.util.HashSet;
import java.util.Set;

import bean.Word;

public class Ex04Dictionary {

	public static void main(String[] args) {
		var dictionary = new HashSet<Word>();
		
		addWord(dictionary, new Word("car", "ô tô", "noun", "abcd"));
		addWord(dictionary, new Word("drive", "lái xe", "verb", "abcd"));
		addWord(dictionary, new Word("hot", "nóng", "adjective", "abcd"));
		addWord(dictionary, new Word("well", "tốt", "adverb", "abcd"));
		
		System.out.println("car -> " + lookup(dictionary, "car"));
		System.out.println("best -> " + lookup(dictionary, "best"));
	}
	
	private static void addWord(Set<Word> dictionary, Word word) {
		dictionary.add(word);
	}
	
	private static Word lookup(Set<Word> dictionary, String wordLookedUp) {
		if (!(dictionary.contains(new Word(wordLookedUp, null, null, null))))
			return null;
		for (var word: dictionary) {
			if (wordLookedUp.equals(word.getWord())) {
				return word;
			}
		}
		return null;
	}
}
