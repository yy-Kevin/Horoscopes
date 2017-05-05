package com.shoplex.bible.horoscope.view.activity.aries;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.shoplex.bible.horoscope.R;
import com.shoplex.bible.horoscope.databinding.ActivityAriesBinding;
import com.shoplex.bible.horoscope.view.fragment.aries.AriesFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qsk on 2017/5/5.
 */

public class AriesActivity extends AppCompatActivity{

    private ActivityAriesBinding binding;
                              //定义viewPager
    private FragmentPagerAdapter fAdapter;                               //定义adapter

    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表

    private AriesFragment hotRecommendFragment;              //热门推荐fragment
    private AriesFragment hotCollectionFragment;              //热门推荐fragment
    private AriesFragment hotMonthFragment;              //热门推荐fragment
    private AriesFragment hotToday;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_aries);

        setSupportActionBar(binding.toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        initControls();

    }
    /**
     * 初始化各控件
     * @param
     */
    private void initControls() {

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
        binding.tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list_title.get(0)));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list_title.get(1)));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list_title.get(2)));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(list_title.get(3)));

        fAdapter = new AriesActivity.Find_tab_Adapter(getSupportFragmentManager(),list_fragment,list_title);

        //viewpager加载adapter
        binding.lvDemo.setAdapter(fAdapter);
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        binding.tabLayout.setupWithViewPager(binding.lvDemo);
        //tab_FindFragment_title.set
    }

    public static class Find_tab_Adapter extends FragmentPagerAdapter {

        private List<Fragment> list_fragment;
        private List<String> list_Title;


        public Find_tab_Adapter(FragmentManager fm, List<Fragment> list_fragment, List<String> list_Title) {
            super(fm);
            this.list_fragment = list_fragment;
            this.list_Title = list_Title;
        }

        @Override
        public Fragment getItem(int position) {
            return list_fragment.get(position);
        }

        @Override
        public int getCount() {
            return list_Title.size();
        }

        //此方法用来显示tab上的名字
        @Override
        public CharSequence getPageTitle(int position) {

            return list_Title.get(position % list_Title.size());
        }
    }
}
