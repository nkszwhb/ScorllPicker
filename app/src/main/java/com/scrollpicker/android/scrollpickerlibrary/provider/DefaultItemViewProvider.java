package com.scrollpicker.android.scrollpickerlibrary.provider;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.scrollpicker.android.R;
import com.scrollpicker.android.scrollpickerlibrary.IViewProvider;

public class DefaultItemViewProvider implements IViewProvider<String> {
//    private int positionID;
//
//    public int getPositionID() {
//        return positionID;
//    }

    @Override
    public int resLayout() {
        return R.layout.scroll_picker_default_item_layout;
    }

    @Override
    public void onBindView(View view,String text) {
        TextView tv = view.findViewById(R.id.tv_content);
        tv.setText(text);
        view.setTag(text);
        tv.setTextSize(18);
    }

    @Override
    public void updateView(View itemView, boolean isSelected) {
        TextView tv = itemView.findViewById(R.id.tv_content);
        tv.setTextSize(isSelected ? 18 : 14);
        tv.setTextColor(Color.parseColor(isSelected ? "#ED5275" : "#000000"));
//        if (isSelected){
//            positionID = tv.getId();
//        }
    }
}
