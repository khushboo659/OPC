package com.example.opc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText email,password;
    private RadioButton adminRB,tpoRB,studentRB;
    private Button SignIn;
    private FirebaseAuth mAuth;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        adminRB = findViewById(R.id.admin);
        studentRB = findViewById(R.id.student);
        tpoRB = findViewById(R.id.tpo);
        SignIn = findViewById(R.id.signIn);
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null) {
            Log.i("user email", currentUser.getEmail());
            Intent intent = new Intent(MainActivity.this,student_main.class);
            startActivity(intent);
        }

        else
            Log.i("user email","null");
    }

    public void signIn(View view) {
        final String myEmail = email.getText().toString().trim();
        final String myPassword = password.getText().toString().trim();

        if (myEmail.length() <= 0 || myPassword.length() <= 0)
            Toast.makeText(MainActivity.this, "please complete all the fields", Toast.LENGTH_SHORT).show();
        else{
            mAuth.signInWithEmailAndPassword(myEmail, myPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                if (adminRB.isChecked())
                                {
                                    Intent intent = new Intent(MainActivity.this,AdminActivity.class);
                                    startActivity(intent);
                                }
                                else if(tpoRB.isChecked())
                                {
                                    Intent intent = new Intent(MainActivity.this,TpoActivity.class);
                                    startActivity(intent);
                                }
                                else if(studentRB.isChecked())
                                {
                                    Intent intent = new Intent(MainActivity.this,student_main.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(MainActivity.this,"Please opt one of the choice",Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.i("TAG", "signInWithEmail:failure", task.getException());
                                Toast.makeText(MainActivity.this, "Sign In failed.",Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
            }
    }
}
