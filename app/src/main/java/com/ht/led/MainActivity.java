package com.ht.led;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.AsyncTask;

public class MainActivity extends AppCompatActivity {

    private Camera camera;
    private int cameraId = 0; // 此功能目前不实用，这里不做实现 ， 但不能删除
    private Parameters parameters;
    boolean isTorch = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnled = (Button)findViewById(R.id.button_open);
        btnled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        callLed(isTorch);
                    }

                }).start();
                isTorch = !isTorch;
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void callLed(boolean isTorch)
    {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            try {
                if(isTorch)
                {
                    manager.setTorchMode("0", false);
                }
                else
                {
                    manager.setTorchMode("0", true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void led_open(View view)
    {
//        FlashlightUtil.setSwitch();
    }
    public void led_close(View view)
    {

    }
}