package com.example.desiertos;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toolbar;

import com.example.desiertos.adapter.DessertFitAdapter;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class MainActivity extends AppCompatActivity implements DessertFitAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private DessertFitAdapter mAdapter;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mAdapter = new DessertFitAdapter(this, DessertFitness.getDessertFitness(), this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onClick(DessertFitAdapter.ViewHolder viewHolder, int
            idDessertFit) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.ID_DESSERTFIT, idDessertFit);
        startActivity(intent);
    }
}