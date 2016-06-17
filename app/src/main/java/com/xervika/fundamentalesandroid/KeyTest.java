package com.xervika.fundamentalesandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class KeyTest extends Activity implements View.OnKeyListener{

    StringBuilder mBuilder = new StringBuilder();
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTextView = new TextView(this);
        mTextView.setText("Pulsa teclas y observa el resultado en la pantalla");
        mTextView.setOnKeyListener(this);
        mTextView.setFocusableInTouchMode(true);
        mTextView.requestFocus();

        setContentView(mTextView);
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        mBuilder.setLength(0);
        switch (keyEvent.getAction()){
            case KeyEvent.ACTION_DOWN:
                mBuilder.append("Down, ");
                break;
            case KeyEvent.ACTION_UP:
                mBuilder.append("Up, ");
                break;
        }
        mBuilder.append(keyEvent.getKeyCode());
        mBuilder.append(", ");
        mBuilder.append((char) keyEvent.getUnicodeChar());

        String text = mBuilder.toString();
        Log.d("KeyTest",text);
        mTextView.setText(text);

        if(keyEvent.getKeyCode() == KeyEvent.KEYCODE_BACK)
            return false;
        else
            return true;
    }
}
