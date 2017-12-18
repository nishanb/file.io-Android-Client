package com.thecoolguy.rumaan.fileio;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.thecoolguy.rumaan.fileio.adapters.UploadHistoryListAdapter;
import com.thecoolguy.rumaan.fileio.data.UploadItem;
import com.thecoolguy.rumaan.fileio.data.UploadItemViewModel;

import java.util.List;

public class UploadHistoryActivity extends AppCompatActivity {

    private UploadItemViewModel uploadItemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_history);

        RecyclerView recyclerView = findViewById(R.id.list);
        final UploadHistoryListAdapter uploadHistoryListAdapter = new UploadHistoryListAdapter(this);
        recyclerView.setAdapter(uploadHistoryListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        uploadItemViewModel = ViewModelProviders.of(this).get(UploadItemViewModel.class);
        uploadItemViewModel.getUploadHistoryList().observe(this, new Observer<List<UploadItem>>() {
            @Override
            public void onChanged(@Nullable List<UploadItem> uploadItems) {
                uploadHistoryListAdapter.setUploadItemList(uploadItems);
            }
        });


        // TODO: insert
        uploadItemViewModel.insert(new UploadItem("test", "http://test.com"));
    }
}
