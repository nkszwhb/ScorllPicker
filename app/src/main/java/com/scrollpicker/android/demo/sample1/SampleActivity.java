package com.scrollpicker.android.demo.sample1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.scrollpicker.android.R;
import com.scrollpicker.android.scrollpickerlibrary.adapter.ScrollPickerAdapter;
import com.scrollpicker.android.scrollpickerlibrary.view.ScrollPickerView;

import java.util.ArrayList;
import java.util.List;

public class SampleActivity extends AppCompatActivity {
    private ScrollPickerView mScrollPickerView;
    private Button select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample1);
        initView();
        initData();
    }

    private void initView() {
        mScrollPickerView = findViewById(R.id.scroll_picker_view);
        select = (Button)findViewById(R.id.select);
        mScrollPickerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String itemData = "item: " + i;
            list.add(itemData);
        }
        ScrollPickerAdapter.ScrollPickerAdapterBuilder<String> builder =
                new ScrollPickerAdapter.ScrollPickerAdapterBuilder<String>(this)
                        .setDataList(list)
                        .selectedItemOffset(1)
                        .visibleItemNumber(3)
                        .setDivideLineColor("#E5E5E5")
                        .setItemViewProvider(null)
                        .setOnClickListener(new ScrollPickerAdapter.OnClickListener() {
                            @Override
                            public void onSelectedItemClicked(View v) {
                                String text = (String) v.getTag();
                                if (text != null) {
                                    Toast.makeText(SampleActivity.this, text, Toast.LENGTH_SHORT).show();
//                                    Log.d("SampleActivity_1  ",v.getId()+"");
                                }
                            }
                        });
        final ScrollPickerAdapter mScrollPickerAdapter = builder.build();
        mScrollPickerView.setAdapter(mScrollPickerAdapter);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String text = (String) findViewById(mScrollPickerAdapter.getPositionID()).getTag();
//                Toast.makeText(SampleActivity.this,text,Toast.LENGTH_SHORT).show();
                String text = (String) mScrollPickerAdapter.getPositionItemView().getTag();
                Log.d("SampleActivity",text);
            }
        });
    }
}