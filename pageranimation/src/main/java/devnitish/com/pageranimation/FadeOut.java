package devnitish.com.pageranimation;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Nitish Prasad on 3/1/2018.
 */

public class FadeOut implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {

        page.setTranslationX(-page.getWidth()*position);

        if(position<-1)
            page.setAlpha(0);

        else if(position<=0){
            page.setAlpha(1f-Math.abs(position));
        }

        else if(position<=1){

            page.setAlpha(1f-position);

        }

        else {
            page.setAlpha(0);
        }
    }
}
