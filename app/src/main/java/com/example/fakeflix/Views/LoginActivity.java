package com.example.fakeflix.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fakeflix.Models.Entities.Authentication;
import com.example.fakeflix.Models.Entities.Client;
import com.example.fakeflix.Models.Exceptions.DomainException;
import com.example.fakeflix.R;
import com.example.fakeflix.Util.Helpers;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout   textInputLayout_user;
    private TextInputLayout   textInputLayout_password;

    private TextInputEditText textInputEditLayout_user;
    private TextInputEditText textInputEditLayout_password;

    private MaterialButton    button_sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputLayout_user         = findViewById(R.id.textInputLayout_user);
        textInputLayout_password     = findViewById(R.id.textInputLayout_password);

        textInputEditLayout_user     = findViewById(R.id.textInputEditLayout_user);
        textInputEditLayout_password = findViewById(R.id.textInputEditLayout_password);

        button_sign_in               = findViewById(R.id.button_sign_in);

        textInputEditLayout_user.setText("ramonmourarsm@outlook.com");
        textInputEditLayout_password.setText("123456");
        button_sign_in.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String email = Objects.requireNonNull(textInputEditLayout_user.getText()).toString();
        String senha = Objects.requireNonNull(textInputEditLayout_password.getText()).toString();

        try {
            if(!Helpers.IsEmpty(email, senha)){

                if(Authentication.SignIn(email,senha)){
                    Toast.makeText(this, "Usuário autenticado", Toast.LENGTH_SHORT).show();
                    Helpers.forActivity(LoginActivity.this, MainActivity.class);
                    finish();
                }
            }
        } catch (DomainException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
