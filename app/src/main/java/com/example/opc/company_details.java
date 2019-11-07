package com.example.opc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class company_details extends AppCompatActivity {


    uploadJAF uj;
    String dname,dstipend,dprofile,dlink,djaf;
    ListView l;
    Gson gson;
    List<String> itemlist;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);

        l=(ListView)findViewById(R.id.delist);
        showDetails();
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                if(i==3){
                    intent.setDataAndType(Uri.parse(dlink),Intent.ACTION_VIEW);
                    startActivity(intent);
                }
                else if(i==4){
                    intent.setDataAndType(Uri.parse(djaf),Intent.ACTION_VIEW);
                    startActivity(intent);
                }

            }
        });


    }

    private void showDetails() {
        gson = new Gson();
        uj = gson.fromJson(getIntent().getStringExtra("myjson"), uploadJAF.class);
        dname=uj.getName();
        dstipend=uj.getStipend();
        dprofile=uj.getProfile();
        dlink=uj.getLink();
        djaf=uj.getJaf();

        itemlist=new ArrayList<>();
        itemlist.clear();;
        itemlist.add("Company Name - "+dname);
        itemlist.add("Stipend - "+dstipend);
        itemlist.add("Job Profile - "+dprofile);
        itemlist.add("Google form link - "+dlink);
        itemlist.add("Jaf attached - "+djaf);

        adapter=new ArrayAdapter<>(company_details.this,android.R.layout.simple_list_item_1,itemlist);
        l.setAdapter(adapter);
    }
}
