package com.example.simpledemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> data = new ArrayList<>();
    private List<String> pageTitle = new ArrayList<>();

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

        initInfo();
    }

    private void findView(){
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tab_layout);
    }

    private void initInfo(){
        pageTitle.add("BlankFragment");
        pageTitle.add("BlankFragment2");
        pageTitle.add("BlankFragment3");

        data.add(new BlankFragment());
        data.add(new BlankFragment2());
        data.add(new BlankFragment3());

        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager(),pageTitle,data);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager,true);
        Objects.requireNonNull(tabLayout.getTabAt(1)).select();
    }
}
