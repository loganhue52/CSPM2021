import java.util.ArrayList;
import java.util.List;

public class Checker{
    public static Boolean check(String password){
        List<String> checkList = new ArrayList<>();
        for(int i=0;i<5;i++){
            checkList.add("false");
        }

        for(int i=0;i<password.length();i++){
            int asciiVal = password.charAt(i);
            if ((asciiVal>=97) && (asciiVal<=122)){
                checkList.set(0,"true");
            }
            if ((asciiVal>=65) && (asciiVal<=90)){
                checkList.set(1,"true");
            }
            if ((asciiVal>=48) && (asciiVal<=57)){
                checkList.set(2,"true");
            }
            if ((asciiVal==33) || (asciiVal==64) || (asciiVal==35) || (asciiVal==36) || (asciiVal==37) || (asciiVal==94) || (asciiVal==38) || (asciiVal==40) || (asciiVal==41)){ 
                checkList.set(3,"true");
            }
            if (password.length()>=8){
                checkList.set(4,"true");
            } 
        }
        if(checkList.contains("false")){
            return false;
        } else{
            return true;
        }
    }
}