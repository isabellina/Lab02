package it.polito.tdp.alien;

import java.util.*;
import java.util.regex.Pattern;

public class AlienDictionary {

	private List<Word> listaParole = new LinkedList<Word>();
	
	public void addWord(String a, String t){
		 Word mot = new Word(a, t);
		
		 for(Word w: listaParole) {    
			 if(w.equals(mot)) {
				 listaParole.remove(w);
			 }
		 }
		 
			 listaParole.add(mot);
			
		 
		
		
	 }
	
	
	public String translateWord(String a, boolean wildcard) {
		if(wildcard==false) {
			String translation = "";
			 Word mot = new Word(a, "");
			 for(Word w: listaParole) {
				if(w.equals(mot)) {
					translation = w.getTranslation();
				} 
			 }
			 return translation;
		}
		else {
			String regex = a.replaceAll("\\?", ".");
			String translation = "";
			for(Word w : listaParole) {
				System.out.println("parola con wc: "+regex);
				if(Pattern.matches(regex, w.getAlienWord())) {
					translation+=w.getTranslation()+"\n";
				}
			}
			return translation;
		}
		 
	}
	
	
	public void reset() {
		this.listaParole = new LinkedList<Word>();
	}
}
