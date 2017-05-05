package com.shoplex.bible.horoscope.view.activity.Aries;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shoplex.bible.horoscope.R;
import com.shoplex.bible.horoscope.databinding.AaaaBinding;

/**
 * Created by qsk on 2017/4/26.
 */

public class DataFragment extends Fragment {

    private AaaaBinding binding;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.aaaa, container, false);
//
//final AriesActivity activity = (AriesActivity) getActivity();
//        activity.binding.toolbar.setBackgroundColor(Color.argb(0, 0x16, 0x17, 0x32));
//
//        //获取顶部图片高度后，设置滚动监听
//        ViewTreeObserver vto = activity.binding.toolbar.getViewTreeObserver();
//        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                activity.binding.toolbar.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                final int height =   activity.binding.toolbar.getHeight();
//
//
//                binding.scroolview.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
//                    @Override
//                    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
//                        //      Log.i("TAG","y--->"+y+"    height-->"+height);
//                        if(y<=height){
//                            float scale =(float) y /height;
//                            float alpha =  (255 * scale);
//
//                            //只是layout背景透明
//                            activity.binding.toolbar.setBackgroundColor(Color.argb((int) alpha*2, 0x15, 0x17, 0x44));
//                        }
//                    }
//                });
//            }
//        });
        return binding.getRoot();
    }


}
