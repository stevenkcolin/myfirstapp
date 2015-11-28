package com.stevenkcolin.fourthapp;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickBtn_1(View view)
    {
        // FIXME: 11/14/15 添加保存到文件的代码
        System.err.println("click btn1");
        String filename = "fourthapp.txt";
        File file = _getTempFile(this, filename);


        Log.e("steve", "onClickBtn_1 hahaha");
        Log.e("steve", file.getPath().toString());
    }
    
    public void onClickBtn_2(View view)
    {
        // FIXME: 11/14/15
        // TODO: 11/14/15 add code to save to external file
        Log.e("steve", "onClickBtn_2 add code to save to external file");
        // Read the environment file where the external file is readable and writable.
        Log.e("steve", "onClickBtn_2 external file readable is: "+_isExternalStorageReadable());
        Log.e("steve", "onClickBtn_2 external file writeable is: "+_isExternalStorageWritable());
        //create a file under the individual external storage directory.
        _getAlbumStorageDir("steve2");
        //create a file under the public external storage directory.
        _getPublicAlbumStorageDir("steve2");

    }

    private File _getAlbumStorageDir(String albumName){
        File file = new File(Environment.getExternalStorageDirectory(), albumName);
        if (!file.mkdirs())
        {
            Log.e("steve", "_getAlbumStorageDir Directory not created");
        }
        else
        {
            Log.e("steve", "_getAlbumStorageDir Director is created under the path"+file.getPath().toString());
        }

        return file;
    }
    private File _getPublicAlbumStorageDir(String albumName){
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs())
        {
            Log.e("steve", "_getPublicAlbumStorageDir Directory not created");
        }
        else
        {
            Log.e("steve", "_getPublicAlbumStorageDir Director is created under the path"+file.getPath().toString());
        }

        return file;
    }

    private boolean _isExternalStorageWritable()
    {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state))
        {
            return true;
        }
        return false;
    }

    private boolean _isExternalStorageReadable()
    {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))
        {
            return true;
        }
        return false;
    }

    private File _getTempFile(Context context,String url)
    {
        File file;

        try {
            String filename = Uri.parse(url).getLastPathSegment();
            file = File.createTempFile(filename,null,context.getCacheDir());
        }
        catch (IOException e)
        {
            // TODO: 11/14/15 add IOException code
            file = null;
            Log.e("IOException", "getTempFile exception");
        }
        return file;
    }

}
