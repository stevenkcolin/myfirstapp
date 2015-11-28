package com.stevenkcolin.fifthapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Calendar;
import java.util.List;

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
    public void onClickBtn_Call(View view){
        // FIXME: 11/14/15 added call number 12345678 code,done
        Uri number = Uri.parse("tel:12345678");
        Intent callIntent = new Intent(Intent.ACTION_DIAL,number);
        startActivity(callIntent);
    }

    public void onClickBtn_ViewMap(View v){
        // FIXME: 11/14/15 added code to launch map
        // Map point based on address
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        // Or map point based on latitude/longitude
        // Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
    }

    public void onClickBtn_OpenBrowser(View v){
        // FIXME: 11/14/15 added code to open browser
        Uri webpage = Uri.parse(getString(R.string.base_url));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);
        startActivity(webIntent);
    }

    public void onClickBtn_SendEmail(View v){
        // FIXME: 11/14/15 add coded to send email
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"jon@example.com"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
    }

    public void onClickBtn_Create_Calendar(View v){
        // FIXME: 11/14/15 add code to create calendar
        Log.e("steve", "onClickBtn_Create_Calendar ");
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2012, 0, 19, 7, 30);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2012, 0, 19, 10, 30);

        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");

        startActivity(calendarIntent);
    }

    public void onClickBtn_Safe_Open_Map(View v){
        // FIXME: 11/14/15 add code to safe open map to avoid crash
        // Build the intent
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        // Verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        // Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(mapIntent);
        }
    }

    public void onClickBtn_Share(View v){
        // FIXME: 11/14/15 add code to share some strings
        Intent intent = new Intent(Intent.ACTION_SEND);

        // Always use string resources for UI text.
        // This says something like "Share this photo with"
        String title = getResources().getString(R.string.hello_world);
        // Create intent to show chooser
        Intent chooser = Intent.createChooser(intent, title);

        // Verify the intent will resolve to at least one activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
        else
            startActivity(chooser);
    }


}
