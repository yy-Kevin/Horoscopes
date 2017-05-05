package com.shoplex.bible.horoscope.view.activity.aries;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shoplex.bible.horoscope.R;
import com.shoplex.bible.horoscope.view.fragment.aries.AriesFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qsk on 2017/5/5.
 */

public class DataFragment extends Fragment {
    private TabLayout tab_FindFragment_title;                            //定义TabLayout
    private ViewPager vp_FindFragment_pager;                             //定义viewPager
    private FragmentPagerAdapter fAdapter;                               //定义adapter

    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表

    private AriesFragment hotRecommendFragment;              //热门推荐fragment
    private AriesFragment hotCollectionFragment;              //热门推荐fragment
    private AriesFragment hotMonthFragment;              //热门推荐fragment
    private AriesFragment hotToday;              //热门推荐fragment


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_aries, container, false);

        initControls(view);

        return view;
    }

    /**
     * 初始化各控件
     * @param view
     */
        private void initControls(View view) {

        tab_FindFragment_title = (TabLayout)view.findViewById(R.id.tab_layout);
        vp_FindFragment_pager = (ViewPager)view.findViewById(R.id.lv_demo);

        //初始化各fragment
        hotRecommendFragment = new AriesFragment();
        hotCollectionFragment = new AriesFragment();
        hotMonthFragment = new AriesFragment();
        hotToday = new AriesFragment();

        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(hotRecommendFragment);
        list_fragment.add(hotCollectionFragment);
        list_fragment.add(hotMonthFragment);
        list_fragment.add(hotToday);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("热门推荐");
        list_title.add("热门收藏");
        list_title.add("本月热榜");
        list_title.add("今日热榜");

        //设置TabLayout的模式
        tab_FindFragment_title.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(0)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(1)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(2)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(3)));

        fAdapter = new AriesActivity.Find_tab_Adapter(getActivity().getSupportFragmentManager(),list_fragment,list_title);

        //viewpager加载adapter
        vp_FindFragment_pager.setAdapter(fAdapter);
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        tab_FindFragment_title.setupWithViewPager(vp_FindFragment_pager);
        //tab_FindFragment_title.set
    }


}

