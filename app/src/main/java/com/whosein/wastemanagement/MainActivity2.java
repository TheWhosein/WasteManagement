package com.whosein.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        email = findViewById(R.id.mail);

        Intent intent = getIntent();
        String email1 = intent.getStringExtra("email");

        email.setText(email1);

    }

    public void map(View view){
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
    public void youtube(View view){
        String youTubeUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";

        // Intent to open the YouTube app or a web browser
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youTubeUrl));
        intent.putExtra("force_fullscreen",true); // Optional parameter for fullscreen
        intent.putExtra("force_autoplay",true); // Optional parameter for autoplay
        startActivity(intent);
    }
    public void about(View view){

    }
    public void feedback(View view){

    }
    public void exit(View view){
        finishAffinity();
    }

}