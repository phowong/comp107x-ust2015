package hk.ust.cse.comp107x.simplechatclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;


public class ChatClient extends Activity implements View.OnClickListener {

    Button sendButton;
    EditText messageText;
    ListView messageList;
    MyArrayAdapter mAdapter = null;
    ArrayList<Message> messages = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_client);

        sendButton = (Button) findViewById(R.id.sendButton);
        sendButton.setOnClickListener(this);

        messageText = (EditText) findViewById(R.id.messageText);

        // TODO
        // Get the reference to the ListView on the UI
        messageList = (ListView) findViewById(R.id.messageList);

        // Create a new ArrayList of Message objects
        messages = new ArrayList<Message>();

        // Create a new custom ArrayAdapter. This custom Adapter is
        // implemented by us, and illustrates how an ArrayAdapter is
        // constructed given the data (from the Message objects)
        mAdapter = new MyArrayAdapter(this,messages);

        // Set the ListView's adapter to be the adapter that we just constructed.
        messageList.setAdapter((ListAdapter)mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat_client, menu);
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

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.sendButton:

                String messString = messageText.getText().toString();

                // If the message is not empty string
                if (!messString.equals("")) {

                    // TODO

                    // Create a new Message object and initialize it with the information
                    Message message = new Message("",messString,true,new Date());

                    // Add the Message object to the ArrayList
                    messages.add(message);

                    // Notify the adapter that the data has changed due to the addition
                    // of a new message object. This triggers an update of the ListView
                    mAdapter.notifyDataSetChanged();

                    message = null;
                    messageText.setText("");



                }

                break;

            default:
                break;
        }
    }
}
