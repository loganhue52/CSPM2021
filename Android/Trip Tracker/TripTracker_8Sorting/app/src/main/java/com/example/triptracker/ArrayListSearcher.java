package com.example.triptracker;

import java.util.List;

public class ArrayListSearcher {

    public static void search(List<Trip> list, String searchTerm){
        for(int j=1;j<list.size();j++) {
            Trip temp = list.get(j);
            int possibleIndex = j;
            if (!(temp.getName().contains(searchTerm))){
                list.remove(possibleIndex);
            }
        }
    }
}
