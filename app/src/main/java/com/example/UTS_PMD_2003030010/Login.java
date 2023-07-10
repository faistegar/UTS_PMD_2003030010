package com.example.UTS_PMD_2003030010;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private CheckBox cb1;
    private Spinner Spinner1;

    private String username = "Admin";
    private String password = "Admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Spinner1 = findViewById(R.id.Spinner1);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        cb1 = findViewById(R.id.cb1);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.beep);
        List<String> categories = new ArrayList<>();
        categories.add(0, "Choose category");
        categories.add("Indonesia");
        categories.add("Inggris");
        categories.add("Jawa");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().equalsIgnoreCase(username) && etPassword.getText().toString().equalsIgnoreCase(password)){
                    Intent login = new Intent(Login.this, Hasil.class);
                    login.putExtra("data",String.valueOf(Spinner1.getSelectedItem()));
                    startActivity(login);
                    mediaPlayer.start();

                    Toast.makeText(Login.this, "Login Berhasil!!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Login.this, "Username atau password salah", Toast.LENGTH_LONG).show();

                }
            }
        });
        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner1.setAdapter(dataAdapter);
        Spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}