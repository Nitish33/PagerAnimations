package com.devnitish.pageranimations;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Nitish Prasad on 3/2/2018.
 */

public class SlowBackground implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {

        ImageView background = page.findViewById(R.id.background);
        background.setTranslationX(-position*page.getWidth());

    }
}
