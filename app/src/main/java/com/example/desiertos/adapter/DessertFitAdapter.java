package com.example.desiertos.adapter;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desiertos.DessertFitness;
import com.example.desiertos.OnItemClickListener;
import com.example.desiertos.R;
import com.example.desiertos.pojo.DessertFit;

import org.w3c.dom.Text;

import java.time.Instant;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.List;

public class DessertFitAdapter extends
        RecyclerView.Adapter<DessertFitAdapter.ViewHolder>{
    private LayoutInflater mLayoutInflater;
    private List<DessertFit> mDessertFit = new ArrayList<>();
    private Context mContext;
    private OnItemClickListener listener;
    private Instant Glide;

    public interface OnItemClickListener{
        public void onClick(DessertFitAdapter.ViewHolder viewHolder, int
                idDessertFit);
    }
    public DessertFitAdapter(Context context, List<DessertFit> dessertFits,
                             OnItemClickListener listener){
        mContext = context;
        mLayoutInflater = mLayoutInflater.from(context);
        mDessertFit = dessertFits;
        this.listener = listener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener{
        private TextView mNombre;
        private ImageView mImagen;
        public ViewHolder(View dessertfitView){
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
    private int getIdDessertFit(int position){
        if (position != RecyclerView.NO_POSITION){
            return mDessertFit.get(position).getId();
        } else {
            return -1;
        }
    }
    @Override
    public int getItemCount() {
        return DessertFitness.getDessertFitness().size();
    }
    public void addAll( List<DessertFit> list){
        mDessertFit.addAll(list);
        Log.d("DesertFit", "New Desert" + this.mDessertFit.size());
        notifyDataSetChanged();
    }
    public void add(DessertFit dessertFit){
        mDessertFit.add(dessertFit);
        notifyItemInserted(mDessertFit.indexOf(dessertFit));
        notifyDataSetChanged();
    }
    public void remove(DessertFit dessertFit){
        int position = mDessertFit.indexOf(dessertFit);
        if (position != -1){
            mDessertFit.remove(position);
            notifyItemRemoved(position);
            notifyDataSetChanged();
        }
    }
    public void clear(){
        mDessertFit.clear();
        notifyDataSetChanged();
    }
    public List<DessertFit> getItem() {
        return mDessertFit;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View mdessertfitView;
        mdessertfitView = mLayoutInflater.inflate(R.layout.item_list_dessert,
                viewGroup, false);
        return new ViewHolder(mdessertfitView);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        DessertFit dessertFit = mDessertFit.get(i);
        viewHolder.mNombre.setText(dessertFit.getNombre());
        Glide.with((TemporalAdjuster) viewHolder.mImagen.getContext())
                .load(dessertFit.getImagen())
                .centerCrop()
                .into(viewHolder.mImagen);
    }
}












