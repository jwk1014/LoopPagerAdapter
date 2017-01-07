package com.jwk.exampleviewpager1;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.devwon.looppageradapter.LoopPagerAdapter;

import java.util.List;

/**
 * Created by JWK on 2017. 1. 7..
 */

public class DemoPagerAdapter extends LoopPagerAdapter {
    private List<String> arr;

    public DemoPagerAdapter(ViewPager viewPager, List<String> arr){
        super(viewPager);
        this.arr = arr;
    }

    @Override
    public Object getItem(int position) {
        return arr.get(position);
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.page_content,container,false);

        ((TextView)v.findViewById(R.id.page_content_textview1)).setText( (String)getLoopItem(position) );

        container.addView(v);

        return v;
    }
}
