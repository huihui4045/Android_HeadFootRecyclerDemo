package com.huihui.wrap.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gavin
 * Time 2017/7/7  15:21
 * Email:molu_clown@163.com
 */

public class HuiAdapter extends RecyclerView.Adapter<HuiAdapter.ViewHolder> {

    private List<String> datas;


    public HuiAdapter(List<String> datas) {
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyler, parent, false);


        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.name);
        }
    }

    public interface OnItemClickListener<T> {

        void onItemClick(T t, View view, int position);
    }


}
