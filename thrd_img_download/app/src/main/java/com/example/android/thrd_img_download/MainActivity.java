package com.example.android.thrd_img_download;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



}

private class DownloadFilesTask extends AsyncTask<URL,Integer,Long>
{
protected Long doInBackground(URL...urls){
    int count=urls.length;
    long totalSize=0;
    for(int i=0;i<count;++i) {
        totalSize += Downloader.downloadFile(urls[i]);
        publishProgress((int) ((i / (float) count) * 100));
        if (isCancelled()) break;
    }
    return totalSize;
    }


protected void onProgressUpdate(Integer...progress){
    setProgressPercent(progress[0]);
}

