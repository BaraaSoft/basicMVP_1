package com.baraa.bsoft.daggerloggin.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baraa.bsoft.daggerloggin.R;
import com.baraa.bsoft.daggerloggin.root.App;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    private EditText edFirstName;
    private EditText edLastName;
    private Button btnLogin;

    @Inject
    LoginActivityMVP.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App)getApplication()).getComponent().inject(this);

        edFirstName = findViewById(R.id.edFname);
        edLastName = findViewById(R.id.edLname);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.setView(this);
    }

    @Override
    public String getFirstName() {
        return edFirstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return edLastName.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this,"User not available!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this,"Input error!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this,"User saved successfully!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void setFirstName(String fname) {
        edFirstName.setText(fname);
    }

    @Override
    public void setLastName(String lname) {
        edLastName.setText(lname);
    }
}
