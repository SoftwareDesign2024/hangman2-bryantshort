// Bryant Short

package game;

import util.DisplayWord;
import util.HangmanDictionary;

public abstract class Executioner {
	// word that is being guessed
	protected String mySecretWord;
	// what is shown to the user
	protected DisplayWord myDisplayWord;
    
    
    // constructor to initialize mySecretWord and myDisplayWord
    public Executioner(HangmanDictionary dictionary, int wordLength) {
        mySecretWord = makeSecretWord(dictionary, wordLength);
        myDisplayWord = new DisplayWord(mySecretWord);
    }
    
	// Returns a secret word.
	private String makeSecretWord (HangmanDictionary dictionary, int wordLength) {
		return dictionary.getRandomWord(wordLength).toLowerCase();
	}

	boolean checkGuessInSecret (char guess) {
		if (mySecretWord.indexOf(guess) >= 0) {
			myDisplayWord.update(guess, mySecretWord);
			return true;
		}
		return false;

	}
	
	// Returns true only if the guesser has guessed all letters in the secret word.
	public boolean isGameWon() {
	    return myDisplayWord.equals(mySecretWord);
	}
    
    public String getDisplayWord() { // getter f
        return myDisplayWord.toString();
    }
    
    public String getSecretWord() {
        return mySecretWord;
    }

}
