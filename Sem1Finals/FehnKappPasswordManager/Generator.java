import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;

public class Generator{
    public static String generate(){
        //initializing variables
        int caps = 1;
        int lows = 5;
        int n = 1;
        int s = 1;
        String passRaw = "";
        int sadd = 0;

        //generating a random capital letter ascii value and making it into a string
        for(int i=0;i<=caps;i++){
            passRaw += Character.toString(getRandInt(65, 95));
        }
        //generating lowercase values
        for(int i=0;i<=lows;i++){
            passRaw += Character.toString(getRandInt(97, 122));
        }
        //generating numbers
        for(int i=0;i<=n;i++){
            passRaw += Character.toString(getRandInt(48, 57));
        }
        //generating random special characters
        while(s != 0){
            sadd = getRandInt(33,64);
            if ((sadd == 33) || (sadd == 35) || (sadd == 36) || (sadd == 37) || (sadd == 38) || (sadd == 40) || (sadd == 41) || (sadd == 42) || (sadd == 64)){
                passRaw += Character.toString(sadd);
                s -= 1;
            }
        }

        //the next bit of code is for shuffling the generated password so it is harder to crack
        //basically it takes the raw string, turns it into a list, shuffles the list, turns it back into a string and spits it out

        // https://stackoverflow.com/questions/4247810/scramble-a-word-using-java

        ArrayList<Character> chars = new ArrayList<Character>(passRaw.length());

        for ( char c : passRaw.toCharArray() ) {
            chars.add(c);
        }

        Collections.shuffle(chars);

        char[] shuffled = new char[chars.size()];

        for ( int i = 0; i < shuffled.length; i++ ) {
            shuffled[i] = chars.get(i);
        }

        String password = new String(shuffled);

        return password;

    }
    //the next code is a function to generate random ints between a min and max, kinda like python

    //https://www.java67.com/2015/01/how-to-get-random-number-between-0-and-1-java.html
    private static int getRandInt(int minimum, int maximum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }
}