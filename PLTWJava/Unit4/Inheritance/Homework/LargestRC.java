import java.util.Scanner;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class LargestRC {
    public static void main(String[] args){
        Scanner ui = new Scanner(System.in);
        System.out.print("\nEnter n: ");
        int n = ui.nextInt();
        List<Integer> numList = fillList(n);
        // System.out.println(numList);
        printList(numList,n);
        ui.close();
    }

    public static List<Integer> fillList(int n){
        List<Integer> filledList = new ArrayList<>();
        Random rand = new Random();
        for (int i=0;i<(n*n);i++){
            int randInt = rand.nextInt(2);
            filledList.add(randInt);
        }
        return filledList;
    }

    public static void printList(List<Integer> listy,int n){
        String stringArray = "";
        //vars for comparing the current row to the biggest row so far
        int biggestRowTotal=0;
        int thisRowTotal=0;
        int biggestRowIndex=0;
        int thisRow=0;
        List<Integer> duplicateRows = new ArrayList<>();
        //the array of numbers
        for (int i=1;i<n*n+1;i++){
            stringArray+=listy.get(i-1);
            thisRowTotal+=listy.get(i-1);
            if((i%n)==0){
                stringArray+="\n";
                if (i==n){
                    biggestRowTotal=thisRowTotal;
                }else{
                    if (thisRowTotal>biggestRowTotal){
                        biggestRowTotal=thisRowTotal;
                        biggestRowIndex=thisRow;
                        duplicateRows.clear();
                    }else if (thisRowTotal==biggestRowTotal){
                        duplicateRows.add(biggestRowIndex);
                        duplicateRows.add(thisRow);
                    }
                }
                thisRow+=1;
                thisRowTotal=0;
            }
        }

        System.out.println(stringArray);

        //checking to see if there are multiple rows of the same value or not
        if (duplicateRows.isEmpty()){
            System.out.println("Largest row index: "+biggestRowIndex);
        } else{
            String rows="";
            for (int i: duplicateRows){
                rows+=i+", ";
            }
            System.out.println("Largest row indices: "+rows);
        }

    }
}
