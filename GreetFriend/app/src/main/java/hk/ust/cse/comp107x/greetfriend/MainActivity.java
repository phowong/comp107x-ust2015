package hk.ust.cse.comp107x.greetfriend;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ListActivity {

    String [] names;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Construct a string array from the String Array resource "friends" in the
        // strings.xml file
        names = getResources().getStringArray(R.array.friends);

        // This method call sets the names string array as the source of the names
        // for the list of items in the listview. The ArrayAdapter object is used
        // to adapt the string array and construct a list of layout items that are
        // then used by the ListView of the ListActivity to construct the list of friends.
        // The layout of each item is specified by the friend_item.xml file
        setListAdapter( new ArrayAdapter<String>(this, R.layout.friend_item, names));

        Log.i(TAG, "in onCreate()");
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // The parameter "id" indicates the index of the item that was selected from
        // the list of friends. This is used to index into the names[] array to get
        // the name of the friend selected. Rest of the code is similar to the earlier
        // exercise.

        // create a new intent. The first parameter is the Context which is the current Activity.
        // Hence we use "this". The second parameter is the Activity class that we wish to start.
        // Hence it is specified as ShowMessage.class
        Intent in = new Intent(this,ShowMessage.class);

        // Add the message as a payload to the Intent. We add data to be carried by the intern using
        // the putExtra() methods. The data is specified as a key-value pair. The first parameter is
        // the key, specified as a string, and the second parameter is the value.
        in.putExtra("message", getString(R.string.greetmessage) + names[(int) id] + "!");

        // We start the new activity by calling this method to inform the Android framework to start
        // the new activity. The parameter is the Intent we just created earlier
        startActivity(in);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "in onStart()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "in onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "in onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "in onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "in onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "in onDestroy()");
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void onClick(View v) {
//
//
//        EditText editFriendName = (EditText) findViewById(R.id.editFriendName);
//
//        String friendName = editFriendName.getText().toString();
//
//        switch (v.getId()){
//
//            case R.id.greetButton:
//
//                Intent in = new Intent(this,ShowMessage.class);
//
//                in.putExtra("message",getString(R.string.greetmessage) + friendName + "!");
//
//                startActivity(in);
//                break;
//
//            default:
//                break;
//        }
//    }
}
