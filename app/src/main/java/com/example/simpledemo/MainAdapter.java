package com.example.simpledemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private Context context;
    private List<BaseLineareLayout> data = new ArrayList<>();
    private HashMap map = new HashMap<LinearLayout, CardView>();

    public MainAdapter(Context context) {
        this.context = context;
        data.addAll(BaseLineareLayout.list);
    }

    void refresh(){
        for (BaseLineareLayout b:data) {
            b.refresh();
        }
    }


    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MainHolder(context, LayoutInflater.from(context).inflate(R.layout.mineitem, viewGroup, false),viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder mainHolder, int i) {
        mainHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MainHolder extends RecyclerView.ViewHolder{

        private CardView v;
        private ViewGroup vp;

        public MainHolder(Context context,@NonNull View v,ViewGroup vp) {
            super(v);
            this.v = (CardView) v;
            this.vp = vp;
        }

        private void bind(int position){
            if (map.containsKey(data.get(position))){
                CardView cardView = (CardView)map.get(data.get(position));
                Objects.requireNonNull
                        (cardView).removeAllViews();
                map.remove(data.get(position));
            }
            v.removeAllViews();
            v.addView(data.get(position));
            map.put(data.get(position), v);
        }

    }

}
