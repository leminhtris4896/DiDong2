package com.example.trile.egame.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trile.egame.Models.mdUsers;
import com.example.trile.egame.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by TRILE on 06/04/2018.
 */

public class AdapterTop extends RecyclerView.Adapter<AdapterTop.ViewHolder> {

    ArrayList<mdUsers> arrTop;
    Context context;

    public AdapterTop(ArrayList<mdUsers> arrTop, Context context) {
        this.arrTop = arrTop;
        this.context = context;
    }

    @Override
    public AdapterTop.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.customview_top,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterTop.ViewHolder holder, int position) {
        Picasso.with(context).load(arrTop.get(position).getImg()).into(holder.imgUser);
        holder.tvNameUser.setText(arrTop.get(position).getName());
        holder.tvCoreUser.setText(arrTop.get(position).getPoint() + "");
    }

    @Override
    public int getItemCount() {
        return arrTop.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgUser;
        TextView tvNameUser;
        TextView tvCoreUser;

        public ViewHolder(View itemView) {
            super(itemView);
            imgUser = (ImageView) itemView.findViewById(R.id.imgUser);
            tvNameUser = (TextView) itemView.findViewById(R.id.tvNameUser);
            tvCoreUser = (TextView) itemView.findViewById(R.id.tvCoreUser);
        }
    }
}
