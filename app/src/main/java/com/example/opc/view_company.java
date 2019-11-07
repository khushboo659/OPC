package com.example.opc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class view_company extends AppCompatActivity {
    ListView mycomView;
    DatabaseReference databaseReference;
    List<uploadJAF> jafs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_company);

        mycomView=(ListView)findViewById(R.id.clist);
        jafs=new ArrayList<>();

        viewAllCom();

        mycomView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                uploadJAF j = jafs.get(i);
                Gson gson=new Gson();
                String myJson = gson.toJson(j);
                Intent intent=new Intent(view_company.this,company_details.class);
                intent.putExtra("myjson",myJson);
                startActivity(intent);

            }
        });
    }

    private void viewAllCom(){
        databaseReference= FirebaseDatabase.getInstance().getReference("Company");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    uploadJAF JAF = postSnapshot.getValue(com.example.opc.uploadJAF.class);
                    jafs.add(JAF);
                }
                String[] comps=new String[jafs.size()];
                for(int i=0;i<comps.length;i++){
                    comps[i]=jafs.get(i).getName();
                }

                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,comps);
                mycomView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
