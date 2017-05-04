package com.example.icream.the_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Permission StrictMode
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }

            // spinner1
            final Spinner spin1 = (Spinner)findViewById(R.id.input_spinner1);
           // final Spinner spin2 = (Spinner)findViewById(R.id.input_spinner2);
           // final Spinner spin3 = (Spinner)findViewById(R.id.input_spinner3);


            String url = "http://localhost:8080/the-project/show_spinner.php";

            try {

                JSONArray data1 = new JSONArray(getJSONUrl(url));

                final ArrayList<HashMap<String, String>> MyArrList1 = new ArrayList<HashMap<String, String>>();
                HashMap<String, String> map1;

                for(int i = 0; i < data1.length(); i++){
                    JSONObject c = data1.getJSONObject(i);

                    map1 = new HashMap<String, String>();
                    map1.put("subject_name", c.getString("subject_name"));
                    MyArrList1.add(map1);

                }


                SimpleAdapter sAdap1;
                sAdap1 = new SimpleAdapter(MainActivity.this, MyArrList1, new String[] {"subject_name"});
                spin1.setAdapter(sAdap1);

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }


        public String getJSONUrl(String url) {
            StringBuilder str = new StringBuilder();
            HttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            try {
                HttpResponse response = client.execute(httpGet);
                StatusLine statusLine = response.getStatusLine();
                int statusCode = statusLine.getStatusCode();
                if (statusCode == 200) { // Download OK
                    HttpEntity entity = response.getEntity();
                    InputStream content = entity.getContent();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        str.append(line);
                    }
                } else {
                    Log.e("Log", "Failed to download result..");
                }
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str.toString();
        }
}
