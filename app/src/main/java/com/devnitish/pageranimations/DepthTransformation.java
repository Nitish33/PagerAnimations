package com.devnitish.pageranimations;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Nitish Prasad on 3/1/2018.
 */

public class DepthTransformation implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {

        if(position<-1){
            page.setAlpha(0);
        }

        else if(position<=0){
            page.setAlpha(1);
            page.setScaleX(1);
            page.setScaleY(1);
        }

        else if(position<=1){
            page.setAlpha(1-position);
            page.setScaleX(Math.max(0.75f,1f-position));
            page.setScaleY(Math.max(0.75f,1f-position));
            page.setTranslationX(-position*page.getWidth());

//            page.setScaleX(position);
        }

        else {
            page.setAlpha(0);
        }
    }
}
