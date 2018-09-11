package com.bloodbank.loginsignup;

import android.content.Intent;
import android.media.MediaCodec;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bloodbank.R;
import com.bloodbank.profileuser.UserProfile;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {
EditText emailLogin,passLogin;
    Button loginUser,signUpUser;
    FirebaseAuth nAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        nAuth=FirebaseAuth.getInstance();
        emailLogin=(EditText)findViewById(R.id.emailLogin);
        passLogin=(EditText)findViewById(R.id.passwordLogIn);
        loginUser=(Button)findViewById(R.id.logins);
        signUpUser=(Button)findViewById(R.id.signUps);

        loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        signUpUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogInActivity.this,SignUpActivity.class));
            }
        });
    }

    private void login() {
        String email=emailLogin.getText().toString();
        String password=passLogin.getText().toString();
        if(email.isEmpty())
        {
            emailLogin.setError("Email required");
        }
        if(password.isEmpty())
        {
            passLogin.setError("Password Required");
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            emailLogin.setError("enter valid email");
        }
        if(password.length()<6)
        {
            passLogin.setError("pleasee enter 6 digits password");
        }

        else {

            nAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                  startActivity(new Intent(LogInActivity.this, UserProfile.class));
                    }
                }
            });


        }


    }
}
