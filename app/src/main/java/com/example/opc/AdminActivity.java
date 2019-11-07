package com.example.opc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

//
public class AdminActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void changeFragment(View view)
    {
        Fragment fragment;

        if(view==findViewById(R.id.addTpo))
        {
            fragment = new addTpo();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.addfrag,fragment);
            ft.commit();
        }

        if(view==findViewById(R.id.addStudent))
        {
            fragment = new AddStudentFrag();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.addfrag,fragment);
            ft.commit();
        }
    }
}
