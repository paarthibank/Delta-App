package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.jar.Attributes;

import static android.os.CountDownTimer.*;

public class second_screen extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;

    public static final String Name1 = "nameKey";
    public static final int[] l1={0};

    

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);
        final ConstraintLayout lay = (ConstraintLayout) findViewById(R.id.background);
        final Button button1 =(Button) findViewById(R.id.btn1);
        final Button button2 =(Button) findViewById(R.id.btn2);
        final Button button3 =(Button) findViewById(R.id.btn3);
        final Button button4 =(Button) findViewById(R.id.btn4);
        final Vibrator vibe =(Vibrator) second_screen.this.getSystemService(Context.VIBRATOR_SERVICE);
        Button btn=(Button)findViewById(R.id.goback);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(second_screen.this, MainActivity.class);
                startActivity(intent);

            }
        });
        SharedPreferences shared = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        String temp = (shared.getString(Name1, ""));
        TextView text =(TextView)findViewById(R.id.NO);
        text.setText(temp);
        final TextView res=(TextView)findViewById(R.id.rorn);
        final TextView win=(TextView)findViewById(R.id.win);
        int num= Integer.parseInt(temp);
        final int[][] l = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int oa=0;int ob=0,od=0;
        final int[] j = {0};
        int n=0;
        int i=0;
        int a1=0;
        SharedPreferences settings = getSharedPreferences("SAVING", 0);
        l1[0] = settings.getInt("SCOREVAL", 0);



        final CountDownTimer mycount=new CountDownTimer(11000, 1000) {

            public void onTick(long millisUntilFinished) {
                res.setText("seconds remaining: " + millisUntilFinished / 1000);
            }


            public void onFinish() {
                res.setText("Time is up");
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                int redColorValue = Color.RED;
                lay.setBackgroundColor(redColorValue);
                l1[0] = 0;

                String ll =Integer.toString(l1[0]);
                win.setText("YOUR SCORE IS "+ ll);
                SharedPreferences settings = getSharedPreferences("SAVING", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("SCOREVAL",l1[0]);
                editor.commit();

            }

        }.start();
        


        for(i=1;i<=num/2;i++)
        {
            if(num%i==0)
            {
                l[0][j[0]]=i;
                j[0]++;
            }
        }
        j[0]--;
        for(i=0;i<100;i++)
        {
            double a = Math.random();
            a=a*100;
            oa = (int) (a);
            for(a1=0; a1<= j[0]; a1++)
            {
                if (l[0][a1]==oa)
                    n=1;
            }
            if(n==0)
                break;
            n=0;
        }
        double m = Math.random();
        m=m*(j[0] -1);
        int cr= (int) (m);
        cr=cr+1;
        int oc= l[0][cr];
        for(i=0;i<100;i++)
        {
            double b = Math.random();
            b=b*100;
            ob = (int) b;
            for(a1=0; a1<= j[0]; a1++)
            {
                if (l[0][a1]==ob)
                    n=1;
            }
            if(n==0)
                break;
            n=0;
        }
        for(i=0;i<100;i++)
        {
            double c = Math.random();
            c=c*100;
            od = (int) c;
            for(a1=0; a1<= j[0]; a1++)
            {
                if (l[0][a1]==od)
                    n=1;
            }
            if(n==0)
                break;
            n=0;
        }

        double c = Math.random();
        c=c*4;
        int k= (int) c;
        String op1=Integer.toString(oa);
        String op2=Integer.toString(ob);
        final String op3=Integer.toString(oc);
        String op4=Integer.toString(od);
        if(k==0||k==4)
        {
            button1.setText(op1);
            button2.setText(op2);
            button3.setText(op3);
            button4.setText(op4);

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int redColorValue = Color.RED;
                    lay.setBackgroundColor(redColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE WRONG AND THE ANSWER IS :"+op3);
                    l1[0] = 0;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();
                    vibe.vibrate(500);
                    mycount.cancel();



                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int redColorValue = Color.RED;
                    lay.setBackgroundColor(redColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE WRONG AND THE ANSWER IS :"+op3);
                    l1[0] =0;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();
                    vibe.vibrate(500);
                    mycount.cancel();


                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int greenColorValue = Color.GREEN;
                    lay.setBackgroundColor(greenColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE RIGHT AND THE ANSWER IS :"+op3);
                    l1[0] =l1[0]+1;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();

                    mycount.cancel();


                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int redColorValue = Color.RED;
                    lay.setBackgroundColor(redColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE WRONG AND THE ANSWER IS :"+op3);
                    l1[0]=0;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();
                    vibe.vibrate(500);
                    mycount.cancel();

                }
            });
        }

        if(k==1)
        {
            button1.setText(op1);
            button2.setText(op2);
            button3.setText(op4);
            button4.setText(op3);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int redColorValue = Color.RED;
                    lay.setBackgroundColor(redColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE WRONG AND THE ANSWER IS :"+op3);
                    l1[0] =0;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();
                    vibe.vibrate(500);
                    mycount.cancel();

                }

            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int redColorValue = Color.RED;
                    lay.setBackgroundColor(redColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE WRONG AND THE ANSWER IS :"+op3);
                    l1[0] =0;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();
                    vibe.vibrate(500);
                    mycount.cancel();

                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int redColorValue = Color.RED;
                    lay.setBackgroundColor(redColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE WRONG AND THE ANSWER IS :"+op3);
                    l1[0] =0;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();
                    vibe.vibrate(500);
                    mycount.cancel();

                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int greenColorValue = Color.GREEN;
                    lay.setBackgroundColor(greenColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE RIGHT AND THE ANSWER IS :"+op3);
                    l1[0] =l1[0]+1;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();
                    mycount.cancel();
                }
            });
        }
        if(k==2)
        {
            button1.setText(op3);
            button2.setText(op2);
            button3.setText(op4);
            button4.setText(op1);
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int redColorValue = Color.RED;
                    lay.setBackgroundColor(redColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE WRONG AND THE ANSWER IS :"+op3);
                    l1[0] =0;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();
                    vibe.vibrate(500);
                    mycount.cancel();

                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int redColorValue = Color.RED;
                    lay.setBackgroundColor(redColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE WRONG AND THE ANSWER IS :"+op3);
                    l1[0] =0;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();
                    vibe.vibrate(500);
                    mycount.cancel();

                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int greenColorValue = Color.GREEN;
                    lay.setBackgroundColor(greenColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE RIGHT AND THE ANSWER IS :"+op3);
                    l1[0] =l1[0]+1;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();

                    mycount.cancel();

                    
                     }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int redColorValue = Color.RED;
                    lay.setBackgroundColor(redColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE WRONG AND THE ANSWER IS :"+op3);
                    l1[0] =0;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();
                    vibe.vibrate(500);
                    mycount.cancel();

                }
            });
        }
        if(k==3)
        {
            button1.setText(op2);
            button2.setText(op3);
            button3.setText(op4);
            button4.setText(op1);
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int redColorValue = Color.RED;
                    lay.setBackgroundColor(redColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE WRONG AND THE ANSWER IS :"+op3);
                    l1[0] =0;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();
                    vibe.vibrate(500);
                    mycount.cancel();

                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int greenColorValue = Color.GREEN;
                    lay.setBackgroundColor(greenColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE RIGHT AND THE ANSWER IS :"+op3);
                    l1[0] =l1[0]+1;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();

                    mycount.cancel();

                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int redColorValue = Color.RED;
                    lay.setBackgroundColor(redColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE WRONG AND THE ANSWER IS :"+op3);
                    l1[0] =0;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();
                    vibe.vibrate(500);
                    mycount.cancel();

                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int redColorValue = Color.RED;
                    lay.setBackgroundColor(redColorValue);
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    res.setText("YOU ARE WRONG AND THE ANSWER IS :"+op3);
                    l1[0] =0;
                    String ll =Integer.toString(l1[0]);
                    win.setText("YOUR SCORE IS "+ ll);
                    SharedPreferences settings = getSharedPreferences("SAVING", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("SCOREVAL",l1[0]);
                    editor.commit();
                    vibe.vibrate(500);
                    mycount.cancel();

                }
            });
        }
        




















    }
}
