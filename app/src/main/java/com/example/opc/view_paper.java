package com.example.opc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class view_paper extends AppCompatActivity {

    DatabaseReference databaseReference;
    EditText ecomp,eyear;
    String scomp,syear;
    String name_pdf,com_pdf,year_pdf,url_pdf;
    Button btnshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_paper);
        ecomp=(EditText)findViewById(R.id.editcom);
        eyear=(EditText)findViewById(R.id.edityear);
        btnshow=(Button)findViewById(R.id.showbtn);
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scomp=ecomp.getText().toString();
                syear=eyear.getText().toString();
                viewPaper();
            }
        });

    }

    private void viewPaper() {

        databaseReference= FirebaseDatabase.getInstance().getReference("Papers");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                    //Log.i("valuedkfnkdnf",postSnapshot.getValue("year"));
                    uploadPDF uploadPDF = postSnapshot.getValue(com.example.opc.uploadPDF.class);
                    name_pdf=uploadPDF.getName();
                    com_pdf=uploadPDF.getCompany();
                    year_pdf=uploadPDF.getYear();
                    url_pdf=uploadPDF.getUrl();
                    Log.i("com",com_pdf);
                    Log.i("year",year_pdf);
                    Log.i("url",url_pdf);
                    if(com_pdf.equals(scomp) && year_pdf.equals(syear)){
                        Intent intent=new Intent();
                        //intent.setType(Intent.ACTION_VIEW);
                        //intent.setData(Uri.parse(uploadPDF.getUrl()));

                        intent.setDataAndType(Uri.parse(uploadPDF.getUrl()),Intent.ACTION_VIEW);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            Log.i("valuedkfnkdnf","dg");

        }
        });
    }
}
