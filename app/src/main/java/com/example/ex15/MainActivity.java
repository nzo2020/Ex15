package com.example.ex15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText grade1EditText, grade2EditText, grade3EditText, grade4EditText, grade5EditText;
    int gradeLang=-1, gradeLitr=-1, gradeHist=-1, gradeCitz=-1, gradeBible=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grade1EditText = findViewById(R.id.grade1);
        grade2EditText = findViewById(R.id.grade2);
        grade3EditText = findViewById(R.id.grade3);
        grade4EditText = findViewById(R.id.grade4);
        grade5EditText = findViewById(R.id.grade5);
        if(gradeLang>-1) {
            grade1EditText.setText(gradeLang);
        }
        if(gradeLitr>-1){
            grade2EditText.setText(gradeLitr);
        }
        if(gradeHist>-1){
            grade3EditText.setText(gradeHist);
        }
        if(gradeCitz>-1){
            grade4EditText.setText(gradeCitz);
        }
        if(gradeBible>-1){
            grade5EditText.setText(gradeBible);
        }
    }

    public void grades() {
        String grade1Text = grade1EditText.getText().toString();
        String grade2Text = grade2EditText.getText().toString();
        String grade3Text = grade3EditText.getText().toString();
        String grade4Text = grade4EditText.getText().toString();
        String grade5Text = grade5EditText.getText().toString();

        if (isValidGrade(grade1Text) && isValidGrade(grade2Text) && isValidGrade(grade3Text) && isValidGrade(grade4Text) && isValidGrade(grade5Text)) {
            gradeLang = Integer.parseInt(grade1Text);
            gradeLitr = Integer.parseInt(grade2Text);
            gradeHist = Integer.parseInt(grade3Text);
            gradeCitz = Integer.parseInt(grade4Text);
            gradeBible = Integer.parseInt(grade5Text);
        } else {
            Toast.makeText(this, "Invalid grade input. Please enter grades between 0 and 100.", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean isValidGrade(String grade) {
        return !grade.isEmpty() && !(Integer.parseInt(grade) > 100);
    }
    public boolean isValidName(String name){
        return !name.isEmpty() &
    }

    public void next(View view) {
        grades();
        Intent intent1 = new Intent(MainActivity.this, second_activity.class);
        intent1.putExtra("gradeLang", gradeLang);
        intent1.putExtra("gradeLitr", gradeLitr);
        intent1.putExtra("gradeHist", gradeHist);
        intent1.putExtra("gradeCitz", gradeCitz);
        intent1.putExtra("gradeBible", gradeBible);

        startActivity(intent1);
    }
}
