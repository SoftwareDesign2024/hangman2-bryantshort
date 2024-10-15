// Bryant Short

package game;

public abstract class Guesser {
	
	// how many guesses are remaining
    protected int myNumGuessesLeft;
    // tracks letters guessed
    protected StringBuilder myLettersLeftToGuess;
    
    
    // constructor to initialize myNumGuessesLeft and myLettersLeftToGuess
    public Guesser(int numGuesses, String alphabet) {
        myNumGuessesLeft = numGuesses;
        myLettersLeftToGuess = new StringBuilder(alphabet);
    }
	
    
 // Returns true only if the guesser has used up all their chances to guess.
    public boolean isGameLost () {
        return myNumGuessesLeft == 0;
    }
    
 // Record that a specific letter was guessed
    private void recordGuess (int index) {
        myLettersLeftToGuess.deleteCharAt(index);
    }
    
    public int getNumGuessesLeft() { // getter for remaining variables
        return myNumGuessesLeft;
    }
    
    public String getLettersLeftToGuess() { // getter  for letters that havent been guessed
        return myLettersLeftToGuess.toString();
    }
    
 // Process a guess by updating the necessary internal state.
    public void makeGuess (char guess, Executioner executioner) {
        // do not count repeated guess as a miss
        int index = myLettersLeftToGuess.indexOf("" + guess);
        if (index >= 0) {
            recordGuess(index);
            if (! executioner.checkGuessInSecret(guess)) {
                myNumGuessesLeft -= 1;
            }
        }
    }

}
