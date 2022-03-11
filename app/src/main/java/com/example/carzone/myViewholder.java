package com.example.carzone;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myViewholder extends RecyclerView.ViewHolder{
    ImageView img;
    TextView t1,t2;
    public myViewholder(@NonNull View itemView) {
        super(itemView);
        img=(ImageView)itemView.findViewById(R.id.profile_pic);
        t1=(TextView)itemView.findViewById(R.id.profile_company);
        t2=(TextView)itemView.findViewById(R.id.profile_carname);
    }
}
