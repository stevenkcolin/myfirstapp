package com.stevenkcolin.myfirstapp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mTextView = (TextView) findViewById(R.id.txt_view);
        Log.e("steve", "onCreate shishikan");

        //setContentView(R.layout.activity_news__articles);
        

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
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
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        android.os.Debug.stopMethodTracing();
        Log.e("steve", "onDestroy hahahaha");



    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.e("steve", "onPause hahahaha");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.e("steve", "onResume hahahahaha");
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.e("steve", "onStart hahahahaha");
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        Log.e("steve", "onRestart hahahahaha");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        Log.e("steve", "onSaveInstanceState hahahaha");
    }


}
