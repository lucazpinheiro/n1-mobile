package com.example.n1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GradesActivity extends AppCompatActivity {

    public static final String EXTRA_FINAL_GRADE = "com.example.n1.EXTRA_FINAL_GRADE";
    public static final String EXTRA_STUDENT_NAME = "com.example.n1.EXTRA_STUDENT_NAME";

    public String studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        Intent intent = getIntent();
        this.studentName = intent.getStringExtra(MainActivity.EXTRA_NAME);
        TextView nameView = (TextView) findViewById(R.id.studentName);
        nameView.setText(studentName);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFinalActivity();
            }
        });
    }

    public void openFinalActivity() {
        EditText gradeOneInput = (EditText) findViewById(R.id.gradeOneInput);
        float gradeOneValue = Float.parseFloat(gradeOneInput.getText().toString());

        EditText gradeTwoInput = (EditText) findViewById(R.id.gradeTwoInput);
        float gradeTwoValue = Float.parseFloat(gradeTwoInput.getText().toString());

        float finalGrade = calculateFinalGrade(gradeOneValue, gradeTwoValue);

        Intent intent = new Intent(this, FinalActivity.class);
        intent.putExtra(EXTRA_STUDENT_NAME , studentName);
        intent.putExtra(EXTRA_FINAL_GRADE, finalGrade);
        startActivity(intent);
    }

    private Float calculateFinalGrade(Float gradeOne, Float gradeTwo) {
        return (gradeOne + gradeTwo) / 2;
    }

}
