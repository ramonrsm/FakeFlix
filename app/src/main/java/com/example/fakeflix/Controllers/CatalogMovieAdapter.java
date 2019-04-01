package com.example.fakeflix.Controllers;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.fakeflix.Models.Entities.Movie;
import com.example.fakeflix.R;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CatalogMovieAdapter extends RecyclerView.Adapter<CatalogMovieAdapter.ItemViewHolder>{

    private RecyclerViewOnClickListener mRecyclerViewOnClickListener;
    private List<Movie> movieList;

    public CatalogMovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        //Movie movie = movieList.get(position);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener recyclerView){
        mRecyclerViewOnClickListener = recyclerView;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageViewFetureImage;

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewFetureImage = itemView.findViewById(R.id.featureImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mRecyclerViewOnClickListener != null){

                Movie movie = movieList.get(getLayoutPosition());

                mRecyclerViewOnClickListener.onClickListener(view, movie.getId(), movie.getCategory());
            }
        }
    }
}
