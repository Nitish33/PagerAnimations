package devnitish.com.pageranimation;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by Nitish Prasad on 3/1/2018.
 */

public class FlipAnimation implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        float percentage = 1 - Math.abs(position);
        page.setCameraDistance(12000);

        setVisibility(page, position);
        setTranslation(page,position);
//        setSize(page, position, percentage);
        setRotation(page, position, percentage);

    }

    private void setVisibility(View page, float position) {

        if (position < 0.5 && position > -0.5) {
            page.setVisibility(View.VISIBLE);
        } else {
            page.setVisibility(View.INVISIBLE);
        }

    }

    private void setTranslation(View page,float pos) {

        page.setTranslationX(-pos*page.getWidth());
    }

    private void setSize(View page, float position, float percentage) {
        page.setScaleX((position != 0 && position != 1) ? percentage : 1);
        page.setScaleY((position != 0 && position != 1) ? percentage : 1);
    }

    private void setRotation(View page, float position, float percentage) {

        if (position > 0) {

            Log.e("rotation",""+(-180 * (1-Math.abs(position) + 1)));
            page.setRotationY(-180 * (1-Math.abs(position) + 1));
        } else {
            page.setRotationY(180 * (percentage + 1));
        }
    }
}
