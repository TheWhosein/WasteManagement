package com.whosein.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    EditText password, email;
    String email1;
    String password1;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        email = findViewById(R.id.emailText);
        password = findViewById(R.id.usernameText);

        Intent intent = getIntent();
        String email1 = intent.getStringExtra("email");
        String password1 = intent.getStringExtra("password");
        email.setText(email1);
        password.setText(password1);

        String getPassword = password.getText().toString().trim();
        String getEmail = email.getText().toString().trim();

        sharedPreferences = this.getSharedPreferences("com.whosein.wastemanagement", Context.MODE_PRIVATE);
        String email2 = sharedPreferences.getString("email", "");
        String password2 = sharedPreferences.getString("password", "");
        if(getPassword.isEmpty() || getEmail.isEmpty()) {
            email.setText(email2);
            password.setText(password2);
        }

    }

    public void submit(View view){
        String password1 = password.getText().toString().trim();
        String email1 = email.getText().toString().trim();
        if(email1.isEmpty() || password1.isEmpty()){
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
            intent.putExtra("email",email1);
            startActivity(intent);
            sharedPreferences.edit().putString("email", email1).apply();
            sharedPreferences.edit().putString("password", password1).apply();
        }
    }

    public void register(View view){
        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
        startActivity(intent);
    }

}