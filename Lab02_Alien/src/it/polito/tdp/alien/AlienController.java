package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;

import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private AlienDictionary dizionario = new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    
    @FXML
    void doTranslate(ActionEvent event) {
    	    	String parola = txtWord.getText();
    	    	txtWord.clear();
    	    parola =	parola.toLowerCase();
    	    System.out.println(parola.replaceAll("\\s", ""));
    	   if(Pattern.matches("[a-z?]+", parola.replaceAll("\\s", ""))==true) {
    		   int l1 = parola.length();
    		   int l2 = parola.replaceAll("\\?", "").length();
    		   int diff = l1-l2;
    		   if(diff>1) {
    			   txtResult.appendText("La parola inserita non va bene\n");
    		   }
    		   else if(diff==0) {
    			   String   a[] =	parola.split("\\s");
    		    	 if(a.length>1) {
    		    		    dizionario.addWord(a[0], a[1]);
    		    	 }
    		    	 else {
    		    		String translated = dizionario.translateWord(a[0], false);
    		    	 if(translated.compareTo("")==0) {
    		    		// txtResult.appendText("Non c'è!!");
    		    		 txtResult.appendText("null");
    		    	 }
    		    	 else
    		    		 txtResult.appendText("La traduzione e': "+translated+"\n");
    		    	 }
    		   }
    		   else if(diff==1) {
    			   String translated = dizionario.translateWord(parola, true);
    			   if(translated.compareTo("")==0) {
    				   txtResult.appendText("null ma con wildcard");
    			   }
    			   else {
    				   txtResult.appendText("Le traduzioni sono: " + translated+"\n");
    			   }
    			   
    		   }
    	
    	 
    	   }
    	   else
    		   txtResult.appendText("La parola inserita non va bene\n");
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtWord.clear();
    	this.dizionario.reset();
        txtResult.clear();
        
    }
    
}
