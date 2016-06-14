package com.xervika.fundamentalesandroid;

import android.app.Activity;
import android.widget.TextView;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LifeCycleTest extends Activity{
    StringBuilder builder = new StringBuilder();
    TextView textView;

    private void log(String text){
        Log.d("LifeCycleTest",text);
        builder.append(text);
        builder.append("\n");

        textView.setText(builder.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textView = new TextView(this);
        textView.setText(builder.toString());
        setContentView(textView);
        log("Created");
    }

    @Override
    protected void onResume() {
        super.onResume();

        log("Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();

        log("Paused");

        if (isFinishing()){
            log("Finishing");
        }
    }
}
