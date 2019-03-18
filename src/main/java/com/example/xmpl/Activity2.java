package com.example.xmpl;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "message";

    public static void start(Activity activity, String message) {
        Intent intent = new Intent(activity, Activity2.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        TextView infoTextView = findViewById(R.id.textView);
        infoTextView.setText(intent.getStringExtra(EXTRA_MESSAGE));

            Button emailButton = findViewById(R.id.button);
            emailButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    email(v);
                }
            });
    }

    public void email(View view) {
        TextView userTextView = findViewById(R.id.textView);
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, userTextView.getText().toString());
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, "address");
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "topic");

        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            Toast.makeText(Activity2.this, "Opening mailing app", Toast.LENGTH_SHORT).show();
            startActivity(emailIntent);
        } else {
            Toast.makeText(Activity2.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

    }
}
