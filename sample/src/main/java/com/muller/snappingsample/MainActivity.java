package com.muller.snappingsample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private SnappingRecyclerView mSnappingRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSnappingRecyclerView = (SnappingRecyclerView)findViewById(android.R.id.list);
        mSnappingRecyclerView.enableViewScaling(true);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SampleAdapter sampleAdapter = new SampleAdapter(getSampleList());
        mSnappingRecyclerView.setAdapter(sampleAdapter);
    }

    private List<String> getSampleList() {
        List<String> sampleList = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            sampleList.add(i + "");
        }

        return sampleList;
    }
}
