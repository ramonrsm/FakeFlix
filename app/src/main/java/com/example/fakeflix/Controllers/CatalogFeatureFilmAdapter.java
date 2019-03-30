package com.example.fakeflix.Controllers;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.fakeflix.Models.Entities.FeatureFilm;
import com.example.fakeflix.R;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CatalogFeatureFilmAdapter extends RecyclerView.Adapter<CatalogFeatureFilmAdapter.ItemViewHolder> {

    private RecyclerViewOnClickListener mRecyclerViewOnClickListener;
    private List<FeatureFilm> featureFilmList;

    public CatalogFeatureFilmAdapter(List<FeatureFilm> featureFilmList) {
        this.featureFilmList = featureFilmList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        FeatureFilm featureFilm = featureFilmList.get(position);
        holder.featureFilm = featureFilm;
        holder.image = featureFilm.getFeatureImage();
        holder.setFeatureImage();
    }

    @Override
    public int getItemCount() {
        return featureFilmList.size();
    }

    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener r){
        mRecyclerViewOnClickListener = r;
    }


    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView   featureImage;
        Drawable    image;
        FeatureFilm featureFilm;

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            featureImage = itemView.findViewById(R.id.featureImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mRecyclerViewOnClickListener != null){
                mRecyclerViewOnClickListener.onClickListener(view, getLayoutPosition());
            }
        }

        private void setFeatureImage(){
            featureImage.setImageDrawable(image);
        }
    }
}
