package com.example.duanzijia.jnidemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "dzj";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI()+test());
        ImageView iv1 = (ImageView) findViewById(R.id.image1);
        ImageView iv2 = (ImageView) findViewById(R.id.image2);
        iv1.setImageResource(R.drawable.a);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
        gaussBlur(bitmap);
        iv2.setImageBitmap(bitmap);
    }
    public native String stringFromJNI();
    public native void gaussBlur(Bitmap bitmap);
    public native int test();

    static {
        System.loadLibrary("native-lib");
    }
}