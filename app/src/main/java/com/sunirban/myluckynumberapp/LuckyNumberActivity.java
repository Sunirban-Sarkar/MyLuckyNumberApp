package com.sunirban.myluckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    TextView luckyNumber;
    Button shareBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        luckyNumber = findViewById(R.id.lucky_number_text);
        shareBtn = findViewById(R.id.share_btn);

        Intent i = getIntent();
        String userName = i.getStringExtra("name");
        int randomNumber = generateRandomNumber();
        luckyNumber.setText(String.format("%d",randomNumber));
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName,randomNumber);
            }
        });
    }

    public int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(1000)+1;
    }

    public void shareData(String userName, int randomNumber){
        // Implicit intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, userName+ " got lucky today");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is "+randomNumber);
        startActivity(Intent.createChooser(i,"Choose a platform"));
    }
}