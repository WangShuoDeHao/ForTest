package com.software;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicButtonAdapter extends RecyclerView.Adapter<MusicButtonAdapter.ViewHolder> {
    private List<MusicButtons> musicButtonsList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        Button musicImage;
        public ViewHolder(View view){
            super(view);
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
        ViewHolder holder=new ViewHolder(view);
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
