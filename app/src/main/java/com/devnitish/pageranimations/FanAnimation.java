package com.devnitish.pageranimations;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Nitish Prasad on 3/2/2018.
 */

public class FanAnimation implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {

        page.setTranslationX(-position*page.getWidth());
        page.setPivotY(0);
        page.setPivotX(0);

        if(position<0){
            page.setRotationY(-180*Math.abs(position));

        }

        else if(position<1){
            page.setRotationY(180*Math.abs(position));

        }

        else if(position>1){
        }
    }
}
