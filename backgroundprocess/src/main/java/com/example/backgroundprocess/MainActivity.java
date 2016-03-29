package com.example.backgroundprocess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(null != savedInstanceState)
        {
            String state = savedInstanceState.getString("STATE");
            Toast.makeText(this, "STATE = " + state, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle)
    {
        Toast.makeText(this, "Saved state", Toast.LENGTH_LONG).show();

        bundle.putString("STATE", "FORCE STOP");
    }
}
