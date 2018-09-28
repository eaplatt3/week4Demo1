package com.example.sickl.week4demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final static String LOG_TAG = MainActivity.class.getName().toString();

    String[] mClasses;
    List<String> lstClasses;
    TextView mTv;
    LinearLayout myLinearLayout;
    Button btn;
    ListView mlv;
    ArrayAdapter<String> adapter;
    String str = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClasses = getResources().getStringArray(R.array.fsc_bcs_classes);
        lstClasses=new ArrayList<String>(Arrays.asList(mClasses));

        mTv=findViewById(R.id.txtv);
        myLinearLayout=findViewById(R.id.mainLayout);

            btn = new Button(this);
            mlv = new ListView(this);

            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                    android.R.id.text1,mClasses);

            mlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                   // Toast.makeText(MainActivity.this,"yu clicked item number " + mClasses[i] ,
                           // Toast.LENGTH_SHORT).show();
                    lstClasses.remove(i);
                    adapter.notifyDataSetChanged();
                    mlv.invalidateViews();

                }
            });

        mlv.setAdapter(adapter);

            btn.setText("Click");


           btn.setOnClickListener(this::read);
             /*   @Override
                public void onClick(View v) {
                    mTv.setText("Earl");
                }
            });*/


             myLinearLayout.addView(mlv);
            myLinearLayout.addView(btn);






        Log.i(LOG_TAG, "This activity is in on Create" +mClasses[0]);


    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(LOG_TAG, "This activity is in on Restart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(LOG_TAG, "This activity is in on Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(LOG_TAG, "This activity is in on Pause");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(LOG_TAG, "This activity is in on Start");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(LOG_TAG, "This activity is in on Resume");
    }

    public void read(View view) {

        mTv.setText("Lambda");
    }

  /*  @Override
    public void onClick(View v) {
        mTv.setText("earl2222");
    }*/
}
