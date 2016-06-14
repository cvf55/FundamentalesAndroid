package com.xervika.fundamentalesandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MultiTouchTest extends Activity implements View.OnTouchListener {
    StringBuilder mBuilder = new StringBuilder();
    TextView mTextView;
    float[] x = new float[10];
    float[] y = new float[10];
    boolean[] tocado = new boolean[10];

    private void updateTextView(){
        mBuilder.setLength(0);
        for(int i=0; i < 10; i++){
            mBuilder.append((tocado[i]));
            mBuilder.append(", ");
            mBuilder.append(x[i]);
            mBuilder.append((", "));
            mBuilder.append((y[i]));
            mBuilder.append("\n");
        }

        mTextView.setText(mBuilder.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTextView = new TextView(this);
        mTextView.setText("Toca y arrastra. ¡Soporta multiples dedos!");
        mTextView.setOnTouchListener(this);

        setContentView(mTextView);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEvent.ACTION_MASK;
        int pointerIndex = (motionEvent.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;

        return false;
    }
}
