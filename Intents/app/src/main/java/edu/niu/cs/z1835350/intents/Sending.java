package edu.niu.cs.z1835350.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Sending extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending);
        getValue();
    }

    private void getValue() {
        int i = getIntent().getIntExtra("val",0);
        Toast.makeText(this, "Value coming from caller is "+i,Toast.LENGTH_LONG).show();
    }
}
