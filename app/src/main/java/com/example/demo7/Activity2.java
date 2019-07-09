package com.example.demo7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Activity2 extends AppCompatActivity {

    TextView txtName, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
            txtName = findViewById(R.id.tvName);
            txtPassword = findViewById(R.id.tvPassword);
        }

        public void goPrevious(View v) {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }

        public void displayUser (View v) {
            SharedPreferences sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
            txtName.setText(sp.getString("user",""));
            txtPassword.setText(sp.getString("pwd",""));
        }


    public void displayInternal (View v) {
        FileInputStream fis = null;
        StringBuffer buffer = new StringBuffer();
        int letter = 0;
        try {
            fis = openFileInput("user.txt");
            while ((letter = fis.read()) != -1) {
                buffer.append((char)letter);
            }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        //  Toast.makeText(this, buffer, Toast.LENGTH_LONG).show();
        //String name, password, str;
        //byte[] str = buffer.toString().getBytes();
        //while (str != Integer.parseInt(",")) {}
        //String name, password, str;
        //str = buffer.toString();
        //name = str.substring(0, str.indexOf(","));
        //password = str.substring(str.indexOf(",")+1);
        txtName.setText(buffer.substring(0,buffer.indexOf(",")));
        txtPassword.setText(buffer.substring(buffer.indexOf(",")+1));
    }
}

