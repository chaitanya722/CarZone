package com.example.carzone;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class myadapter extends RecyclerView.Adapter<myViewholder>implements Filterable {
    ArrayList<model> data;
    ArrayList<model> backup;
    Context context;

    public myadapter(ArrayList<model> data, Context context) {
        this.data = data;
        this.context = context;
        backup = new ArrayList<>(data);
    }


    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singlerow, parent, false);
        return new myViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewholder holder, int position) {
        final model temp = data.get(position);
        holder.t1.setText(data.get(position).getCompany());
        holder.t2.setText(data.get(position).getCarname());
        holder.img.setImageResource(data.get(position).getImgname());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity3.class);
                intent.putExtra("imgname", temp.getImgname());
                intent.putExtra("company", temp.getCarname());
                intent.putExtra("carname", temp.getCompany());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Filter getFilter() {

        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {
            ArrayList<model> filtereddata = new ArrayList<>();
            if (keyword.toString().isEmpty())
                filtereddata.addAll(backup);
            else {
                for (model obj : backup) {

                    if (obj.getCompany().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                        filtereddata.add(obj);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filtereddata;
            return results;
        }


        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            data.clear();
            data.addAll((ArrayList<model>)results.values);
            notifyDataSetChanged();
        }
    };
}
