package com.jwk.exampleviewpager1;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DemoPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> arr = new ArrayList<>();
        arr.add("A");
        arr.add("B");
        arr.add("C");
        arr.add("D");
        arr.add("E");
        arr.add("F");
        arr.add("G");
        arr.add("H");

        final ViewPager vp = (ViewPager)findViewById(R.id.viewpager1);

        vp.setClipToPadding(false);
        int size = getResources().getDimensionPixelSize(R.dimen.viewpager_page_margin);
        vp.setPageMargin( -1 * size );

        vp.setOffscreenPageLimit(3);

        adapter = new DemoPagerAdapter(vp,arr);
        adapter.ready();
    }
}
