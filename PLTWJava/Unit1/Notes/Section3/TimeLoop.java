package PLTWJava.Unit1.Notes.Section3;

public class TimeLoop {
    public static void main(String[] args){
        //start time
        long tStart=System.currentTimeMillis();

        counter(10000000);

        //finish time
        long tFinish = System.currentTimeMillis();

        //maf / difference
        System.out.println((tFinish-tStart)+" ms");
        System.out.println((tFinish-tStart)/1000 + " s");
    }
    private static void counter(long x){
        System.out.println("Loop Started");
        for (long i=0;i<x;i++){
            System.out.println(i);
        }
        System.out.println("Loop end");
    }
}
