package com.devwon.looppageradapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by JWK on 2017. 1. 7..
 */

public abstract class LoopPagerAdapter extends PagerAdapter {

    private int loop_more_view_count = 3;
    private ViewPager viewPager;

    public LoopPagerAdapter(final ViewPager viewPager){
        this.viewPager = viewPager;
    }
    public LoopPagerAdapter(ViewPager viewPager, int loop_more_view_count){
        this(viewPager);
        this.loop_more_view_count = loop_more_view_count;
    }

    /**
     * Must Implement This Function
     * But Do Not Use This Function
     * Use getLootCount(int position)
     */
    public abstract Object getItem(int position);

    public Object getLoopItem(int position){
        return getItem((position+getItemCount()-loop_more_view_count)%getItemCount());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public abstract int getItemCount();

    @Override
    public int getCount() {
        return getItemCount() + loop_more_view_count * 2;
    }

    public void ready(){
        viewPager.setAdapter(this);
        viewPager.setCurrentItem(loop_more_view_count);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {}

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state == ViewPager.SCROLL_STATE_IDLE){
                    int position = viewPager.getCurrentItem();
                    if(position < loop_more_view_count )
                        viewPager.setCurrentItem( position + getItemCount() ,false);
                    else if(position > loop_more_view_count + ( getItemCount() - 1 ) )
                        viewPager.setCurrentItem( position - getItemCount()  , false);
                }
            }
        });
    }
}
