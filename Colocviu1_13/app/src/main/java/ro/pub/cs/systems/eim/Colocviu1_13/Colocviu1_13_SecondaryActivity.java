package ro.pub.cs.systems.eim.Colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Colocviu1_13_SecondaryActivity extends AppCompatActivity {
    private Button register;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_13__secondary);
        register = (Button) findViewById(R.id.register);
        cancel = (Button) findViewById(R.id.cancel);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.ALL_COORDS)) {
            String myText = intent.getStringExtra(Constants.ALL_COORDS);
            Toast.makeText(getApplicationContext(), myText, Toast.LENGTH_LONG).show();
        }
        register.setOnClickListener(buttonClickListener);
        cancel.setOnClickListener(buttonClickListener);
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), Colocviu1_13MainActivity.class);
            switch(view.getId()) {
                case R.id.register:
                    intent.putExtra(Constants.REGISTER, Constants.REGISTER);
                    intent.putExtra(Constants.CANCEL, "Empty");
                    setResult(RESULT_OK, intent);
                    finish();
                    break;
                case R.id.cancel:
                    intent.putExtra(Constants.REGISTER, "Empty");
                    intent.putExtra(Constants.CANCEL, Constants.CANCEL);
                    setResult(RESULT_OK, intent);
                    finish();
                    break;
                default:
                    setResult(RESULT_CANCELED, null);

            }
        }
    }
}
