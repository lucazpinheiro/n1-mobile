package com.example.n1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.n1.EXTRA_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGradesActivity();
            }
        });

    }

    public void openGradesActivity() {

        EditText nameInput = (EditText) findViewById(R.id.nameInput);
        String nameValue = nameInput.getText().toString();

        Intent intent = new Intent(this, GradesActivity.class);
        intent.putExtra(EXTRA_NAME, nameValue);
        startActivity(intent);

    }


}
