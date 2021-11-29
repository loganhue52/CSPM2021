import java.util.ArrayList;
import java.util.List;

public class Checker{
    //returns true or false the the main file
    public static Boolean check(String password){
        //making a check list of booleans
        List<String> checkList = new ArrayList<>();
        //add 5 false values
        for(int i=0;i<5;i++){
            checkList.add("false");
        }
        //for the length of the password
        for(int i=0;i<password.length();i++){
            //using charAt to convert letter to ascii values
            int asciiVal = password.charAt(i);
            //if it is within the correct ascii values, the checklist value is changed to true
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
        //if there are any false left in the list, the password did not meet the requirements
        if(checkList.contains("false")){
            return false;
        } else{
            return true;
        }
    }
}