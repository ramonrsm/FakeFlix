package com.example.fakeflix.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.fakeflix.Models.Entities.Authentication;
import com.example.fakeflix.Models.Entities.User;
import com.example.fakeflix.Models.Exceptions.DomainException;
import com.example.fakeflix.R;
import com.example.fakeflix.Util.Helpers;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText textInputEditLayout_user;
    private TextInputEditText textInputEditLayout_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditLayout_user     = findViewById(R.id.textInputEditLayout_user);
        textInputEditLayout_password = findViewById(R.id.textInputEditLayout_password);

        MaterialButton button_sign_in = findViewById(R.id.button_sign_in);

        User user = new User(1,"ramonmourarsm@outlook.com", "123456");

        textInputEditLayout_user.setText(user.getEmail());
        textInputEditLayout_password.setText(user.getPassword());
        button_sign_in.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String email = Objects.requireNonNull(textInputEditLayout_user.getText()).toString();
        String senha = Objects.requireNonNull(textInputEditLayout_password.getText()).toString();

        try {
            if(!Helpers.IsEmpty(email, senha)){

                if(Authentication.Authenticate(email,senha)){
                    Toast.makeText(this, "Usuário autenticado", Toast.LENGTH_SHORT).show();
                    Helpers.goToActivity(LoginActivity.this, MainActivity.class);
                    finish();
                }
            }
        } catch (DomainException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
