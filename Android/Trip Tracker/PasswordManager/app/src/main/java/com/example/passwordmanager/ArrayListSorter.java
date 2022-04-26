package com.example.passwordmanager;

import java.util.List;

public class ArrayListSorter {

    public static final String ASCENDING_ORDER = "ASC";
    public static final String DESCENDING_ORDER = "DSC";

    public static void insertionSort(List<Trip> list, String sortOrder){
//        Log.d("Sorting", String.valueOf(list));
        //loop through the list
        for(int j=1;j<list.size();j++){
            Trip temp = list.get(j);
            int possibleIndex = j;
            //if sorting order is dsc
            if(sortOrder.equals(DESCENDING_ORDER)){
                while(possibleIndex>0 && temp.compareTo(list.get(possibleIndex-1)) >0){
                    //add out trip into the newList
                    list.set(possibleIndex,list.get(possibleIndex-1));
                    possibleIndex--;
                }
            //else sort ordering is asc
            }else if (sortOrder.equals(ASCENDING_ORDER)){
                while(possibleIndex>0 && temp.compareTo(list.get(possibleIndex-1)) <0){
                    //add out trip into the newList
                    list.set(possibleIndex,list.get(possibleIndex-1));
                    possibleIndex--;
                }
            }
            list.set(possibleIndex,temp);
        }



    }
}
