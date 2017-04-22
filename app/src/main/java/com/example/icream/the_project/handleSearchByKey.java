package com.example.icream.the_project;

/**
 * Created by i.cream on 22/4/2560.
 */

public class handleSearchByKey {
    public void handleSearchByKey(String oldVal, String newVal) {
        // If the number of characters in the text box is less than last time
        // it must be because the user pressed delete
        if (oldVal != null && (newVal.length() < oldVal.length())) {
            // Restore the lists original set of entries
            // and start from the beginning
            list.setItems(entries);
        }

        // Change to upper case so that case is not an issue
        newVal = newVal.toUpperCase();

        // Filter out the entries that don't contain the entered text
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