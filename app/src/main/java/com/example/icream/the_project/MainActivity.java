package com.example.icream.the_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner subSpinner;
    private Spinner input2;
    private Spinner input3;

    private ArrayList<String> subject = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subSpinner = (Spinner)findViewById(R.id.input1);

        createSubjectSpinner();

    }
    private void createSubjectSpinner(){
        subject.add("Math");
        subject.add("Thai");
        subject.add("English");
        subject.add("Art");
        subject.add("Science");
        subject.add("Computer");
    }
}
