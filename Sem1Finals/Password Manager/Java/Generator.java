import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;

public class Generator{
    public static String generate(){
        int caps = 1;
        int lows = 5;
        int n = 1;
        int s = 1;
        String passRaw = "";
        int sadd = 0;

        for(int i=0;i<=caps;i++){
            passRaw += Character.toString(getRandInt(65, 95));
        }

        for(int i=0;i<=lows;i++){
            passRaw += Character.toString(getRandInt(97, 122));
        }

        for(int i=0;i<=n;i++){
            passRaw += Character.toString(getRandInt(48, 57));
        }

        while(s != 0){
            sadd = getRandInt(33,64);
            if ((sadd == 33) || (sadd == 35) || (sadd == 36) || (sadd == 37) || (sadd == 38) || (sadd == 40) || (sadd == 41) || (sadd == 42) || (sadd == 64)){
                passRaw += Character.toString(sadd);
                s -= 1;
            }
        }

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

    public static int getRandInt(int minimum, int maximum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }
}