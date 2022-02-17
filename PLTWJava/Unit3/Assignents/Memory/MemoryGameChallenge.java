import java.util.Random;

/**
 * Project 3.6.5
 *
 * The Memory Game shows a random sequence of "memory strings" in a variety of buttons.
 * After wathcing the memory strings appear in the buttons one at a time, the
 * player recreates the sequence from memory.
 */
public class MemoryGameChallenge
{
  public static void main(String[] args) {

    // Create the "memory strings" - an array of single character strings to 
    // show in the buttons, one element at a time. This is the sequence
    // the player will have to remember.
    String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    String[] digits = {"1","2","3","4","5","6","7","8","9","0"};
    int score=0;
    int rounds=0;
    int misses=0;
    int length=5; //max: 26 - adjustable length for board and amount of digits/letters

    // Create the game and gameboard. Configure a randomized board with 3 buttons.
    // (Later, you can change options to configure more or less buttons
    // and turn randomization on or off.)
    MemoryGameGUI gui = new MemoryGameGUI();
    gui.createBoard(length, true);


    // Play the game until user wants to quit.
    int quit = 0;
    while(quit==0){
    
        // Create a new array that will contain the randomly ordered memory strings.
        
        // Create a list of randomly ordered integers with no repeats, the length
        // of memory strings. Use it to create a random sequence of the memory strings.
        // - OR -
        // Overload the next method in RandomPermutation to create a random sequence 
        // of the memory strings, passed as a parameter.
        int[] randomIntsLetters = RandomPermutation.next(alphabet.length-1);
        int[] randomIntsDigits = RandomPermutation.next(digits.length-1);

        Random rand = new Random();
    
        String seqStr = "";
         
        for (int i=0;i<length;i++){
            int digitChance=rand.nextInt(20);
            if(digitChance<=10){
                seqStr+=alphabet[randomIntsLetters[i]];
            }else{
                seqStr+=digits[randomIntsDigits[i]];
            }
        }
        String[] seqArray = seqStr.split("");

        // System.out.print("Rand: "+randomLettersStr);


        // Play one sequence, delaying half a second for the strings to show
        // in the buttons. Save the player's guess. 
        // (Later, you can speed up or slow down the game.)
        String seq = gui.playSequence(seqArray, 0.5);

      // Determine if player's guess matches all elements of the random sequence.
      
        // Cleanup the guess - remove commas and spaces. Refer to a new String method 
        // replace to make this easy.
        
        // iterate to determine if guess matches sequence

        // If match, increase score, and signal a match, otherwise, try again.
        // System.out.println("seq: "+seq);

        try{
            if(seq.equals(seqStr)){
                score+=1;
                rounds+=1;
                gui.matched();
                if(!(gui.playAgain())){
                    gui.showScore(score, rounds);
                    gui.quit();
                }
            }else{
                misses+=1;
                rounds+=1;
                if(misses==3){
                    gui.showScore(score, rounds);
                    gui.quit();
                }else{
                    gui.tryAgain();
                    if(!(gui.playAgain())){
                        gui.showScore(score, rounds);
                        gui.quit();
                    }
                }
            }
        }catch(Exception e){
            gui.showScore(score, rounds);
            gui.quit();
        }

      // Ask if user wants to play another round of the game 
      // and track the number of games played.
   
    // When done playing, show score and end the game.
    }
  }
}