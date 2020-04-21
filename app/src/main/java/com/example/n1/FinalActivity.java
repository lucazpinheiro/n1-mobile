package com.example.n1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    public String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent intent = getIntent();

        String studentName = intent.getStringExtra(GradesActivity.EXTRA_STUDENT_NAME);
        float finalGrade = intent.getFloatExtra(GradesActivity.EXTRA_FINAL_GRADE, 0);
        if (finalGrade >= 7) {
            this.status = "Aprovado";
        } else {
            this.status = "Reprovado";
        }

        TextView nameView = (TextView) findViewById(R.id.studentName);
        TextView finalGradeView = (TextView) findViewById(R.id.finalGrade);
        TextView statusView = (TextView) findViewById(R.id.status);

        nameView.setText(studentName);
        finalGradeView.setText(String.valueOf(finalGrade));
        statusView.setText(status);

    }
}
