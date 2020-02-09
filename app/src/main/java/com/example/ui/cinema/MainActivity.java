package com.example.ui.cinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.data.entity.Movies;
import com.example.data.entity.MoviesList;
import com.example.data.internet.RetrofitBuilder;
import com.example.data.internet.RetrofitService;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText etTitle;
    Button go;
    RecyclerView recyclerView;
    Adapter adapter;
    Movies movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setupRV();
        initListeners();
    }

    private void initViews() {
        etTitle = findViewById(R.id.etTitle);
        go = findViewById(R.id.go);
        recyclerView = findViewById(R.id.recyclerV);
    }

    private void setupRV() {
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
    }

    private void initListeners() {
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie(etTitle.getText().toString().trim());
            }
        });
    }

    private void movie(String title) {
        RetrofitBuilder
                .getRetrofitService()
                .movies(title, "9cd316fa")
                .enqueue(new Callback<Movies>() {
                    @Override
                    public void onResponse(Call<Movies> call, Response<Movies> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            adapter.update(response.body());
                            Log.d("gyjghjhgj", "onResponse: ");
                        } else {
                            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Movies> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                    }
                });

    }

    private void fillviews(Movies movies) {

    }
}
