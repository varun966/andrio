package edu.niu.cs.z1835350.tapbuttoncounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Counter count;             //Model
    private TextView counterTextView;  //View

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = new Counter();
        counterTextView = findViewById(R.id.textViewCnt);
    }

    public void countTap(View v){
        count.addCounter();         //adds 1 to counter
        counterTextView.setText(count.getCounter().toString()); //changes text to reflect the counter

    }
}
