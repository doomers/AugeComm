package com.gradlers.augecomm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by doomers on 28/7/16.
 */
public class FireBaseScope {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Context context;
    public FireBaseScope(Context context){
        this.context = context;

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("FireAuth", "onAuthStateChanged:signed_in:" + user.getUid());

                    //textView.setText("Already Logged in: "+user.getEmail());

                } else {
                    // User is signed out
                    Log.d("FireAuth", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };


    }
    public void doSignup(String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((SellerLoginActivity)context
                        , new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d("Auth", "createUserWithEmail:onComplete:" + task.isSuccessful());


                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(context,"Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(context,"SignUp Successful!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

    }

    public void SignOut() {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(context, "Sign out", Toast.LENGTH_LONG);
    }

    public void doLogin(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((SellerLoginActivity)context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("FireAuth", "signInWithEmail:onComplete:" + task.isSuccessful());


                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("FireAuth", "signInWithEmail", task.getException());
                            Toast.makeText(context, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            //  textView.setText("Welcome "+email_edit_text.getText().toString());
                            Toast.makeText(context,"Welcome",Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    public void OnStart(){
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void OnStop(){
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
