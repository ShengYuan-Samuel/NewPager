package com.nistart.newpager;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

public class SimplePageTransform implements ViewPager.PageTransformer {
        private String TAG = "SimplePageTransform";
   /* @Override
    public void transformPage(View view, float position) {
        if (position <= 1 && position > 0) {
            int hashCode = view.hashCode();
            Log.d(TAG,"right hashCode="+hashCode);
        } else if (position == 0) {
            int hashCode = view.hashCode();
            Log.d(TAG,"center hashCode="+hashCode);
        } else if (position < 0 && position >= -1) {
            int hashCode = view.hashCode();
            Log.w(TAG,"left hashCode="+hashCode);
        }
    }*/

    @Override
    public void transformPage(View view, float position) {
        int width = view.getWidth();
        int pivotX = 0;
        if (position <= 1 && position > 0) {// right scrolling  
            pivotX = 0;
        } else if (position == 0) {

        } else if (position < 0 && position >= -1) {// left scrolling
            pivotX = width;
        }
        //设置x轴的锚点
        view.setPivotX(pivotX);
        //设置绕Y轴旋转的角度
        view.setRotationY(90f * position);
    }
}

