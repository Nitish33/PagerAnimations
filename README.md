# PagerAnimations

<html>
<body>
<h1><center> Simple View Pager Animation</center></h1>


<p> Hello Friends , in this post i gonna show you few view pager animation.<br>
Animation in view pager is implemented using PageTransformer interface which is called whenever we slide view pager.
It is called twice for every slide event, because atmost two pages are visible are visible on the screen.
The position for first page is between <b>(-1,0)</b> and second page is <b>(0,1)</b>.
<br>
In the idle state , 0 being the position of the page we are currenting viewing.
<br>
<br>
<br>
<center><h2>Cube Rotation</h2></center>
<p>
<img src = "/images/Cube rotation.gif"></img>
</p>
<code>
    @Override
    public void transformPage(View page, float position) {

        float pos = Math.abs(position);

       if(position<=0){

           page.setPivotX(page.getWidth());
           page.setRotationY(-90*pos);

       }
       else{

           page.setPivotX(0);
           page.setRotationY(90*(pos));
       }
    }
</code>

Animation looks amazing but it has simple implementation. 
<code> if(position<=0)</code>
The above snippet indicate the page which is being slided offscreen from left to right, or in general it indicate the left page <br>
the cube animation. 
<code> page.setPivotX(page.getWidth());
        page.setRotationY(-90*pos);
        </code>
 we have set x pivot to the end of the page, because we want to rotate the left half about the axis, end of the page.<br>
 Next , we set rotation. <b>(-90*pos)</b><br>
 90 because we want to rotate it maximum of 90 .
 <br>
 <code> when pos = 0, rotation = 0
        when pos = .5 , rotation = -45
        when pos = 1, rotation = -90
</code>

Same for the else part, but it will have pivot point at 0, and rotation opposite to the left half...
Simple.

<h2>Depth Animation</h2>
<p>
<img src = "/images/Depth animation.gif"></img>
</p>
<code>
 if(position<-1){
            page.setAlpha(0);
        }

        else if(position<=0){
            page.setAlpha(1);
            page.setScaleX(1);
            page.setScaleY(1);
        }

        else if(position<=1){
            page.setAlpha(1-position);
            page.setScaleX(Math.max(0.75f,1f-position));
            page.setScaleY(Math.max(0.75f,1f-position));
            page.setTranslationX(-position*page.getWidth());
        }

        else {
            page.setAlpha(0);
        }
</code>

<br><br><br>
<h1>Fade Out Animation</h1>
<p>
<img src = "/images/Fade animation.gif"></img>
</p>

<code>

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
</code>


<h2>Fan Animation</h2>
<p>
<img src = "/images/Fan animation.gif"></img>
<p>

<code>
  @Override
    public void transformPage(View page, float position) {

        page.setTranslationX(-position*page.getWidth());
        page.setPivotY(0);
        page.setPivotX(0);

        if(position<0){
            page.setRotationY(-180*Math.abs(position));

        }

        else if(position<1){
            page.setRotationY(180*Math.abs(position));

        }

        else if(position>1){
        }
    }
</code>

<h2>Fidget Animation</h2>
<p>
<img src = "/images/Fidget animation.gif"></img>
</p>
<code>
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
            page.setRotation(360*(1-Math.abs(position)));
        }
        else {
            page.setRotation(-360*(1-Math.abs(position)));
        }
    }
</code>


<h2>Flip Animation</h2>
<p>
<img src = "/images/Flip animation.gif"></img>
</p>

<code>
 @Override
    public void transformPage(View page, float position) {
        float percentage = 1 - Math.abs(position);
        page.setCameraDistance(12000);
        setVisibility(page, position);
        setTranslation(page,position);
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

</code>



<h2>Gate Animation..</h2>

<p>
<img src = "/images/Gate animation.gif"></img>
</p>

<code>

    @Override
    public void transformPage(View page, float position) {

        float pos = Math.abs(position);
        page.setTranslationX(-position*page.getWidth());

        if(position<=0){
            page.setPivotX(0);
            page.setRotationY(90*pos);
        }
        else {
            page.setPivotX(page.getWidth());
            page.setRotationY(-90*pos);
        }


    }

</code>



<h2>Hinge Animation</h2>
<p>
  <img src= "/images/Hinge animation.gif"></img>
<p>
<code>
    @Override
    public void transformPage(View page, float position) {

       page.setTranslationX(-position*page.getWidth());
       page.setPivotX(0);
       page.setPivotY(0);
       page.setCameraDistance(100);

       float pos = Math.abs(position);

       if(pos<-1)
           page.setAlpha(0);

       if(position<=0){
           page.setRotation(90*pos);
           page.setAlpha(1-pos);

       }
       else if(position<1) {
           page.setRotation(0);
           page.setAlpha(1);
       }

        else
            page.setAlpha(0);

    }
    </code>


  <h2>Zoom Animation</h2>
  <p>
  <img src = "/images/Zoom animation.gif"></img>
  </p>
  
  <code>
  public class ZoomTransformation implements ViewPager.PageTransformer {

    int count = 0;

    final float MIN_SCALE = 0.85f;
    final float MIN_ALPHA = 0.3f;


    private final String TAG = "ZoomTransformation";

    @Override
    public void transformPage(View view, float position) {

        int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            }

            else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float alphaFactor = Math.max(MIN_ALPHA, 1 - Math.abs(position));

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                view.setAlpha(alphaFactor);

            } else { // (1,+Infinity]
                view.setAlpha(0);
            }
        }

    }

  </code>




























