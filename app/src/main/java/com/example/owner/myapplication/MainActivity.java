package com.example.owner.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;




import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


import com.bumptech.glide.Glide;

import java.util.concurrent.ExecutionException;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements Callback<JsonElement> {

    GridView gridView;
    Button ImagesBtn;
    ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.grid_view);
        adapter = new ImageAdapter(this);
        gridView.setAdapter(adapter);

        ImagesBtn = findViewById(R.id.images_btn);

        ImagesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayImages(v);
            }
        });
    }


        @Override
        protected void onPostExecute(Integer integer) {
            adapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Images Loaded", Toast.LENGTH_LONG).show();
        }
    }
}