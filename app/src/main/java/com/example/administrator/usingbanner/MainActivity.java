package com.example.administrator.usingbanner;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnBannerListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List images= new ArrayList<>();
        images.add(R.mipmap.a);
        images.add(R.mipmap.b);
        images.add(R.mipmap.c);
        Banner banner = (Banner) findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        //设置监听器
        banner.setOnBannerListener(this);

    }

    @Override
    public void OnBannerClick(int position) {
        Log.d("MainActivity","图片被点击");
        Toast.makeText(getApplicationContext(),"你点击了："+position,Toast.LENGTH_SHORT).show();
    }

    private class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Glide 加载图片
            Glide.with(context).load(path).into(imageView);
        }
    }


    //如果你需要考虑更好的体验，可以这么操作
//    @Override
//    protected void onStart() {
//        super.onStart();
//        //开始轮播
//        banner.startAutoPlay();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        //结束轮播
//        banner.stopAutoPlay();
//    }
}
