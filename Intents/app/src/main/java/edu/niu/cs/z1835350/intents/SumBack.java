package edu.niu.cs.z1835350.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SumBack extends AppCompatActivity {

    private Button backBtn;
    private EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_back);
        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
        backBtn = findViewById(R.id.buttonBack);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1, num2, ans;
                try{
                    num1 = Integer.parseInt(et1.getText().toString());
                    num2 = Integer.parseInt(et2.getText().toString());
                }catch(NumberFormatException nfe){
                    num1 = 0;
                    num2 = 0;
                }
                ans = num1 + num2;
                Intent i = getIntent();
                i.putExtra("num", ans);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
