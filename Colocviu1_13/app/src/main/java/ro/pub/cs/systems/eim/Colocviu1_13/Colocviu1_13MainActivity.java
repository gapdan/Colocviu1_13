package ro.pub.cs.systems.eim.Colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Colocviu1_13MainActivity extends AppCompatActivity {

    private Button north;
    private Button east;
    private Button south;
    private Button west;
    private Button changeBtn;
    private TextView myTextView;
    private int nrPressed;
    private int serviceStatus = Constants.SERVICE_STOPPED;
    private IntentFilter intentFilter = new IntentFilter();

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.north:
                    ++nrPressed;
                    if (myTextView.getText().toString().equals("")) {
                        myTextView.setText(Constants.NORTH);
                    } else {
                        String aux = myTextView.getText().toString() + "," + Constants.NORTH;
                        myTextView.setText(aux);
                    }
                    break;
                case R.id.east:
                    ++nrPressed;
                    if (myTextView.getText().toString().equals("")) {
                        myTextView.setText(Constants.EAST);
                    } else {
                        String aux = myTextView.getText().toString() + "," + Constants.EAST;
                        myTextView.setText(aux);
                    }
                    break;
                case R.id.south:
                    ++nrPressed;
                    if (myTextView.getText().toString().equals("")) {
                        myTextView.setText(Constants.SOUTH);
                    } else {
                        String aux = myTextView.getText().toString() + "," + Constants.SOUTH;
                        myTextView.setText(aux);
                    }
                    break;
                case R.id.west:
                    ++nrPressed;
                    if (myTextView.getText().toString().equals("")) {
                        myTextView.setText(Constants.WEST);
                    } else {
                        String aux = myTextView.getText().toString() + "," + Constants.WEST;
                        myTextView.setText(aux);
                    }
                    break;
                case R.id.changeBtn:
                    Intent intent = new Intent(getApplicationContext(), Colocviu1_13_SecondaryActivity.class);
                    intent.putExtra(Constants.ALL_COORDS, myTextView.getText().toString());
                    myTextView.setText("");
                    nrPressed = 0;
                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
                default:
                    break;
            }
            if (nrPressed >= 4) {
                Intent serviceIntent = new Intent(getApplicationContext(), Colocviu1_13Service.class);
                serviceIntent.putExtra(Constants.SERVICE_COMMANDS, myTextView.getText().toString());
                getApplication().startService(serviceIntent);
                serviceStatus = Constants.SERVICE_STARTED;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_13_main);
        north = (Button)findViewById(R.id.north);
        east = (Button)findViewById(R.id.east);
        west = (Button)findViewById(R.id.west);
        south = (Button)findViewById(R.id.south);
        changeBtn = (Button)findViewById(R.id.changeBtn);
        myTextView = (TextView) findViewById(R.id.textView);
        north.setOnClickListener(buttonClickListener);
        east.setOnClickListener(buttonClickListener);
        west.setOnClickListener(buttonClickListener);
        south.setOnClickListener(buttonClickListener);
        changeBtn.setOnClickListener(buttonClickListener);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.NR_PRESSED)) {
                nrPressed = savedInstanceState.getInt(Constants.NR_PRESSED);
                Toast.makeText(getApplicationContext(), Integer.toString(nrPressed), Toast.LENGTH_LONG).show();
            } else {
                nrPressed = 0;
            }
        }
        for (int index = 0; index < Constants.actionTypes.length; index++) {
            intentFilter.addAction(Constants.actionTypes[index]);
        }

    }
    @Override
    protected void onDestroy() {
        Intent intent = new Intent(this, Colocviu1_13Service.class);
        stopService(intent);
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(Constants.NR_PRESSED, nrPressed);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if ((requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) && (intent != null)) {
            String cancel = intent.getStringExtra(Constants.CANCEL);
            String register = intent.getStringExtra(Constants.REGISTER);
            if (cancel != null && cancel.equals(Constants.CANCEL)) {
                Toast.makeText(getApplicationContext(), Constants.CANCEL, Toast.LENGTH_LONG).show();
            } else if (register != null && register.equals(Constants.REGISTER)) {
                Toast.makeText(getApplicationContext(),  Constants.REGISTER, Toast.LENGTH_LONG).show();
            }
        }
    }
    private MessageBroadcastReceiver messageBroadcastReceiver = new MessageBroadcastReceiver();
    private class MessageBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(getApplicationContext(),  "Broadcast Receiver", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(messageBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(messageBroadcastReceiver);
        super.onPause();
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.NR_PRESSED)) {
                nrPressed = savedInstanceState.getInt(Constants.NR_PRESSED);
                Toast.makeText(getApplicationContext(),  Integer.toString(nrPressed), Toast.LENGTH_LONG).show();
            } else {
                nrPressed = 0;
            }
        }
    }
}
