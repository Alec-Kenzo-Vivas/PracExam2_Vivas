package com.example.labexe3_vivas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("4ITB", "onCreate has executed");
        Intent i = new Intent(this, myService.class);
        startService(i);

        FileInputStream reader = null;
        String data= "";
        try {
            reader = openFileInput("data1.txt");
            int token;

            while ((token = reader.read()) != -1){
                data = data + (char)token;
            }
        } catch (FileNotFoundException e) {
            Log.d("ERROR","FILE NOT FOUND");
        }
        catch (IOException e) {
            Log.d("ERROR","IO ERROR");
        }
        EditText editText = (EditText)findViewById(R.id.ee1);
        editText.setText(data, TextView.BufferType.EDITABLE);

        FileInputStream readerComment = null;
        String datacomment= "";
        try {
            readerComment = openFileInput("data2.txt");
            int token;

            while ((token = readerComment.read()) != -1){
                datacomment = datacomment + (char)token;
            }
        } catch (FileNotFoundException e) {
            Log.d("ERROR","FILE NOT FOUND");
        }
        catch (IOException e) {
            Log.d("ERROR","IO ERROR");
        }
        EditText editText2 = (EditText)findViewById(R.id.com1);
        editText2.setText(datacomment, TextView.BufferType.EDITABLE);


    }

    public void regis (View v){
        Toast.makeText(this, "Registration Sent", Toast.LENGTH_LONG).show();
    }
    public void display2(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }


}
