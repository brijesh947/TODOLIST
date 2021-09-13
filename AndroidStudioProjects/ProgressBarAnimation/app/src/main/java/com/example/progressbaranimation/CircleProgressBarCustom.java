package com.example.progressbaranimation;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

import androidx.annotation.Nullable;

import java.util.logging.LogRecord;

public class CircleProgressBarCustom extends View {

    //Normal dot radius
    private int dotRadius = 15;

    //Expanded Dot Radius
    boolean flag = true;
    private int bounceDotRadius = 20;
    int width = 100 + (dotRadius*8);
    int height = 100 + (dotRadius*8);


    //to get identified in which position dot has to expand its radius
    private int dotPosition = 1;

    //specify how many dots you need in a progressbar
    private int dotAmount = 4;

    //specify the circle radius
    private int circleRadius = 30;

    public CircleProgressBarCustom(Context context) {
        super(context);
    }

    public CircleProgressBarCustom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleProgressBarCustom(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        //Animation called when attaching to the window, i.e to your screen
        startAnimation();
    }


    @Override

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //take the point to the center of the screen

        canvas.translate(this.getWidth()/2,this.getHeight()/2);
        Paint progressPaint = new Paint();
        progressPaint.setColor(Color.parseColor("#ff014f"));
        //call create dot method
        createDotInCircle(canvas,progressPaint);
    }

    @SuppressLint("WrongCall")
    private void createDotInCircle(Canvas canvas, Paint progressPaint) {
        //angle for each dot angle = (360/number of dots) i.e  (360/10)
        int angle = 90;
        int count = 1;
        for(int i = 1; i <= dotAmount; i++){

            if(i == dotPosition){
                // angle should be in radians  i.e formula (angle *(Math.PI / 180))
//                Handler handler = new Handler();

                progressPaint.setColor(Color.parseColor("YELLOW"));
                float x = (float) (circleRadius * (Math.cos((angle * i) * (Math.PI / 180))));
                float y = (float) (circleRadius * (Math.sin((angle * i) * (Math.PI / 180))));

                canvas.drawCircle(x,y, bounceDotRadius, progressPaint);
              //  canvas.rotate(90);
            }else{

                // angle should be in radians  i.e formula (angle *(Math.PI / 180))
                progressPaint.setColor(Color.parseColor("GREEN"));
                float x = (float) (circleRadius * (Math.cos((angle * i) * (Math.PI / 180))));
                float y = (float) (circleRadius * (Math.sin((angle * i) * (Math.PI / 180))));
                canvas.drawCircle(x,y, dotRadius, progressPaint);
               // canvas.rotate(90);
              //  canvas.rotate(90,this.getWidth()/2,this.getHeight()/2);


            }

        }


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        //Dynamically setting width and height to progressbar 100 is circle radius, dotRadius * 3 to cover the width and height of Progressbar

        //MUST CALL THIS
        setMeasuredDimension(width, height);
    }

    private void startAnimation() {
        BounceAnimation bounceAnimation = new BounceAnimation();
        bounceAnimation.setDuration(300);
        bounceAnimation.setRepeatCount(Animation.INFINITE);
        bounceAnimation.setInterpolator(new LinearInterpolator());
        bounceAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                 circleRadius=30;
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                dotPosition++;
                if (flag){
                    circleRadius+=10;
                    if(circleRadius>80)
                        flag = false;
                }
                if(!flag){
                    circleRadius-=10;
                    if(circleRadius<30)
                        flag = true;
                }


                //when dotPosition == dotAmount , then start again applying animation from 0th positon , i.e  dotPosition = 0;
                if (dotPosition > dotAmount) {
                    dotPosition = 1;
                }


            }
        });
        startAnimation(bounceAnimation);
    }


    private class BounceAnimation extends Animation {
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            //call invalidate to redraw your view againg.
            invalidate();
        }
    }
}