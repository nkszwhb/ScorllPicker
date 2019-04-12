package com.scrollpicker.android.demo.sample2;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.scrollpicker.android.R;
import com.scrollpicker.android.scrollpickerlibrary.IViewProvider;

public class MyViewProvider implements IViewProvider<MyData> {
    @Override
    public int resLayout() {
        return R.layout.my_scroll_picker_item_layout;
    }

    @Override
    public void onBindView(@NonNull View view, @Nullable MyData itemData) {
        TextView tv = view.findViewById(R.id.tv_content);
        tv.setText(itemData == null ? null : itemData.text);
        view.setTag(itemData);
    }

    @Override
    public void updateView(@NonNull View itemView, boolean isSelected) {
        TextView tv = itemView.findViewById(R.id.tv_content);
        tv.setTextColor(Color.parseColor(isSelected ? "#589AAA" : "#342434"));
    }
}
