package com.ljs.lovelytoastdome;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ljs.lovelytoast.LovelyToast;
import com.ljs.lovelytoastdome.R;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    Button bt;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;
    Button bt9;
    Button bt10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.bt);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);
        bt10 = (Button) findViewById(R.id.bt10);
        bt.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt10.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LovelyToast.cancel();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                LovelyToast.makeText(MainActivity.this, " SUCCESS!!", LovelyToast.LENGTH_SHORT,
                        LovelyToast
                                .SUCCESS);
                break;
            case R.id.bt1:
                LovelyToast.makeText(MainActivity.this, " WARNING!!", 0, LovelyToast.WARNING);
                break;
            case R.id.bt2:
                LovelyToast.makeText(MainActivity.this, " ERROR!!!", 0, LovelyToast.ERROR);
                break;
            case R.id.bt3:
                LovelyToast.makeText(MainActivity.this, " CONFUSING!", 0, LovelyToast.CONFUSING);
                break;
            case R.id.bt4:
                LovelyToast.makeText(MainActivity.this, "INFO!!!", 0, LovelyToast
                        .INFO);
                break;
            case R.id.bt5:
                LovelyToast.makeText(MainActivity.this, " DEFAULT!!", 0, LovelyToast
                        .DEFAULT);
                break;
            case R.id.bt6:
                LovelyToast.makeText(MainActivity.this, " Hi guys !", 1, LovelyToast
                        .SUCCESS,LovelyToast.TOP_DOWN);
                break;
            case R.id.bt7:
                LovelyToast.makeText(MainActivity.this, " Hi guys !", 1, LovelyToast
                        .SUCCESS,LovelyToast.LEFT_RIGHT);//多设置一个showanim
                break;
            case R.id.bt8:
                LovelyToast.makeText(MainActivity.this, " Hi guys !", 0, LovelyToast
                        .SUCCESS,LovelyToast.SCALE);
                break;
            case
                    R.id.bt9:
                LovelyToast.makeText(MainActivity.this, " Hi guys !", 0, LovelyToast
                        .SUCCESS,0,LovelyToast.LEFT);//注意中间有一个0
                break;
            case R.id.bt10:
                LovelyToast.makeText(MainActivity.this, " Hi guys !", 0, LovelyToast
                        .SUCCESS,0,LovelyToast.RIGHT);//注意中间一个0
                break;

        }
    }
}