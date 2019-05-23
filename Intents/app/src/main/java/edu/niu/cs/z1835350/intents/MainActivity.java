package edu.niu.cs.z1835350.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final int CODE_A = 1;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.intents, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();
        if(id == R.id.nodata){
            Intent intent = new Intent(this,NoDataActivity.class);
            startActivity(intent);
            return true;
        }else if(id== R.id.sumback){
            Intent i = new Intent(this,SumBack.class);
            startActivityForResult(i,CODE_A);
            return true;
        }else if(id == R.id.sendnum){
            Intent i = new Intent(this, Sending.class);
            i.putExtra("val",47);
            startActivity(i);
        }
        return super.onOptionsItemSelected(menuItem);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == CODE_A){
            if(resultCode == RESULT_OK){
                //do something with the value passed back
                int answer = data.getIntExtra("num", -1);
                Toast.makeText(this,"The sum is "+answer,Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    public  void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        Intent i = null;
        switch(position){
            case 0:                 //open a web page
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.niu.edu"));
                break;
            case 1:                 //dial a phone number
                i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(630)2941234"));
                break;
            case 2:                 //open a map
                break;
            case 3:                 //take a picture
                break;
            case 4:                 //open contacts
                break;
        }
        if(i!=null){
            startActivity(i);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView){

    }
}
