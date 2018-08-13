package com.nistart.newpager;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private List<View> mList = new ArrayList<>();
    private List<Integer> mImage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        init();
        initView();
    }

    private void init() {
        
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        for (int i = 0; i < 10; i++) {
            View inflate = getLayoutInflater().inflate(R.layout.item, null);
            ImageView img = inflate.findViewById(R.id.pager_iv);
            TextView tv = inflate.findViewById(R.id.pager_tv);
            img.setImageResource(R.mipmap.ic_launcher);
            tv.setText((i+1)+"/"+10);
            mList.add(inflate);
        }
        MyAdapter myAdapter = new MyAdapter(mList);
        vp.setAdapter(myAdapter);
       // vp.setPageTransformer(false ,new ZoomInTransform());
        vp.setPageTransformer(true,new SimplePageTransform());
    }
}
