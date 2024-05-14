package com.example.ex15;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class second_activity extends AppCompatActivity {
    TextView agbara1, agbara2, agbara3, level1, level2, level3;
    RadioGroup radioGroup;
    RadioButton option1, option2, option3;
    EditText agbaraGrade1, agbaraGrade2, agbaraGrade3, edtMathGrade, edtEnglishGrade, edtEnglishLevel,
            edtMathLevel;
    Intent intent2, intent;
    int mathGrade, mathLevel, englishGrade, englishLevel, answer, grade1, grade2, grade3, selectedOption=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        intent2 = new Intent(second_activity.this, result.class);
        initViews();
        intent = getIntent();

    }
    public void clearSelection(){
        agbara1.setVisibility(View.INVISIBLE);
        agbara2.setVisibility(View.INVISIBLE);
        agbara3.setVisibility(View.INVISIBLE);
        agbaraGrade1.setVisibility(View.INVISIBLE);
        agbaraGrade2.setVisibility(View.INVISIBLE);
        agbaraGrade3.setVisibility(View.INVISIBLE);
        level1.setVisibility(View.INVISIBLE);
        level2.setVisibility(View.INVISIBLE);
        level3.setVisibility(View.INVISIBLE);
        agbara1.setText("");
        agbara2.setText("");
        agbara3.setText("");
        level1.setText("");
        level2.setText("");
        level3.setText("");
        grade1=0;
        grade2=0;
        grade3=0;
    }

    public void clickedOption1(View view) {
        clearSelection();
        selectedOption=1;
        agbara1.setVisibility(View.VISIBLE);
        agbara2.setVisibility(View.VISIBLE);
        agbaraGrade1.setVisibility(View.VISIBLE);
        agbaraGrade2.setVisibility(View.VISIBLE);
        level1.setVisibility(View.VISIBLE);
        level2.setVisibility(View.VISIBLE);
        agbara1.setText("מבוא למדעים");
        agbara2.setText(agbara2.getText().toString());
        level1.setText("1");
        level2.setText("5");
    }

    public void clickedOption2(View view) {
        clearSelection();
        selectedOption = 2;
        agbara1.setVisibility(View.VISIBLE);
        agbara2.setVisibility(View.VISIBLE);
        agbaraGrade1.setVisibility(View.VISIBLE);
        agbaraGrade2.setVisibility(View.VISIBLE);
        level1.setVisibility(View.VISIBLE);
        level2.setVisibility(View.VISIBLE);
        agbara1.setText(agbara1.getText().toString());
        agbara2.setText(agbara2.getText().toString());
        level1.setText("5");
        level2.setText("5");
    }


    public void clickedOption3(View view) {
        clearSelection();
        selectedOption=3;
        agbara1.setVisibility(View.VISIBLE);
        agbara2.setVisibility(View.VISIBLE);
        agbara3.setVisibility(View.VISIBLE);
        agbaraGrade1.setVisibility(View.VISIBLE);
        agbaraGrade2.setVisibility(View.VISIBLE);
        agbaraGrade3.setVisibility(View.VISIBLE);
        level1.setVisibility(View.VISIBLE);
        level2.setVisibility(View.VISIBLE);
        level3.setVisibility(View.VISIBLE);
        agbara1.setText(agbara1.getText().toString());
        agbara2.setText(agbara2.getText().toString());
        agbara3.setText(agbara3.getText().toString());
        level1.setText("5");
        level2.setText("5");
        level3.setText("5");
    }

    private void initViews() {
        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        agbara1 = findViewById(R.id.agbara1);
        agbara2 = findViewById(R.id.agbara2);
        agbara3 = findViewById(R.id.agbara3);
        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        agbaraGrade1 = findViewById(R.id.agbaraGrade1);
        agbaraGrade2 = findViewById(R.id.agbaraGrade2);
        agbaraGrade3 = findViewById(R.id.agbaraGrade3);
        edtMathGrade = findViewById(R.id.mathGrade);
        edtEnglishGrade = findViewById(R.id.englishGrade);
        edtEnglishLevel = findViewById(R.id.englishLevel);
        edtMathLevel = findViewById(R.id.mathLevel);
    }

    public boolean isValidGrade(String grade) {
        return !grade.isEmpty() && !(Integer.parseInt(grade) > 100);
    }


    public boolean isValidLevel(String level) {
        return !level.isEmpty() && !(Integer.parseInt(level) > 100);
    }

    public void next(View view) {
        if (!isValidLevel(edtEnglishLevel.getText().toString()) ||
                !isValidLevel(edtMathLevel.getText().toString()) ||
                !isValidGrade(edtMathGrade.getText().toString()) ||
                !isValidGrade(edtEnglishGrade.getText().toString())) {
            Toast.makeText(this, "Wrong input", Toast.LENGTH_SHORT).show();
            mathGrade = 0;
            mathLevel = 0;
            englishGrade = 0;
            englishLevel = 0;
        } else {
            String mathGradeStr = edtMathGrade.getText().toString();
            String mathLevelStr = edtMathLevel.getText().toString();
            String englishGradeStr = edtEnglishGrade.getText().toString();
            String englishLevelStr = edtEnglishLevel.getText().toString();
            int mathGrade = Integer.parseInt(mathGradeStr);
            int mathLevel = Integer.parseInt(mathLevelStr);
            int englishGrade = Integer.parseInt(englishGradeStr);
            int englishLevel = Integer.parseInt(englishLevelStr);
            intent2.putExtra("mathGrade", mathGrade);
            intent2.putExtra("mathLevel", mathLevel);
            intent2.putExtra("englishGrade", englishGrade);
            intent2.putExtra("englishLevel", englishLevel);
            startActivity(intent2);
        }
        if(selectedOption==1){
            if (!isValidGrade(agbaraGrade1.getText().toString()) ||
                    !isValidGrade(agbaraGrade2.getText().toString())) {
                Toast.makeText(this, "Wrong input", Toast.LENGTH_SHORT).show();
                grade1= 0;
                grade2= 0;
            } else {
                String agbaraGrade1Str = agbaraGrade1.getText().toString();
                String agbaraGrade2Str = agbaraGrade2.getText().toString();
                int agbaraGrade1 = Integer.parseInt(agbaraGrade1Str);
                int agbaraGrade2 = Integer.parseInt(agbaraGrade2Str);
                intent2.putExtra("agbaraGrade1",agbaraGrade1 );
                intent2.putExtra("agbaraGrade2", agbaraGrade2);
                intent2.putExtra("level1", 1);
                intent2.putExtra("level2", 5);
                startActivity(intent2);
            }
        }else if (selectedOption==2){
            if (!isValidGrade(agbaraGrade1.getText().toString()) ||
                    !isValidGrade(agbaraGrade2.getText().toString())) {
                Toast.makeText(this, "Wrong input", Toast.LENGTH_SHORT).show();
                grade1= 0;
                grade2= 0;
            } else {
                String agbaraGrade1Str = agbaraGrade1.getText().toString();
                String agbaraGrade2Str = agbaraGrade2.getText().toString();
                int agbaraGrade1 = Integer.parseInt(agbaraGrade1Str);
                int agbaraGrade2 = Integer.parseInt(agbaraGrade2Str);
                intent2.putExtra("agbaraGrade1", agbaraGrade1);
                intent2.putExtra("agbaraGrade2", agbaraGrade2);
                intent2.putExtra("level1", 5);
                intent2.putExtra("level2", 5);
                startActivity(intent2);
            }
        }else if (selectedOption==3){
            if (!isValidGrade(agbaraGrade1.getText().toString()) ||
                    !isValidGrade(agbaraGrade2.getText().toString())||
                    !isValidGrade(agbaraGrade3.getText().toString())) {
                Toast.makeText(this, "Wrong input", Toast.LENGTH_SHORT).show();
                grade1= 0;
                grade2= 0;
                grade3= 0;
            } else {
                String agbaraGrade1Str = agbaraGrade1.getText().toString();
                String agbaraGrade2Str = agbaraGrade2.getText().toString();
                String agbaraGrade3Str = agbaraGrade3.getText().toString();
                int agbaraGrade1 = Integer.parseInt(agbaraGrade1Str);
                int agbaraGrade2 = Integer.parseInt(agbaraGrade2Str);
                int agbaraGrade3 = Integer.parseInt(agbaraGrade3Str);
                intent2.putExtra("agbaraGrade1", agbaraGrade1);
                intent2.putExtra("agbaraGrade2", agbaraGrade2);
                intent2.putExtra("agbaraGrade3", agbaraGrade3);
                intent2.putExtra("level1", 5);
                intent2.putExtra("level2", 5);
                intent2.putExtra("level3", 5);
                startActivity(intent2);
            }
        }
    }

    public void prev(View view){
        finish();
    }
}
