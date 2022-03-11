package com.example.carzone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
ImageView img;
TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        img=(ImageView)findViewById(R.id.profile_pic);
        t1=(TextView)findViewById(R.id.profile_carname);
        t2=(TextView)findViewById(R.id.profile_company);

        img.setImageResource(getIntent().getIntExtra("imgname",0));
        t1.setText(getIntent().getStringExtra("company"));
        t2.setText(getIntent().getStringExtra("carname"));
    }
}