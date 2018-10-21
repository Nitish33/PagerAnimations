package devnitish.com.pageranimation;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Nitish Prasad on 3/2/2018.
 */

public class FidgeAnimation implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {

        page.setTranslationX(-position*page.getWidth());

        float alpha = (float)Math.max(0.5,Math.abs(position));

        if(Math.abs(position)>0.5)
            page.setVisibility(View.GONE);

        else if(Math.abs(position)<0.5) {
            page.setVisibility(View.VISIBLE);
            page.setScaleX(1-Math.abs(position));
            page.setScaleY(1-Math.abs(position));

        }

        if(position<0){
            page.setRotation(360*(1-Math.abs(position))*(1-Math.abs(position))*
                    (1-Math.abs(position))*(1-Math.abs(position))*(1-Math.abs(position)));
        }
        else {
            page.setRotation(-360*(1-Math.abs(position))*(1-Math.abs(position))
                    *(1-Math.abs(position))*(1-Math.abs(position))*(1-Math.abs(position)));
        }
    }
}
