package com.example.xmpl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button previewButton = findViewById(R.id.bPreview);
        previewButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText userEditText = findViewById(R.id.editText);
                Activity2.start(MainActivity.this, userEditText.getText().toString());
            }
        });
    }


//    public void onClick(View view) {
//        EditText userEditText = (EditText) findViewById(R.id.editText);
//        Intent intent = new Intent(MainActivity.this, Activity2.class);
//        intent.putExtra("message", userEditText.getText().toString());
//        startActivity(intent);
//    }
}
