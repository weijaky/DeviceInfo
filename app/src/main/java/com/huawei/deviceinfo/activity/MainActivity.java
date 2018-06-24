package com.huawei.deviceinfo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.huawei.deviceinfo.R;
import com.huawei.deviceinfo.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(0);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addTitle(getString(R.string.location));
        adapter.addTitle(getString(R.string.application));
        adapter.addTitle(getString(R.string.ads));
        adapter.addTitle(getString(R.string.battery));
        adapter.addTitle(getString(R.string.device_info));
        adapter.addTitle(getString(R.string.memory));
        adapter.addTitle(getString(R.string.network));
        adapter.addTitle(getString(R.string.installed_apps));
//        adapter.addTitle(getString(R.string.contacts));
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }
}
