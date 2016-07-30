package com.gradlers.augecomm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button seller_sign_in,seller_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seller_sign_in=(Button)findViewById(R.id.seller_sign_in);
        seller_sign_up=(Button)findViewById(R.id.seller_sign_up);

        seller_sign_in.setOnClickListener(this);
        seller_sign_up.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.seller_sign_in:
                System.out.println("Activity Switched");
                Intent i = new Intent(this,SellerLoginActivity.class);
                startActivity(i);
                break;


            case R.id.seller_sign_up:


                break;





        }
    }
}
