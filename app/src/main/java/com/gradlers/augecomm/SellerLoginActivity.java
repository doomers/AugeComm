package com.gradlers.augecomm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SellerLoginActivity extends AppCompatActivity {

    Button btnLogin,btnSignup,btnLogOut;
    TextView textView;
    EditText email_edit_text,password_edit_text;

    String email="adhish@adhishlal.com";
    String password="password";
    FireBaseScope fireBaseScope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_login);
        email_edit_text = (EditText)findViewById(R.id.email_edit_Text);
        password_edit_text = (EditText)findViewById(R.id.password_edit_text);

        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnSignup=(Button)findViewById(R.id.btnSignup);
        btnLogOut=(Button)findViewById(R.id.btnLogOut);
        textView=(TextView) findViewById(R.id.textView);
        fireBaseScope = new FireBaseScope(SellerLoginActivity.this);
        //sellerFunctions.OnStart();



        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fireBaseScope.doSignup(email_edit_text.getText().toString() , password_edit_text.getText().toString());

            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fireBaseScope.SignOut();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fireBaseScope.doLogin(email_edit_text.getText().toString() , password_edit_text.getText().toString());
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        fireBaseScope.OnStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        fireBaseScope.OnStop();
    }


}
