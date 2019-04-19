package it.polito.tdp.alien;

public class Word {

	private String alienWord;
	private String translation;
	
	public boolean equals(Word word) {
		return this.getAlienWord().equals(word.getAlienWord());
	}

	public String getAlienWord() {
		return alienWord;
	}

	public String getTranslation() {
		return translation;
	}

	public Word(String alienWord, String translation) {
		
		this.alienWord = alienWord;
		this.translation = translation;
	}
	
	
	
}
