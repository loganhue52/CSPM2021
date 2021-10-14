import java.util.List;
import java.util.ArrayList;

public class ArrayAlgroithms {
    public static void main(String[] args){
        double[] test = {12,7,13,8,4.0,3,72};
        sum(test);
        avg(test);
        min(test);
        max(test);

        Player[] players = {new Player("Alex", 12, "Harrison"), new Player("Aiden", 13, "Castle"),
                    new Player("Bobbie", 18, "North"), new Player("Blaine", 20, "North"),
                    new Player("Chris", 15, "Reitz"), new Player("Charlie", 15, "Reitz") };

        // boolean hasValue =false;
        // int i = 0;
        // while(!hasValue){
        //     if(players[i].getAge()>=18){
        //         hasValue=true;
        //         System.out.println(players[i].getName());
        //     }
        //     i++;
        // }

        int i = 0;
        List<String> students = new ArrayList<>();

        while (i<players.length){
            if(players[i].getSchool().equals("Reitz")){
                students.add(players[i].getName());
            }
            i++;
        }
    }
    private static void sum(double[] list){
        double sum = 0;
        for (int i=0;i<list.length;i++){
            sum+=list[i];
        }
        System.out.println("Sum: "+sum);
    }
    private static void avg(double[] list){
        double avg = 0;
        for (int i=0;i<list.length;i++){
            avg+=list[i];
        }
        avg/=list.length;
        System.out.println("Avg: "+avg);
    }
    private static void min(double[] list){
        double min = Integer.MAX_VALUE;
        for (int i=0;i<list.length;i++){
            if (list[i]<min){
                min=list[i];
            }
        }
        System.out.println("Min: "+min);
    }
    private static void max(double[] list){
        double max = Integer.MIN_VALUE;
        for (int i=0;i<list.length;i++){
            if (list[i]>max){
                max=list[i];
            }
        }
        System.out.println("Max: "+max);
    }
}
