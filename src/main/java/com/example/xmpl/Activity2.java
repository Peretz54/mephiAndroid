package com.example.xmpl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        String Str = getIntent().getStringExtra("message");
        TextView infoTextView = (TextView)findViewById(R.id.textView);
        infoTextView.setText(Str);
    }
    public void email(View view) {
        TextView userTextView = (TextView) findViewById(R.id.textView);

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

        emailIntent.setData(Uri.parse("mailto:"));
     //   emailIntent.setType("text/plain");

 //       emailIntent.setDataAndType(Uri.parse("mailto:"), "text/plain");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, userTextView.getText().toString());
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,"address");
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"topic");

        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            Toast.makeText(Activity2.this, "Opening mailing app", Toast.LENGTH_SHORT).show();
            startActivity(emailIntent);
        } else {
            Toast.makeText(Activity2.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

    }
}
