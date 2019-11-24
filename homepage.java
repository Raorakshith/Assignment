package com.example.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        String username=getIntent().getStringExtra("username");
        TextView uname=findViewById(R.id.textr);
        uname.setText(username);
    }
}
