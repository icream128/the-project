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
        for (Object entry : list.getItems()) {
            String entryText = (String) entry;
            if (entryText.toUpperCase().contains(newVal)) {
                subentries.add(entryText);
            }
        }
        list.setItems(subentries);
    }
}