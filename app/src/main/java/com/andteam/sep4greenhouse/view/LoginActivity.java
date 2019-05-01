package com.andteam.sep4greenhouse.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.andteam.sep4greenhouse.R;
import com.andteam.sep4greenhouse.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button btnLogin;
    private Button btnRegister;
    private LoginViewModel loginViewModel;
    // Do observer on loginViewModel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        username = findViewById(R.id.username_input);
        password = findViewById(R.id.password_input);
        loginViewModel = new LoginViewModel();

        btnRegister = findViewById(R.id.button_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUserRegisterClick();
            }
        });

        initUserLoginButton();
        initViewModel();
    }

    private void initUserLoginButton() {
        btnLogin = findViewById(R.id.button_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.login(username.getText().toString(), password.getText().toString());


            }
        });
    }

    private void initViewModel() {
        loginViewModel.getTest().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean) {
                    makeToast();
                    onUserLoginClick();
            }
        }
    });
    }

    private void makeToast() {
        String text = loginViewModel.responseFromRetrofit;
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    private void onUserRegisterClick() {
        Intent register = new Intent(this, RegisterActivity.class);
        startActivity(register);

    }

    private void onUserLoginClick() {
        Intent login = new Intent(this, MainActivity.class);
        startActivity(login);
    }
}
