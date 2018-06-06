package com.thecoolguy.rumaan.fileio.ui;

import android.app.Application;
import cat.ereza.customactivityoncrash.config.CaocConfig;
import com.thecoolguy.rumaan.fileio.repository.Repository;
import com.thecoolguy.rumaan.fileio.ui.activities.ErrorActivity;


/**
 * Base Application class
 */

public class FileioApplication extends Application {

  private static final String TAG = "FileioApplication";

  @Override
  public void onCreate() {
    super.onCreate();

    // Custom Activity on Crash
    CaocConfig.Builder.create()
        .errorActivity(ErrorActivity.class)
        .apply();

    // Set the application context in the repository
    Repository.applicationContext = this;

    /*Intent intent = new Intent(this, UploadService.class);
    bindService(intent, new ServiceConnection() {
      @Override
      public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i(TAG, "onServiceConnected: Connected");
      }

      @Override
      public void onServiceDisconnected(ComponentName componentName) {
        Log.i(TAG, "onServiceDisconnected: Disconnected");
      }
    }, Context.BIND_AUTO_CREATE);*/
  }


}
