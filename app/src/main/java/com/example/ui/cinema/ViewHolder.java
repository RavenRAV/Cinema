package com.example.ui.cinema;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.data.entity.Movies;

class ViewHolder extends RecyclerView.ViewHolder {
    private TextView title, year, genre, plot;
    private ImageView imageView;

    ViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.rvTitle);
        year = itemView.findViewById(R.id.rvYear);
        genre = itemView.findViewById(R.id.rvGenre);
        plot = itemView.findViewById(R.id.rvPlot);
        imageView = itemView.findViewById(R.id.imageM);
    }

    void fillViews(Movies movies) {
        title.setText(movies.getTitle());
        year.setText("year: "+movies.getYear());
        genre.setText("genre: "+movies.getGenre());
        plot.setText(movies.getPlot());
        Glide.with(imageView).load(movies.getPoster()).into(imageView);
    }
}
