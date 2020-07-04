package com.example.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    String methodName;
    private static final String TEXT_KEY = "textKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);

        if (savedInstanceState == null){
            methodName = "onCreate, bundle is null";
        } else {
            methodName = "onCreate, bundle is not null";
        }


        Log.d("Lifecycle", methodName);
        text.append("\n" + methodName);

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        methodName = "onRestart";
        Log.d("Lifecycle", methodName);
        text.append("\n" + methodName);
    }

    @Override
    protected void onStart() {
        super.onStart();

        methodName = "onStart";
        Log.d("Lifecycle", methodName);
        text.append("\n" + methodName);
    }


    //Он рестор инстансе стейт


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        methodName = "onPostCreate";
        Log.d("Lifecycle", methodName);
        text.append("\n" + methodName);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String restoreString = savedInstanceState.getString(TEXT_KEY);
        text.setText(restoreString);

        methodName = "onRestoreInstanceState";
        Log.d("Lifecycle", methodName);
        text.append("\n" + methodName);
    }

    @Override
    protected void onResume() {
        super.onResume();

        methodName = "onResume";
        Log.d("Lifecycle", methodName);
        text.append("\n" + methodName);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        methodName = "onPostResume";
        Log.d("Lifecycle", methodName);
        text.append("\n" + methodName);
    }

    @Override
    protected void onPause() {
        super.onPause();

        methodName = "onPause";
        Log.d("Lifecycle", methodName);
        text.append("\n" + methodName);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        methodName = "onSaveInstanceState";
        Log.d("Lifecycle", methodName);
        text.append("\n" + methodName);

        outState.putString(TEXT_KEY, text.getText().toString());


    }

    @Override
    protected void onStop() {
        super.onStop();

        methodName = "onStop";
        Log.d("Lifecycle", methodName);
        text.append("\n" + methodName);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        methodName = "onDestroy";
        Log.d("Lifecycle", methodName);
        text.append("\n" + methodName);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_SPACE) {
            methodName = "onKeyDown";
            Log.d("Lifecycle", methodName);
            text.append("\n" + methodName);
        }

        event.startTracking();

        return true;
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {

        methodName = "onKeyLongPress";
        Log.d("Lifecycle", methodName);
        text.append("\n" + methodName);

        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        methodName = "onBackPressed";
        Log.d("Lifecycle", methodName);
        text.append("\n" + methodName);
    }
}