package ro.pub.cs.systems.eim.Colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Colocviu1_13MainActivity extends AppCompatActivity {

    Button north;
    Button east;
    Button south;
    Button west;
    Button changeBtn;
    TextView myTextView;

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
        
    }
}
