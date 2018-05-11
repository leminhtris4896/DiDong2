package com.example.trile.egame.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trile.egame.Models.mdLearn;
import com.example.trile.egame.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by TRILE on 08/05/2018.
 */

public class AdapterLearn extends RecyclerView.Adapter<AdapterLearn.ViewHolder>{

    ArrayList<mdLearn> arrLearn;
    Context context;
    //


    public AdapterLearn(ArrayList<mdLearn> arrLearn, Context context) {
        this.arrLearn = arrLearn;
        this.context = context;
    }

    @Override
    public AdapterLearn.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.customview_learn,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AdapterLearn.ViewHolder holder, final int position) {

        Picasso.with(context).load(arrLearn.get(position).getImg()).into(holder.img);
        holder.tvEng.setText(arrLearn.get(position).getEng());
        holder.tvWrite.setText(arrLearn.get(position).getWrite());
        holder.tvViet.setText(arrLearn.get(position).getViet());
        holder.tvCau.setText(arrLearn.get(position).getCau());
        holder.imgSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(arrLearn.get(position).getMp3());
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });
                    mediaPlayer.prepare();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //

    }

    @Override
    public int getItemCount() {
        return arrLearn.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        ImageView imgSpeaker;
        TextView tvEng;
        TextView tvWrite;
        TextView tvViet;
        TextView tvCau;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imgLearn);
            imgSpeaker = (ImageView) itemView.findViewById(R.id.imgSpeaker);
            tvEng = (TextView) itemView.findViewById(R.id.tvEng);
            tvWrite = (TextView) itemView.findViewById(R.id.tvWrite);
            tvViet = (TextView) itemView.findViewById(R.id.tvViet);
            tvCau = (TextView) itemView.findViewById(R.id.tvCau);
        }
    }
}
