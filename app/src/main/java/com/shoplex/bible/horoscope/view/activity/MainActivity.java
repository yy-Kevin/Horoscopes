package com.shoplex.bible.horoscope.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

import com.shoplex.bible.horoscope.R;
import com.shoplex.bible.horoscope.base.BaseActivity;
import com.shoplex.bible.horoscope.base.BasePresenter;
import com.shoplex.bible.horoscope.databinding.ActivityMainBinding;
import com.shoplex.bible.horoscope.utils.SharedPreferencesUtils;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initFragment();
    }


    private void initFragment() {

        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());
        binding.vpMainViewpager.setAdapter(mainAdapter);
        binding.vpMainViewpager.setOffscreenPageLimit(0);
        int current = (int) SharedPreferencesUtils.get(this,"isZodoac",0);
        binding.vpMainViewpager.setCurrentItem(current);
        selectFragment(current);

        binding.vpMainViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                selectFragment(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    private void selectFragment(int position){
        switch (position) {
            case 0:
                initToolbar(binding.tlToolbar, getResources().getString(R.string.aries));
                break;
            case 1:
                initToolbar(binding.tlToolbar, getResources().getString(R.string.taurus));
                break;
            case 2:
                initToolbar(binding.tlToolbar, getResources().getString(R.string.gemini));
                break;
            case 3:
                initToolbar(binding.tlToolbar, getResources().getString(R.string.cancer));
                break;
            case 4:
                initToolbar(binding.tlToolbar, getResources().getString(R.string.lion));
                break;
            case 5:
                initToolbar(binding.tlToolbar, getResources().getString(R.string.virgo));
                break;
            case 6:
                initToolbar(binding.tlToolbar, getResources().getString(R.string.libra));
                break;
            case 7:
                initToolbar(binding.tlToolbar, getResources().getString(R.string.scorpio));
                break;
            case 8:
                initToolbar(binding.tlToolbar, getResources().getString(R.string.sagittarius));
                break;
            case 9:
                initToolbar(binding.tlToolbar, getResources().getString(R.string.caprcorn));
                break;
            case 10:
                initToolbar(binding.tlToolbar, getResources().getString(R.string.aquarius));
                break;
            case 11:
                initToolbar(binding.tlToolbar, getResources().getString(R.string.pisces));
                break;
            default:
                initToolbar(binding.tlToolbar, getResources().getString(R.string.aries));
                break;
        }
    }

}
