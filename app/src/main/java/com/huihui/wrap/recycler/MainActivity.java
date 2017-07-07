package com.huihui.wrap.recycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WrapRecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = ((WrapRecyclerView) findViewById(R.id.recycler));


        View headView = LayoutInflater.from(this).inflate(R.layout.item_head, null);
        View footView = LayoutInflater.from(this).inflate(R.layout.item_foot, null);

        headView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        footView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        mRecyclerView.addHeadView(headView);

        mRecyclerView.addFooterView(footView);






        List<String> datas = new ArrayList<>();

        for (int i = 0; i < 30; i++) {

            datas.add("item" + i);


        }


        HuiAdapter adapter = new HuiAdapter(datas);




        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
