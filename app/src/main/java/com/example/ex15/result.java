package com.example.ex15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class result extends AppCompatActivity {
    Intent parentIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        parentIntent = getIntent();
    }

    public int[] calcMandatoryData(){
        int[] mandatoryData = new int[2];
        int gradeLang = parentIntent.getIntExtra("gradeLang", -1);
        int gradeLitr = parentIntent.getIntExtra("gradeLitr", -1);
        int gradeHist = parentIntent.getIntExtra("gradeHist", -1);
        int gradeCitz = parentIntent.getIntExtra("gradeCitz", -1);
        int gradeBible = parentIntent.getIntExtra("gradeCitz", -1);
        return mandatoryData;
    }
}