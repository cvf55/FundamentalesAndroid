package com.xervika.fundamentalesandroid;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class SingleTouchTest extends Activity implements View.OnTouchListener {

    StringBuilder mBuilder = new StringBuilder();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textView = new TextView(this);
        textView.setText("Toca y arrastra. ¡Un dedo solamente!");
        textView.setOnTouchListener(this);

        setContentView(textView);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mBuilder.setLength(0);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mBuilder.append("down, ");
                break;
            case MotionEvent.ACTION_MOVE:
                mBuilder.append("move, ");
                break;
            case MotionEvent.ACTION_CANCEL:
                mBuilder.append("cancel, ");
                break;
            case MotionEvent.ACTION_UP:
                mBuilder.append("up, ");
                break;
        }

        mBuilder.append(event.getX());
        mBuilder.append(", ");
        mBuilder.append(event.getY());

        String text = mBuilder.toString();
        Log.d("TouchTest", text);
        textView.setText(text);

        return true;
    }
}
