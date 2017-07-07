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
    public static int TYPE_HEAD = RecyclerView.INVALID_TYPE;
    public static int TYPE_FOOT = RecyclerView.INVALID_TYPE-1;
    public HeadFootRecyclerViewAdapter(ArrayList<View> mHeaderViewInfos, ArrayList<View> mFooterViewInfos, RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
        if (mHeaderViewInfos == null) {
            this.mHeaderViewInfos = new ArrayList<>();
        } else {
            this.mHeaderViewInfos = mHeaderViewInfos;
        }

        if (mFooterViewInfos == null) {
            this.mFooterViewInfos = new ArrayList<>();
        } else {
            this.mFooterViewInfos = mFooterViewInfos;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD) {
            return new HeaderViewHolder(mHeaderViewInfos.get(0));
        }else if (viewType == TYPE_FOOT) {
            return new FooterViewHolder(mFooterViewInfos.get(0));
        }
        return mAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public int getItemViewType(int position) {

        int headNum = mHeaderViewInfos.size();
        if (headNum > position) {
            return TYPE_HEAD;
        }
        final int adjPosition = position - headNum;
        int adapterCount = 0;
        if (mAdapter != null) {
            adapterCount = mAdapter.getItemCount();
            if (adapterCount > adjPosition) {

                return mAdapter.getItemViewType(adjPosition);
            }
        }
        return TYPE_FOOT;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int itemViewType = getItemViewType(position);
        if (itemViewType == TYPE_HEAD) {
            return;
        } else if (itemViewType==TYPE_FOOT){

            return;
        }else {
            mAdapter.onBindViewHolder(holder, position - mHeaderViewInfos.size());
        }
    }

    @Override
    public int getItemCount() {
        return mAdapter == null ? mFooterViewInfos.size() + mHeaderViewInfos.size() :
                mAdapter.getItemCount() + mFooterViewInfos.size() + mHeaderViewInfos.size();
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
