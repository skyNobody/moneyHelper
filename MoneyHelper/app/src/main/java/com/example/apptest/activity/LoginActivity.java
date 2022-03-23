package com.example.apptest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.apptest.R;
import com.example.apptest.bean.Account;

import org.litepal.LitePal;

import java.util.List;

public class LoginActivity extends baseActivity{
    private EditText accountEdit;

    private EditText passwordEdit;

    private Button loginButton;

    private Button createAccountButton;

    private Button show;

    private boolean isLeagalAccount(String account, String password) {
        List<Account> arr = LitePal.where("account=?", account).find(Account.class);
        for (Account account1 : arr) {
            if (account1.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        accountEdit = findViewById(R.id.accountEdit);
        passwordEdit = findViewById(R.id.passwordEdit);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                LitePal.getDatabase();
                if (isLeagalAccount(account, password)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "ERR", Toast.LENGTH_SHORT).show();
                }
            }
        });

        createAccountButton = findViewById(R.id.createAccount);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.getDatabase();
                Account account = new Account();
                account.setAccount(accountEdit.getText().toString());
                account.setPassword(passwordEdit.getText().toString());
                account.save();
            }
        });
        show = findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Account> arr = LitePal.findAll(Account.class);
                for (Account account : arr) {
                    System.out.println(account.getAccount());
                }
            }
        });
    }
}
