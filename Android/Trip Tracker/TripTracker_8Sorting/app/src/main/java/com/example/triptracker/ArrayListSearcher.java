package com.example.triptracker;

import java.util.List;
import java.util.Locale;

public class ArrayListSearcher {

    public static List<Trip> filteredList;

    public static List<Trip> search(List<Trip> list, String searchTerm){
        for(int j=1;j<list.size();j++) {
            Trip temp = list.get(j);
//            int possibleIndex = j;
            if (temp.getName().toLowerCase().contains(searchTerm.toLowerCase())){
                filteredList.add(temp);
            }
        }
        return filteredList;
    }
}
