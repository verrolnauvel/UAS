package com.example.ramadhan.jadwalimsak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.example.ramadhan.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


public class MainAdapter extends RecyclerView.Adapter<MainHolder> {

    private Context mContext;
    private List<ModelMain> items;
    private MainAdapter.onSelectData onSelectData;

    public interface onSelectData {
        void onSelected(ModelMain modelMain);
    }

    public MainAdapter(Context context, List<ModelMain> items, MainAdapter.onSelectData xSelectData) {
        this.mContext = context;
        this.items = items;
        this.onSelectData = xSelectData;
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_jadwal, parent, false);
        return new MainHolder(v);
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
        final ModelMain data = items.get(position);

        holder.tvDateMasehi.setText(data.txtDate);
        holder.tvDateHijri.setText(data.txtDay);
        holder.rlPrayList.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim));
        holder.rlPrayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectData.onSelected(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
