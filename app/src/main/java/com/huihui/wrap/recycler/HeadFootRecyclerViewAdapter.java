package com.huihui.wrap.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by gavin
 * Time 2017/7/6  15:55
 * Email:molu_clown@163.com
 */

public class HeadFootRecyclerViewAdapter extends RecyclerView.Adapter {


    private ArrayList<View> mHeaderViewInfos = new ArrayList<>();
    private ArrayList<View> mFooterViewInfos = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;

    public static int TYPE_HEAD = -1;
    public static int TYPE_CONTENT = 1;
    public static int TYPE_FOOT = -2;


    public HeadFootRecyclerViewAdapter(ArrayList<View> mHeaderViewInfos, ArrayList<View> mFooterViewInfos, RecyclerView.Adapter mAdapter) {

        this.mAdapter = mAdapter;

        if (mHeaderViewInfos == null) {

            mHeaderViewInfos = new ArrayList<>();

        } else {

            this.mHeaderViewInfos = mHeaderViewInfos;
        }


        if (mFooterViewInfos == null) {

            mFooterViewInfos = new ArrayList<>();
        } else {

            this.mFooterViewInfos = mFooterViewInfos;
        }

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEAD) {

            return new HeaderViewHolder(mHeaderViewInfos.get(0));
        }

        if (viewType == TYPE_FOOT) {

            return new FooterViewHolder(mFooterViewInfos.get(0));
        }
        return mAdapter.onCreateViewHolder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int itemViewType = holder.getItemViewType();

        if (itemViewType==TYPE_HEAD || itemViewType==TYPE_FOOT){
            return;
        }else {

            mAdapter.onBindViewHolder(holder,position - mHeaderViewInfos.size());
        }


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    private static class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View view) {
            super(view);
        }
    }
}
