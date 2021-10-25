package Unit3.Notes;

import java.util.ArrayList;
public class ArrayListMethods {
     public static void main(String[] args) {
          ArrayList<Integer> arrList = new ArrayList<Integer>();
          int[] ia = {1,2,0,3,2,4,2,1,0,2,0,1,3,2};
          arrList=createArrayList(ia);
          System.out.println(minIntAL(arrList));
          System.out.println(maxIntAL(arrList));
          System.out.println(aveIntAL(arrList));
     }
     public static ArrayList<Integer> createArrayList(int[] iarr){
          ArrayList<Integer> temp = new ArrayList<Integer>();
          for(int i=0;i<iarr.length;i++){
               temp.add(iarr[i]);
          }
          return temp;
     }
     //Determine the minimum value in the array list
     public static int minIntAL(ArrayList<Integer> temp){
          int min=Integer.MAX_VALUE;
          for(int i=0;i<temp.size();i++){
               if(temp.get(i)<min){
                    min=temp.get(i);
               }
          }
          return min;
     }
     //Determine the maximum value in the array list
     public static int maxIntAL(ArrayList<Integer> temp){
          int max=Integer.MIN_VALUE;
          for(int i=0;i<temp.size();i++){
            if(temp.get(i)>max){
                 max=temp.get(i);
            }
          }
          return max;
     }
     //Determine the average of all elements in the array
     public static int aveIntAL(ArrayList<Integer> temp){
          int ave=0;
          for(int i=0;i<temp.size();i++){
            ave += temp.get(i);
          }
          ave = ave/temp.size();
          return ave;
     }
     public static int count(ArrayList<Integer> temp, int valueToCheck){
          int count=0;
          for (int dog: temp){
               if (dog==valueToCheck){
                    count++;
               }
          }
          if (count>0){
               return count;
          } else{
               return -1;
          }
     }
     
}
