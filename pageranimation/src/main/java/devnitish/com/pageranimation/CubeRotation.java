package devnitish.com.pageranimation;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Nitish Prasad on 3/1/2018.
 */

public class CubeRotation implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {

        float maxScale = 0.8f;

        float pos = Math.abs(position);
        float scale = 0;

        if(pos<=0.5){
            scale = Math.max(maxScale,Math.abs(1-pos));

        }
        else if(pos<=1){
            scale = Math.max(maxScale,pos);
        }

        page.setScaleY(scale);
        page.setCameraDistance(2000);

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
