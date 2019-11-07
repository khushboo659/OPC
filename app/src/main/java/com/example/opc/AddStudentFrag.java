package com.example.opc;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;


public class AddStudentFrag extends Fragment {

    private Button register;
    private EditText name,id,branch,email,password;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_add_student, container, false);

        register = v.findViewById(R.id.registerStudent);
        name = v.findViewById(R.id.nameOfStudent);
        id = v.findViewById(R.id.idOfStudent);
        branch = v.findViewById(R.id.branchOfStudent);
        email = v.findViewById(R.id.emailOfStudent);
        password = v.findViewById(R.id.passOfStu);
        mAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount();
            }
        });

        return v;

    }

    public void createAccount(){
        final String myEmail = email.getText().toString();
        final String myPassword = password.getText().toString();
        if(myEmail.length()<=0 || myPassword.length()<=0)
                Toast.makeText(getContext(),"please fill required fields",Toast.LENGTH_SHORT).show();
        mAuth.createUserWithEmailAndPassword(myEmail, myPassword)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("TAG", "createUserWithEmail:success");
                            Toast.makeText(getActivity(),"Sign Up Successful",Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.i("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getActivity(), "Sign Up failed.", Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }


}
