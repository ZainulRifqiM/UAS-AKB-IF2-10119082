package com.zainulrifqi.uasakbif_210119082;

// NIM   : 10119082
// Nama  : Zainul Rifqi Muwaffaq
// Kelas : IF2

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnMasuk, btnDaftar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();

        btnMasuk = (Button) findViewById(R.id.btn_login);
        btnDaftar = (Button) findViewById(R.id.btn_signup);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);

        btnMasuk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();


                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "User dan Email berhasil dibuat", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this,LoginActivity.class));

                        } else {
                            Toast.makeText(SignUpActivity.this, "Otentikasi Gagal!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        btnMasuk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });
    }
}