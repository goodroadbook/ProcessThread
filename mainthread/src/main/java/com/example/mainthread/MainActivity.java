package com.example.mainthread;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            switch(msg.what)
            {
                case 0:
                    updateTextView(msg.arg1);
                    break;
                default:
                    break;
            }
        }
    };

    private Runnable runnable = new Runnable()
    {
        @Override
        public void run()
        {
            TextView sumtxt = (TextView)MainActivity.this.findViewById(R.id.posttxt);
            sumtxt.setText("Start Runnable");
        }
    };


    class CountThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            int sum = 0;

            while (i < 10) {
                i++;
                sum += i;
            }

            Message msg = handler.obtainMessage();
            msg.what = 0;
            msg.arg1 = sum;
            handler.sendMessage(msg);

            handler.post(runnable);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountThread thread = new CountThread();
        thread.start();
    }

    private void updateTextView(int aSum)
    {
        TextView sumtxt = (TextView)MainActivity.this.findViewById(R.id.sumtxt);
        sumtxt.setText("1부터 10까지 합 = " + aSum);
    }
}
