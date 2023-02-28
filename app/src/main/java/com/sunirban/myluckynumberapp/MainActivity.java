package com.sunirban.myluckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button signInBtn;
    EditText inputName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInBtn = findViewById(R.id.sign_in_btn);
        inputName = findViewById(R.id.input_editText);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString();
                // Explicit Intent
                Intent i = new Intent(getApplicationContext(),LuckyNumberActivity.class);
                i.putExtra("name",name);
                startActivity(i);
            }
        });

    }
}