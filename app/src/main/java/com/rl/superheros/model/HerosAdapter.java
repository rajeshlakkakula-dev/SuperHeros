package com.rl.superheros.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rl.superheros.R;

import java.util.List;

public class HerosAdapter extends RecyclerView.Adapter<HerosAdapter.HerosViewHolder> {

    Context context;
    List<Hero> heroList;

    public HerosAdapter(Context context,List<Hero> heroList){
        this.context = context;
        this.heroList = heroList;
    }


    @Override
    public HerosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.heros_list,parent,false);

        return new HerosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HerosAdapter.HerosViewHolder holder, int position) {
        Hero hero = heroList.get(position);

        Glide.with(context)
                .load(hero.getImageUrl())
                .into(holder.imageView);
        holder.textView.setText(hero.getName());

    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public class HerosViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView  textView;
        public HerosViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);


        }



    }
}
