package com.example.opc.ui.gallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.opc.AccountActivity;
import com.example.opc.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    Activity context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        context=getActivity();
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
    public void onStart(){
        super.onStart();
               Intent intent=new Intent(context, AccountActivity.class);
                //add data to the Intent object
                /*intent.putExtra("text", et.getText().toString());*/
                //start the second activity
                startActivity(intent);
            }


        /*Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);*/

}