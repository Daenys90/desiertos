package com.example.desiertos;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.desiertos.R;
/*
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mNombre;
    private ImageView mImagen;

    public ViewHolder(View dessertfitView) {
        super(dessertfitView);
        mNombre = (TextView)
                dessertfitView.findViewById(R.id.list_item_textView);
        mImagen = (ImageView) dessertfitView.findViewById(R.id.avatar);
        dessertfitView.setOnClickListener(this);
        mNombre.setOnClickListener(this);
        mImagen.setOnClickListener(this);
    }

    public void setNombre(String text) {
        mNombre.setText(text);
    }

    public void setImagen(int image) {
        mImagen.setTag(image);
        mImagen.setImageResource(image);
    }

    @Override
    public void onClick(View v) {
        listener.onClick(this, getIdDessertFit(getAdapterPosition()));
    }
}
