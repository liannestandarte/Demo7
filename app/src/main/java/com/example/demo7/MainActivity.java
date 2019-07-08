package com.example.demo7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText txtName, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.etName);
        txtPassword = findViewById(R.id.etPassword);
    }

    public void  displayActivity2 (View v) {
        Intent i = new Intent(this, Activity2.class);
        startActivity(i);
    }

    public  void saveInfo(View v) {
        SharedPreferences sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("user",txtName.getText().toString());
        editor.putString("pwd",txtPassword.getText().toString());
        editor.commit();
        Toast.makeText(this,"saved in userInfo.xml1",Toast.LENGTH_LONG).show();
    }
    public void saveInternal(View v) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("user.txt",Context.MODE_PRIVATE);
            fos.write((txtName.getText().toString() + ", ").getBytes());
            fos.write(txtPassword.getText().toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this,"toast saved",Toast.LENGTH_LONG).show();
    }
}
