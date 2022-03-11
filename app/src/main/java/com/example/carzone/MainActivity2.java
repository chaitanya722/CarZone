package com.example.carzone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
RecyclerView rcv;
myadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rcv=(RecyclerView)findViewById(R.id.recview);
        //rcv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new myadapter(dataqueue(),getApplicationContext());
        rcv.setAdapter(adapter);

       // LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //rcv.setLayoutManager(layoutManager);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this,2);
        rcv.setLayoutManager(gridLayoutManager);
    }
    public ArrayList<model> dataqueue(){
        ArrayList<model>holder=new ArrayList<>();

        model ob1=new model();
        ob1.setCompany("TATA");
        ob1.setCarname("NEXON");
        ob1.setImgname(R.drawable.img);
        holder.add(ob1);


        model ob2=new model();
        ob2.setCompany("FORD");
        ob2.setCarname("FIGO");
        ob2.setImgname(R.drawable.img_1);
        holder.add(ob2);


        model ob3=new model();
        ob3.setCompany("TATA");
        ob3.setCarname("SAFARI");
        ob3.setImgname(R.drawable.img_2);
        holder.add(ob3);

        model ob4=new model();
        ob4.setCompany("MAHINDRA");
        ob4.setCarname("SCORPIO");
        ob4.setImgname(R.drawable.img_3);
        holder.add(ob4);


        model ob5=new model();
        ob5.setCompany("TOYOTA");
        ob5.setCarname("ETIOS");
        ob5.setImgname(R.drawable.img_4);
        holder.add(ob5);


        model ob6=new model();
        ob6.setCompany("KIA");
        ob6.setCarname("SELTOS");
        ob6.setImgname(R.drawable.img_5);
        holder.add(ob6);


        model ob7=new model();
        ob7.setCompany("TATA");
        ob7.setCarname("HARRIER");
        ob7.setImgname(R.drawable.img_6);
        holder.add(ob7);


        model ob8=new model();
        ob8.setCompany("FORD");
        ob8.setCarname("ENDEAVOUR");
        ob8.setImgname(R.drawable.img_7);
        holder.add(ob8);

        model ob9=new model();
        ob9.setCompany("FORD");
        ob9.setCarname("ECOSPORT");
        ob9.setImgname(R.drawable.img_8);
        holder.add(ob9);


        model ob10=new model();
        ob10.setCompany("FORD");
        ob10.setCarname("ECOSPORT");
        ob10.setImgname(R.drawable.img_9);
        holder.add(ob10);

        return holder;
    }
    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        MenuItem item=menu.findItem(R.id.search_menu);
        SearchView searchView=(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
                return super.onCreateOptionsMenu(menu);
    }


}