package devnitish.com.pageranimation;

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

        if(position<=-1){
            page.setAlpha(0);
        }
        else if(position<=0){
            page.setAlpha(1);
            page.setRotationY(-120*Math.abs(position));

        }

        else if(position<=1){
            page.setAlpha(1);
            page.setRotationY(120*Math.abs(position));

        }

        else if(position>1){
            page.setAlpha(0);
        }
    }
}
