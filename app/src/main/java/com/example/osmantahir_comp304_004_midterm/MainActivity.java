

package com.example.osmantahir_comp304_004_midterm;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int counter=0;
    int lastClickPos=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] excerciseArray ={ getResources().getString(R.string.jumping),
                getResources().getString(R.string.Swimming),
                getResources().getString(R.string.Bike),
                getResources().getString(R.string.Walking),
                getResources().getString(R.string.Running)};

        TextView tv= (TextView) findViewById(R.id.textView);
        tv.setText("Choose an excercise to see Kcal Burned Per Hour");

        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 ,excerciseArray){

            @SuppressLint("ResourceAsColor")
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(R.color.teal_700);

                return view;
            }


        };


        ListView listView = (ListView) findViewById(R.id.ex_listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // here implement logic for last click comparing with last position
                if(lastClickPos==position){
                    counter+=2;
                }else {
                    lastClickPos=position;
                }
                switch(counter){
                    case 1:
                        Log.d("count", String.valueOf(counter));
                        break;
                    case 2:
                        // if counter is 2 means double click, hence let it navigate
                        counter=0;
                        Intent intent =new Intent().setClass(getApplicationContext(), SecondActivity.class);
                        intent.putExtra("stringValue",listView.getItemAtPosition(position).toString());
                        startActivity(intent);
                }
            }
        });
    }
}