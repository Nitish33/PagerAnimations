package devnitish.com.pageranimation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Nitish Prasad on 3/1/2018.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmentsList;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment){

        if(fragmentsList == null)
            fragmentsList = new ArrayList<>();

        fragmentsList.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }
}
