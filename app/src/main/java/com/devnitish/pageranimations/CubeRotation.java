package com.devnitish.pageranimations;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Nitish Prasad on 3/1/2018.
 */

public class CubeRotation implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {

        float pos = Math.abs(position);

       if(position<=0){

           page.setPivotX(page.getWidth());
           page.setRotationY(-90*pos);

       }
       else{

           page.setPivotX(0);
           page.setRotationY(90*(pos));
       }
    }
}
