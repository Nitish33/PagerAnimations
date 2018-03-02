package com.devnitish.pageranimations;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Nitish Prasad on 3/2/2018.
 */

public class GateAnimation implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {

        float pos = Math.abs(position);
        page.setTranslationX(-position*page.getWidth());

        if(position<=0){
            page.setPivotX(0);
            page.setRotationY(90*pos);
        }
        else {
            page.setPivotX(page.getWidth());
            page.setRotationY(-90*pos);
        }


    }
}
