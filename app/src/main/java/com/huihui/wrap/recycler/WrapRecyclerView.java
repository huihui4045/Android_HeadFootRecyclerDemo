package com.huihui.wrap.recycler;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by gavin
 * Time 2017/7/7  15:45
 * Email:molu_clown@163.com
 */

public class WrapRecyclerView extends RecyclerView {

    private ArrayList<View> mHeaderViewInfos = new ArrayList<>();
    private ArrayList<View> mFooterViewInfos = new ArrayList<>();
    private Adapter mAdapter;


    public WrapRecyclerView(Context context) {
        super(context);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public void addHeadView(View view){

        mHeaderViewInfos.add(view);


        /*if (mAdapter!=null){

            if (mAdapter instanceof HeadFootRecyclerViewAdapter){

                mAdapter=new HeadFootRecyclerViewAdapter(mHeaderViewInfos,mFooterViewInfos,mAdapter);
            }
        }*/
    }

    public void addFooterView(View v) {
        mFooterViewInfos.add(v);

        /*if (mAdapter != null) {
            if (mAdapter instanceof HeadFootRecyclerViewAdapter) {
                mAdapter = new HeadFootRecyclerViewAdapter(mHeaderViewInfos, mFooterViewInfos, mAdapter);
            }
        }*/
    }



    @Override
    public void setAdapter(Adapter adapter) {

        if (mHeaderViewInfos.size()>0 ||mFooterViewInfos.size()>0){

            mAdapter=new HeadFootRecyclerViewAdapter(mHeaderViewInfos,mFooterViewInfos,adapter);
        }else {

            mAdapter=adapter;
        }


        super.setAdapter(mAdapter);
    }
}
