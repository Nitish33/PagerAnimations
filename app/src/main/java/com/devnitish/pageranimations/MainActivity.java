package com.devnitish.pageranimations;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = findViewById(R.id.pager);

        SampleFragment s1 = new SampleFragment(1);
        SampleFragment s2 = new SampleFragment(2);
        SampleFragment s3 = new SampleFragment(3);
        SampleFragment s4 = new SampleFragment(4);
        SampleFragment s5 = new SampleFragment(5);
        SampleFragment s6 = new SampleFragment(6);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.addFragment(s1);
        myPagerAdapter.addFragment(s2);
        myPagerAdapter.addFragment(s3);
        myPagerAdapter.addFragment(s4);
        myPagerAdapter.addFragment(s5);
        myPagerAdapter.addFragment(s6);

        mPager.setAdapter(myPagerAdapter);

        ZoomTransformation transformation = new ZoomTransformation();
        DepthTransformation depthTransformation = new DepthTransformation();
        FadeOut fadeOut = new FadeOut();
        HingeTransformation hingeTransformation = new HingeTransformation();
        FlipAnimation flipAnimation = new FlipAnimation();
        CubeRotation cubeRotation = new CubeRotation();
        PageAnimation pageAnimation = new PageAnimation();
        FanAnimation fanAnimation = new FanAnimation();
        FidgeAnimation fidgeAnimation = new FidgeAnimation();
        GateAnimation gateAnimation = new GateAnimation();
        SlowBackground slowBackground = new SlowBackground();
        mPager.setPageTransformer(true, slowBackground);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.cube: CubeRotation cubeRotation = new CubeRotation();
                        mPager.setPageTransformer(true,cubeRotation);
                        break;

            case R.id.depth: DepthTransformation depthTransformation = new DepthTransformation();
                mPager.setPageTransformer(true,depthTransformation);
                break;

            case R.id.fadeout: FadeOut fadeOut = new FadeOut();
                mPager.setPageTransformer(true,fadeOut);
                break;

            case R.id.fan: FanAnimation fanAnimation = new FanAnimation();
                mPager.setPageTransformer(true,fanAnimation);
                break;
            case R.id.fidge: FidgeAnimation fidgeAnimation = new FidgeAnimation();
                mPager.setPageTransformer(true,fidgeAnimation);
                break;

            case R.id.gate: GateAnimation gateAnimation = new GateAnimation();
                mPager.setPageTransformer(true,gateAnimation);
                break;
            case R.id.hinge: HingeTransformation hingeTransformation = new HingeTransformation();
                mPager.setPageTransformer(true,hingeTransformation);
                break;

            case R.id.zoom: ZoomTransformation zoomTransformation = new ZoomTransformation();
                mPager.setPageTransformer(true,zoomTransformation);
                break;

            case R.id.flip: FlipAnimation flipAnimation = new FlipAnimation();
                mPager.setPageTransformer(true,flipAnimation);
                break;





        }

        return true;
    }
}
