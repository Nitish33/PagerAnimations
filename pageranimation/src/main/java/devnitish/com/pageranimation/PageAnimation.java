package devnitish.com.pageranimation;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Nitish Prasad on 3/2/2018.
 */

public class PageAnimation implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {

        page.setTranslationX(-position*page.getWidth());
        page.setPivotY(0);
        page.setPivotX(0);
//        page.setCameraDistance(10);

        int pageBefore = page.getWidth();
        float scale = 1-Math.abs(position);

        if(position<0){
//            page.setTranslationX(page.getWidth());
            page.setRotationY(-90*Math.abs(position));

        }

        else if(position<1){
            page.setRotationY(90*Math.abs(position));
//            page.setScaleX(scale);
//            float deltaX = (pageBefore-page.getWidth())/2;
//            page.setTranslationX(-deltaX);

        }

        else if(position>1){
//            page.setTranslationX(-page.getWidth());
        }
    }
}
