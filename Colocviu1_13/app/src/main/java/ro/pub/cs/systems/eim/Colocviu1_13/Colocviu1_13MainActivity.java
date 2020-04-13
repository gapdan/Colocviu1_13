package ro.pub.cs.systems.eim.Colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

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
                    break;
                default:
                    break;
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
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.NR_PRESSED)) {
                nrPressed = savedInstanceState.getInt(Constants.NR_PRESSED);
                Toast.makeText(getApplicationContext(), Integer.toString(nrPressed), Toast.LENGTH_LONG).show();
            } else {
                nrPressed = 0;
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(Constants.NR_PRESSED, nrPressed);
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
