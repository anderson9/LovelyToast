package com.ljs.lovelytoast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.eftimoff.androipathview.PathView;

/**
 * Created by anderson9 on 2016-9-24.
 */

public class LovelyToast {
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;

    public static final int SUCCESS = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;
    public static final int CONFUSING = 4;
    public static final int INFO = 5;
    public static final int DEFAULT = 6;

    public static final int LEFT = 1;
    public static final int RIGHT = 2;

    public static final int TOP_DOWN = 1;
    public static final int LEFT_RIGHT = 2;
    public static final int SCALE = 3;
    static NewToast mToast;
    static PathView mPview;
    private static NewToast getinstance(Context context, @Nullable int animlocation) {
        if (mToast == null) {
            synchronized (NewToast.class){
                if (mToast==null)
                    mToast = new NewToast(context, animlocation);
            }
        }

        mToast.setanim(animlocation);
        mToast.init();
        context.getApplicationContext().registerReceiver(mHomeKeyEventReceiver, new IntentFilter(
                Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
        return mToast;
    }

    /**
     * no pop Anim ,animview at left
     *
     * @param context context
     * @param msg     msg
     * @param length  LENGTH_SHORT or LENGTH_LONG
     * @param type    SUCCESS,WARNING,ERROR,CONFUSING,INFO,DEFAULT
     */
    public static void makeText(Context context, String msg, int length, int type) {
        makeText(context, msg, length, type, 0, 0);
    }

    /**
     * @param context
     * @param msg
     * @param length
     * @param type
     * @param showanim
     */
    public static void makeText(Context context, String msg, int length, int type, @Nullable int
            showanim) {
        makeText(context, msg, length, type, showanim, 0);
    }

    /**
     * @param context
     * @param msg
     * @param length      显示时间长度
     * @param type        6 type
     * @param showanim    animStyle  默认无(TOP_DOWN,LEFT_RIGHT,SCALE)
     * @param leftofright 默认 svgAnim left  (LEFT or RIGHT)
     */
    public static void makeText(Context context, String msg, int length, int type, @Nullable int
            showanim, @Nullable int leftofright) {
        if (showanim == 1) {
            mToast = getinstance(context, R.style.myToastUpDown);
        } else if (showanim == 2) {
            mToast = getinstance(context, R.style.myToastLeftRight);
        } else if (showanim == 3) {
            mToast = getinstance(context, R.style.myToastScale);
        } else {
            mToast = getinstance(context, showanim);
        }
        ;
        View layout = null;
        switch (type) {
            case 1:
                layout = getLayoutview(context, leftofright);
                layout.findViewById(R.id.base_layout).setBackgroundResource(R.drawable.background_success_toast);
                setLyout(msg, length, layout, R.drawable.success_toast, type);
                break;
            case 2:
                layout = getLayoutview(context, leftofright);
                layout.findViewById(R.id.base_layout).setBackgroundResource(R.drawable.background_warning_toast);
                setLyout(msg, length, layout, R.drawable.warning_toast, type);
                break;
            case 3:
                layout = getLayoutview(context, leftofright);
                layout.findViewById(R.id.base_layout).setBackgroundResource(R.drawable.background_error_toast);
                setLyout(msg, length, layout, R.drawable.error_toast, type);
                break;
            case 4:
                layout = getLayoutview(context, leftofright);
                layout.findViewById(R.id.base_layout).setBackgroundResource(R.drawable.background_confusing_toast);
                setLyout(msg, length, layout, R.drawable.confusing_toast, type);
                break;
            case 5:
                layout = getLayoutview(context, leftofright);
                layout.findViewById(R.id.base_layout).setBackgroundResource(R.drawable.background_info_toast);
                setLyout(msg, length, layout, R.drawable.info_toast, type);
                break;
            case 6:
                layout = getLayoutview(context, leftofright);
                layout.findViewById(R.id.base_layout).setBackgroundResource(R.drawable.background_default_toast);
                setLyout(msg, length, layout, R.drawable.default_toast, type);
                break;
        }
        mToast.setView(layout);
        mToast.show();
    }
    /**
     * 得到左图画 OR 右图画的布局
     *
     * @param context
     * @param leftofright
     * @return
     */
    private static View getLayoutview(Context context, @Nullable int leftofright) {
        View layout;
        layout = leftofright == 2 ? LayoutInflater.from(context).inflate(
                R.layout.success_toast_right_layout, null, false) : LayoutInflater.from(context).inflate(R
                .layout.success_toast_left_layout, null, false);
        return layout;
    }

    private static void setLyout(String msg, int length, View layout, int textRs, int type) {
        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(msg);
        mPview = (PathView) layout.findViewById(R.id.pathview);
        switch (type) {
            case 1:
                mPview.setSvgResource(R.raw.s);
                break;
            case 2:
                mPview.setSvgResource(R.raw.w);
                break;
            case 3:
                mPview.setSvgResource(R.raw.e);
                break;
            case 4:
                mPview.setSvgResource(R.raw.c);
                break;
            case 5:
                mPview.setSvgResource(R.raw.i);
                break;
            case 6:
                mPview.setSvgResource(R.raw.d);
                break;
        }
        mPview.setFillAfter(true);
        mPview.useNaturalColors();
        mPview.getPathAnimator()
                .delay(200)
                .duration(700)
                .interpolator(new AccelerateDecelerateInterpolator())
                .start();
        text.setBackgroundResource(textRs);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        mToast.setDuration(length);
    }

    /**
     * cancel this Toast
     * 如果想Toast绑定某Activity退出设置。也可以自在Activity生命周期中Cancel，
     */
    public static void cancel() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        if (mPview != null) {
            mPview = null;
        }
    }

    private static BroadcastReceiver mHomeKeyEventReceiver = new BroadcastReceiver() {
        String SYSTEM_REASON = "reason";
        String SYSTEM_HOME_KEY = "homekey";
        String SYSTEM_HOME_KEY_LONG = "recentapps";

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
                String reason = intent.getStringExtra(SYSTEM_REASON);
                Log.e("reason", reason);
                if (TextUtils.equals(reason, SYSTEM_HOME_KEY)) {
                    //表示按了home键,程序到了后台
                    context.unregisterReceiver(mHomeKeyEventReceiver);
                    cancel();
                } else if (TextUtils.equals(reason, SYSTEM_HOME_KEY_LONG)) {
                    //表示长按home键,显示最近使用的程序列表
                    context.unregisterReceiver(mHomeKeyEventReceiver);
                    cancel();
                }
            }
        }
    };
}


