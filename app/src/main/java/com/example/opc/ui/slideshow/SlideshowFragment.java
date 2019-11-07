package com.example.opc.ui.slideshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.opc.AccountActivity;
import com.example.opc.R;
import com.example.opc.view_paper;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    Activity context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        context=getActivity();
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
    public void onStart(){
        super.onStart();
        Intent intent=new Intent(context, view_paper.class);
        //add data to the Intent object
        /*intent.putExtra("text", et.getText().toString());*/
        //start the second activity
        startActivity(intent);
    }
}