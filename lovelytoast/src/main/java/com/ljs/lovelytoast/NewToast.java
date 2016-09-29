package com.ljs.lovelytoast;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by anderson9 on 2016-9-24.
 */

public class NewToast extends Toast {
    boolean hasReflectException = false;//是否反射成功
      int mAnim =0; //动画配置 默认无



    public   void   setanim (@Nullable int AnimStyle) {
        mAnim=AnimStyle;
    }

    private NewToast(Context context){
        super(context.getApplicationContext());
    }
    public NewToast(Context context, int AnimStyle) {
        super(context.getApplicationContext());//USE applicationContext
        setanim(AnimStyle);
        init();

    }
    /**
     * 初始化
     */
    public void init() {
        if (!hasReflectException) //反射获得成功才调用动画否则无设置动画。
            initTN();
    }



    private void initTN() {
        Field mTN;
        Object mObj;
        Class<Toast> clazz = Toast.class;
        int anim =getAnim();
        try {
            mTN = clazz.getDeclaredField("mTN");
            mTN.setAccessible(true);
            mObj = mTN.get(this);

            // 修改掉默认toast弹出动画
            Field field = mObj.getClass().getDeclaredField("mParams");
            if (field != null) {
                field.setAccessible(true);
                Object mParams = field.get(mObj);
                if (mParams != null
                        && mParams instanceof WindowManager.LayoutParams) {
                    WindowManager.LayoutParams params = (WindowManager.LayoutParams) mParams;
                    params.windowAnimations = anim;
                }
            }
            hasReflectException = false;
        } catch (NoSuchFieldException e) {
            hasReflectException = true;
        } catch (IllegalAccessException e) {
            hasReflectException = true;
        } catch (IllegalArgumentException e) {
            hasReflectException = true;
        }
    }


    @Override
    public void cancel() {
        super.cancel();
    }

    public int  getAnim() {
        return mAnim;
    }
}








