package com.piyushmaheswari.mvpdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.piyushmaheswari.mvpdesign.Presenter.ILoginPresenter;
import com.piyushmaheswari.mvpdesign.Presenter.LoginPresenter;
import com.piyushmaheswari.mvpdesign.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText email,password;
    Button login;

    ILoginPresenter iLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.email);
        password=findViewById(R.id.pass);
        login=findViewById(R.id.loginBtn);

        iLoginPresenter=new LoginPresenter(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iLoginPresenter.onLogin(email.getText().toString(),password.getText().toString());
            }
        });
    }

    @Override
    public void onLoginResult(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}
