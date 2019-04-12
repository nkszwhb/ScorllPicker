package com.scrollpicker.android.demo.sample2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.scrollpicker.android.R;
import com.scrollpicker.android.scrollpickerlibrary.adapter.ScrollPickerAdapter;
import com.scrollpicker.android.scrollpickerlibrary.view.ScrollPickerView;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.List;

public class SampleActivity extends AppCompatActivity {
    private ScrollPickerView mScrollPickerView;
    private Button select_2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample2);
        initView();
        initData();
    }


    private void initView() {
        mScrollPickerView = findViewById(R.id.scroll_picker_view);
        mScrollPickerView.setLayoutManager(new LinearLayoutManager(this));
        select_2 = (Button)findViewById(R.id.select_2);
    }

    private void initData() {
        final List<MyData> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MyData myData = new MyData();
            myData.id = i;
            myData.text = "我是第" + i + "个item";
            list.add(myData);
        }

        ScrollPickerAdapter.ScrollPickerAdapterBuilder<MyData> builder =
                new ScrollPickerAdapter.ScrollPickerAdapterBuilder<MyData>(this)
                        .setDataList(list)
                        .selectedItemOffset(2)
                        .visibleItemNumber(5)
                        .setDivideLineColor("#ED5275")
                        .setItemViewProvider(new MyViewProvider())
                        .setOnClickListener(new ScrollPickerAdapter.OnClickListener() {
                            @Override
                            public void onSelectedItemClicked(View v) {
                                MyData myData = (MyData) v.getTag();
                                if (myData != null) {
                                    Toast.makeText(SampleActivity.this, "id: " + myData.id + " text:" + myData.text, Toast.LENGTH_SHORT).show();
                                    Log.d("SampleActivity_2",v.getId()+"");
                                }
                            }
                        });
        final ScrollPickerAdapter mScrollPickerAdapter = builder.build();
        mScrollPickerView.setAdapter(mScrollPickerAdapter);
        select_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MyData myData = (MyData) findViewById(mScrollPickerAdapter.getPositionID()).getTag();
//                Toast.makeText(SampleActivity.this,"id: " + myData.id + " text:" + myData.text,Toast.LENGTH_SHORT).show();
                MyData myData = (MyData) mScrollPickerAdapter.getPositionItemView().getTag();
                Log.d("SampleActivity","id: " + myData.id + " text:" + myData.text);
            }
        });
    }
}