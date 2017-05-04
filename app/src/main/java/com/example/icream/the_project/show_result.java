package com.example.icream.the_project;

import android.os.Bundle;

/**
 * Created by i.cream on 5/5/2560.
 */

public class show_result {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        int[] resId = { R.drawable.aerithgainsborough
                , R.drawable.barretwallace, R.drawable.caitsith
                , R.drawable.cidhighwind, R.drawable.cloudstrife
                , R.drawable.redxiii, R.drawable.sephiroth
                , R.drawable.tifalockhart, R.drawable.vincentvalentine
                , R.drawable.yuffiekisaragi, R.drawable.zackfair };

        String[] list = { "Aerith Gainsborough", "Barret Wallace", "Cait Sith"
                , "Cid Highwind", "Cloud Strife", "RedXIII", "Sephiroth"
                , "Tifa Lockhart", "Vincent Valentine", "Yuffie Kisaragi"
                , "ZackFair" };

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), list, resId);

        ListView listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

            }
        });
    }
}
