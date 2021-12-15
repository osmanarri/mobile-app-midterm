// SecondActivity

package com.example.osmantahir_comp304_004_midterm;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int mycolor;
        String value;

        String excercise=getIntent().getStringExtra("stringValue");
        switch (excercise){
            case "Jumping Rope":
                mycolor= Color.BLUE;
                value="750 kcal";
                break;
            case "Swimming":
                mycolor= Color.RED;
                value="600 kcal";
                break;
            case "Bike Riding":
                mycolor= Color.YELLOW;
                value="500 kcal";
                break;
            case "Walking":
                mycolor= Color.GREEN;
                value="300 kcal";
                break;
            case "Running":
                mycolor= 0xFF800080;// hexadecimal for purple color
                value="600 kcal";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + excercise);
        }

        ImageView imageView=(ImageView) findViewById(R.id.imageView);

        Bitmap bitmap = Bitmap.createBitmap(900, 500, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(mycolor);
        canvas.drawRect(0, 180, 1800, 80, paint);
        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(80);
        canvas.drawText(excercise,80,150,textPaint);
        imageView.setImageBitmap(bitmap);


        LinearLayout linearLayout= (LinearLayout)findViewById(R.id.linearlayout2);
        linearLayout.setBackgroundColor(mycolor);

        TextView tv2= (TextView)findViewById(R.id.tv2);
        tv2.setText(excercise);

        TextView tvValue= (TextView)findViewById(R.id.tvValue);
        tvValue.setText(value);

    }
}