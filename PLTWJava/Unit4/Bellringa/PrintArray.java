import java.util.ArrayList;

public class PrintArray {
    public static void main(String[] args){
        ArrayList<Integer> array = new ArrayList<>();
        array.add(98);array.add(54);array.add(2);array.add(12);array.add(7);array.add(56);array.add(34);array.add(88);array.add(76);array.add(45);
        array.sort(null);
        System.out.println(array);
    }
}
