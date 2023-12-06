package com.software;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//Created by ws Home_Fragment 的RecycleView的适配器
public class MusicButtonAdapter extends RecyclerView.Adapter<MusicButtonAdapter.ViewHolder> {
    private List<MusicButtons> musicButtonsList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View buttonsView;
        Button musicImage;
        public ViewHolder(View view){
            super(view);
            buttonsView = view;
            musicImage =(Button) view.findViewById(R.id.MusicButton_image) ;
        }
    }
    public MusicButtonAdapter(List<MusicButtons> List){
        musicButtonsList =List;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_buttons_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.buttonsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int possition = holder.getAdapterPosition();
                MusicButtons musicButtons = musicButtonsList.get(possition);
                Toast.makeText(v.getContext(), "你点击了view"+musicButtons.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.musicImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                MusicButtons musicButtons =musicButtonsList.get(position);
                Toast.makeText(v.getContext(), "你点击了图片"+musicButtons.getName(),Toast.LENGTH_SHORT).show();
                Intent intent =new Intent();
                intent.setClass(v.getContext(),InstrumentDetailsActivity.class);
                intent.putExtra(""+musicButtons.getName(),"0");
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MusicButtonAdapter.ViewHolder holder, int position) {
        MusicButtons musicButtons = musicButtonsList.get(position);
        holder.musicImage.setText(musicButtons.getName());
    }

    @Override
    public int getItemCount() {
        return musicButtonsList.size();
    }
}
