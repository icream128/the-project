package com.example.icream.the_project;

/**
 * Created by i.cream on 22/4/2560.
 */

public class handleSearchByKey {
    public void handleSearchByKey(String oldVal, String newVal) {

        if (oldVal != null && (newVal.length() < oldVal.length())) {

            list.setItems(entries);
        }

        newVal = newVal.toUpperCase();

        ObservableList<String> subentries = FXCollections.observableArrayList();
        for ( Object entry: list.getItems() ) {
            boolean match = true;
            String entryText = (String)entry;
            for ( String part: parts ) {
                // The entry needs to contain all portions of the
                // search string *but* in any order
                if ( ! entryText.toUpperCase().contains(part) ) {
                    match = false;
                    break;
                }
            }

            if ( match ) {
                subentries.add(entryText);
            }
        }
        list.setItems(subentries);
    }
}