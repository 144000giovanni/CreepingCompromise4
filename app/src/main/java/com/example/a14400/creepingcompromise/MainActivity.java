package com.example.a14400.creepingcompromise;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    TextView text_view;
    Spinner dropdownChapter;
    String fileName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dropdownChapter = (Spinner) findViewById(R.id.spinner_chapter);

        //create a chapter list
        List<String> chapterList = new ArrayList<>();
        //File directory = new File( Environment.getRootDirectory().getAbsolutePath());
        //File[] files = directory.listFiles();
        //for(File file : files) {
        //    chapterList.add(file.getPath());
            //text_view.append(files[i].getName() + "\n");
        //}
        chapterList.add("PRESS HERE TO SELECT CHAPTER");
        chapterList.add("introduction".toUpperCase());
        chapterList.add("our enemy the world".toUpperCase());
        chapterList.add("is nudity modest".toUpperCase());
        chapterList.add("double standard exposed".toUpperCase());
        chapterList.add("unisex".toUpperCase());
        chapterList.add("colorful cosmetics and jewelry".toUpperCase());
        chapterList.add("television trap".toUpperCase());
        chapterList.add("lawfully joined".toUpperCase());
        chapterList.add("music and moods".toUpperCase());
        chapterList.add("meat or unmeat".toUpperCase());
        chapterList.add("potlucks and principles".toUpperCase());
        chapterList.add("destroying your witness".toUpperCase());
        chapterList.add("legalism or love".toUpperCase());





        text_view = (TextView) findViewById(R.id.text_view);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, chapterList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownChapter.setAdapter(adapter);
        dropdownChapter.setBackgroundColor(Color.GREEN);

        dropdownChapter.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                fileName = adapterView.getItemAtPosition(position).toString();
                String text = "";

                try{
                    InputStream is = getAssets().open(fileName.toLowerCase()+".txt");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    text = new String(buffer);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                text_view.setText(text);
                text_view.setMovementMethod(new ScrollingMovementMethod());
                text_view.setTextSize(20);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }));



       // read_button.setOnClickListener(new View.OnClickListener() {
      //      @Override
      //      public void onClick(View view) {

      //      }
      //  });


    }

}
