package com.devnitish.pageranimations;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by Nitish Prasad on 3/1/2018.
 */

public class HingeTransformation implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {

       page.setTranslationX(-position*page.getWidth());
       page.setPivotX(0);
       page.setPivotY(0);
       page.setCameraDistance(100);

       float pos = Math.abs(position);

       if(pos<-1)
           page.setAlpha(0);

       if(position<=0){
           page.setRotation(90*pos);
           page.setAlpha(1-pos);

       }
       else if(position<1) {
           page.setRotation(0);
           page.setAlpha(1);
       }

        else
            page.setAlpha(0);

    }
}
