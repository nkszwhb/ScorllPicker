package com.scrollpicker.android.demo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.scrollpicker.android.R;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        TextView defaultScrollPickerTv = findViewById(R.id.default_scroll_picker_tv);
        TextView customScrollPickerTv = findViewById(R.id.custom_scroll_picker_tv);

        defaultScrollPickerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.scrollpicker.android.demo.sample1.SampleActivity.class);
                startActivity(intent);
            }
        });

        customScrollPickerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.scrollpicker.android.demo.sample2.SampleActivity.class);
                startActivity(intent);
            }
        });
    }
}
