package com.andteam.sep4greenhouse.view;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.andteam.sep4greenhouse.R;
import com.andteam.sep4greenhouse.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button btnLogin;
    private Button btnRegister;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        username = findViewById(R.id.userName);
        password = findViewById(R.id.password);

        initUserLoginButton();
        initRegistrationRedirection();
        initViewModel();
    }

    private void initUserLoginButton() {
        btnLogin = findViewById(R.id.button_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
    }

    private void initRegistrationRedirection() {
        btnRegister = findViewById(R.id.button_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegistration();
            }
        });
    }

    private void initViewModel() {
        //TODO
    }

    private void startRegistration() {
        Intent registration = new Intent(this, RegisterActivity.class);
        startActivity(registration);
        finish();
    }
}
