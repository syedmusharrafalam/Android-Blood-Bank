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
import android.widget.Spinner;
import android.widget.Toast;

import com.bloodbank.R;
import com.bloodbank.gettersetterpckg.UserInformation;
import com.bloodbank.profileuser.UserProfile;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
EditText fName,lName,email,pass;
    Spinner bloodGroup;
    Button btnLogin,btnSignUp;
    FirebaseAuth nAuth;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fName=(EditText)findViewById(R.id.firstName);
        lName=(EditText)findViewById(R.id.lastName);
        email=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.password);
        bloodGroup=(Spinner)findViewById(R.id.spinner);
        btnLogin=(Button)findViewById(R.id.login);
        btnSignUp=(Button)findViewById(R.id.signUp);
        nAuth=FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(SignUpActivity.this,LogInActivity.class));
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registered();
            }
        });


    }

    private void registered() {
        final String firstName=fName.getText().toString();
        final String lastName=lName.getText().toString();
        final String emails=email.getText().toString();
        final String password=pass.getText().toString();
        final String blood=bloodGroup.getSelectedItem().toString();

        if(firstName.isEmpty())
        {
            fName.setError("first Name required");
        }

        if(lastName.isEmpty())
        {
         lName.setError("second Name required");
        }
        if(emails.isEmpty())
        {
            email.setError("Email required");
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emails).matches())
        {
            email.setError("please enter valid email");
        }
        if(password.isEmpty())
        {
            pass.setError("password Required");
        }
        if(password.length()<6)
        {
            pass.setError("please enter atleast 6 digits ");
        }
       else {

            nAuth.createUserWithEmailAndPassword(emails,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful())
                   {
                       ref= FirebaseDatabase.getInstance().getReference().child("users");
                       String uid=ref.push().getKey();
                       UserInformation userInformation=new UserInformation(uid,firstName,lastName,emails,password,blood);
                        ref.child(uid).setValue(userInformation);
                       //public UserInformation(String uid, String fistName, String lastName, String email, String password, String bloodGroup)

                       Toast.makeText(SignUpActivity.this,"registered Successfull",Toast.LENGTH_LONG).show();
                       finish();
                       startActivity(new Intent(SignUpActivity.this,LogInActivity.class));

                   }
                   else {
                       Toast.makeText(SignUpActivity.this,"not registered",Toast.LENGTH_LONG).show();
                   }
                }
            });


        }




    }
}
