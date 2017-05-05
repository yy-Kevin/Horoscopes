package com.shoplex.bible.horoscope.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.shoplex.bible.horoscope.base.BaseFragment;
import com.shoplex.bible.horoscope.view.fragment.aquarius.AquariusFragment;
import com.shoplex.bible.horoscope.view.fragment.CancerFragment;
import com.shoplex.bible.horoscope.view.fragment.CaprcornFragment;
import com.shoplex.bible.horoscope.view.fragment.GeminiFragment;
import com.shoplex.bible.horoscope.view.fragment.LibraFragment;
import com.shoplex.bible.horoscope.view.fragment.LionFragment;
import com.shoplex.bible.horoscope.view.fragment.PiscesFragment;
import com.shoplex.bible.horoscope.view.fragment.SagittariusFragment;
import com.shoplex.bible.horoscope.view.fragment.ScorpioFragment;
import com.shoplex.bible.horoscope.view.fragment.TaurusFragment;
import com.shoplex.bible.horoscope.view.fragment.VirgoFragment;
import com.shoplex.bible.horoscope.view.fragment.aries.AriesFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qsk on 2017/4/26.
 */
public class MainAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> data;

    public MainAdapter(FragmentManager fm) {
        super(fm);
        data = new ArrayList<>();
        data.add(AriesFragment.getInstance());
        data.add(TaurusFragment.getInstance());
        data.add(GeminiFragment.getInstance());
        data.add(CancerFragment.getInstance());
        data.add(LionFragment.getInstance());
        data.add(VirgoFragment.getInstance());
        data.add(LibraFragment.getInstance());
        data.add(ScorpioFragment.getInstance());
        data.add(SagittariusFragment.getInstance());
        data.add(CaprcornFragment.getInstance());
        data.add(AquariusFragment.getInstance());
        data.add(PiscesFragment.getInstance());
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}