package com.example.country.views.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.country.R;
import com.example.country.model.Row;

import java.util.ArrayList;
import java.util.List;

public class FactsAdapter extends RecyclerView.Adapter<FactsAdapter.FactsViewHolder> {
    private Context context;
    private List<Row>mFactsList = new ArrayList<>();


    class FactsViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtTitle,txtDescption;
        ImageView imgRefrence;

        FactsViewHolder(View itemView)
        {
            super(itemView);
            txtTitle = (TextView)itemView.findViewById(R.id.text_title);
            txtDescption = (TextView)itemView.findViewById(R.id.text_desc);
            imgRefrence = (ImageView)itemView.findViewById(R.id.ref_img);

        }

    }

    public FactsAdapter(Context context, List<Row>factsList)
    {
        this.context = context;
        this.mFactsList = factsList;

    }


    @NonNull
    @Override
    public FactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_facts,parent,false);
        return new FactsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FactsViewHolder holder, int position) {
            holder.txtTitle.setText(mFactsList.get(position).getTitle());
            holder.txtDescption.setText(mFactsList.get(position).getDescription());
            Glide.with(context).load(mFactsList.get(position).getImageHref()).into(holder.imgRefrence);
    }

    @Override
    public int getItemCount() {
        return mFactsList.size();
    }


}
