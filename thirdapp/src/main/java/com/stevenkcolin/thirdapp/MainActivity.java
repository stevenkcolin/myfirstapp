package com.stevenkcolin.thirdapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.stevenkcolin.thirdapp.R;

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

    public void onClickButton(View view)
    {
        Log.e("report", "onClickButton new button");
        EditText edt1 = (EditText) findViewById(R.id.edt_1);
        EditText edt2 = (EditText) findViewById(R.id.edt_2);
        String str_edt1=edt1.getText().toString();
        String str_edt2=edt2.getText().toString();


        //把edt1&edt2的值写入数据
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.str_email), str_edt1);
        editor.putString(getString(R.string.str_passwd),str_edt2);
        editor.commit();
    }
    public void onClickReadButton(View view)
    {
        //从R.string中读取string.str_email/str_passwd的值
        //从preference中读取str_email/str_passwd的值
        SharedPreferences readPref = this.getPreferences(Context.MODE_PRIVATE);
        String defaultValue1 = getResources().getString(R.string.str_email);
        String val1=readPref.getString(getString(R.string.str_email), defaultValue1);
        String defaultValue2 = getResources().getString(R.string.str_passwd);
        String val2=readPref.getString(getString(R.string.str_passwd), defaultValue2);

        //记录log, 把defaultValue1/2 以及val1/val2都打印出来。
        Log.e("report", "onClickReadButton "+defaultValue1+"***********"+defaultValue2);
        Log.e("report", "onClickReadButton "+val1+"***********"+val2);
    }
}
