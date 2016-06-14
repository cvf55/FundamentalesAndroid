package com.xervika.fundamentalesandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FundamentalesAndroid extends ListActivity {

    String mPruebas[] = {"LifeCycleTest","SingleTouchTest","MultiTouchTest","KeyTest","AccelerometerTest",
            "AssetsTest","ExternalStorageTest","SoundPoolTest","MediaPlayerTest","FullScreenTest",
            "FontTest","SufaceViewTest"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fundamentales_android);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mPruebas));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String nombrePrueba = mPruebas[position];

        try {
            Class c = Class.forName("com.xervika.fundamentalesandroid." + nombrePrueba);
            Intent intent = new Intent(this, c);
            this.startActivity(intent);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
