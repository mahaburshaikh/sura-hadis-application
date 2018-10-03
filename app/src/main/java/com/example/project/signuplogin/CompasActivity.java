package com.example.project.signuplogin;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class CompasActivity extends AppCompatActivity implements SensorEventListener{

    private ImageView imgCompass, imgCompass1;
    private TextView tvHeading;

    private float currentDegree = 0f;

    //CustomDrawableView mCustomDrawableView;
    private SensorManager mSensorManager;
    private Sensor accelerometer, magnetometer;
    private boolean hasAccelerometer = false, hasMagnetometer = false;



    Float azimut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compas);

        imgCompass = (ImageView) findViewById(R.id.img_compass);
        tvHeading = (TextView) findViewById(R.id.tv_heading);
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        hasAccelerometer = mSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        hasMagnetometer = mSensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL);

        if(hasAccelerometer && hasMagnetometer){

        }else {
            String title="Sensor not found";
            tvHeading.setText(title);
        }

        //imgCompass1 = (ImageView) view.findViewById(R.id.img_compass1);

    }

    @Override



    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);

    }

    float[] mGravity;
    float[] mGeomagnetic;
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            mGravity = event.values.clone();
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
            mGeomagnetic = event.values.clone();
        if (mGravity != null && mGeomagnetic != null) {
            float R[] = new float[9];
            float I[] = new float[9];
            boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);
            if (success) {
                float orientation[] = new float[3];
                SensorManager.getOrientation(R, orientation);
                azimut = orientation[0]; // orientation contains: azimut, pitch and roll
                float degree = (float) Math.toDegrees(azimut);
                tvHeading.setText("Heading: " + Float.toString(degree) + " degrees");
                RotateAnimation ra = new RotateAnimation(currentDegree,
                        -degree,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                ra.setDuration(510);
                ra.setFillAfter(true);
                imgCompass.startAnimation(ra);
                currentDegree = -degree;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


}
