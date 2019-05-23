package edu.niu.cs.z1835350.burgercaloriecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {

    private RadioGroup pattyRG, cheeseRG;
    private CheckBox prosciuttoCBX;
    private SeekBar sauceSBR;
    private TextView caloriesTV;
    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        burger = new Burger();
        //call initialize
        initialize();
        //register the change
        registerChangeListener();
        //end on create


    }


    private void registerChangeListener(){
        pattyRG.setOnCheckedChangeListener(foodListener);
        cheeseRG.setOnCheckedChangeListener(foodListener);
        prosciuttoCBX.setOnClickListener(baconListener);
        sauceSBR.setOnSeekBarChangeListener(sauceListener);
    }
    private void initialize()
    {
        pattyRG = findViewById(R.id.rg1);
        cheeseRG = findViewById(R.id.rg2);
        prosciuttoCBX = findViewById(R.id.checkBoxProsciutto);
        sauceSBR = findViewById(R.id.seekBar);
        caloriesTV = findViewById(R.id.textViewCalorie);
        displayCalories();
    }
    private void displayCalories(){
        String calorieTxt = "Calories: " + burger.getTotalCalories();
        caloriesTV.setText(calorieTxt);
    }
    private  RadioGroup.OnCheckedChangeListener foodListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.radioButtonBeef:
                    burger.setPattyCal(Burger.BEEF);
                    break;
                case R.id.radioButtonLamb:
                    burger.setPattyCal(Burger.LAMB);
                    break;
                case R.id.radioButtonOstrich:
                    burger.setPattyCal(Burger.OSTRICH);
                    break;
                case R.id.radioButton4:
                    burger.setCheeseCal(Burger.ASIAGO);
                    break;
                case R.id.radioButtonProvolone:
                    burger.setCheeseCal(Burger.PROVOLONE);
            }//end switch
            displayCalories();
        }
    }; //end on checked change listener
    private View.OnClickListener baconListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(((CheckBox) view).isChecked())
                burger.setProsciuttoCal(Burger.PROSCIUTTO);
            else
                burger.clearProsciuttoCalories();

                displayCalories();
        }//end onclick
    };

    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            burger.setSauceCal(seekBar.getProgress());
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }; //end on seekbar change lsitener
}
