package devnitish.com.pageranimation;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Nitish Prasad on 3/2/2018.
 */

public class CubeIn implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {

        float pos = Math.abs(position);
        float maxScale = 0.75f;
        float scale=0;

        if(position<=0){
            page.setPivotX(page.getWidth());
            page.setRotationY(90*(pos));
        }
        else {
            page.setPivotX(0);
            page.setRotationY(-90*pos);
        }


        if(position==0||position==1){
            page.setScaleY(1);
            page.setScaleX(1);
        }


        if(pos<=0.5){
            scale = Math.max(maxScale,Math.abs(1-pos));

        }
        else if(pos<=1){
            scale = Math.max(maxScale,pos);
        }

        page.setScaleY(scale);
        page.setCameraDistance(2000);

    }
}
