package com.example.demo7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
}
