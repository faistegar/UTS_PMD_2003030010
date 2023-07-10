package com.example.UTS_PMD_2003030010;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Hasil extends AppCompatActivity {

    private TextView tvHasil;
    Button btnExit;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        tvHasil = findViewById(R.id.tvHasil);
        btnExit = findViewById(R.id.btnExit);

        TextView textView = (TextView) findViewById(R.id.tvHasil);
        Bundle bundle = getIntent().getExtras();
        String data = bundle.get("data").toString();
        textView.setText(data);

        if (data.equals("Indonesia")) {
            tvHasil.setText("Berhasil");
        } else if (data.equals("Inggris")) {
            tvHasil.setText("Succeed");
        } else if (data.equals("Jawa")) {
            tvHasil.setText("Sukses");
        }

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(Hasil.this);
                builder.setIcon(R.drawable.ic_baseline_android_24);
                builder.setTitle(R.string.title);
                builder.setMessage(R.string.messege);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Hasil.this,"Thank you",Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Hasil.this,"you have clicked no button",Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog tDialog = builder.create();
                tDialog.show();
            }
        });
    }
}