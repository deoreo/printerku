package id.enlight.printerku.Activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.HashMap;

import id.enlight.printerku.R;
import id.enlight.printerku.Utilities.kbv.KenBurnsView;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class ActivitySplashScreen extends Activity {

    public static final String SPLASH_SCREEN_OPTION = "id.enlight.printerku.Activity.ActivitySplashScreen";
    public static final String SPLASH_SCREEN_OPTION_1 = "Fade in + Ken Burns";
    public static final String SPLASH_SCREEN_OPTION_2 = "Down + Ken Burns";
    public static final String SPLASH_SCREEN_OPTION_3 = "Down + fade in + Ken Burns";

    private KenBurnsView mKenBurns;
    private ImageView mLogo;
    private LinearLayout welcomeText;
    private ProgressBar mProgressBar;
    private int mWaited = 0;
    private Activity mActivity;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE); //Removing ActionBar
        setContentView(R.layout.activity_splash_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mActivity = this;
        ctx = this;
        mProgressBar = (ProgressBar) findViewById(R.id.splash_progress);
        mKenBurns = (KenBurnsView) findViewById(R.id.ken_burns_images);
        mLogo = (ImageView) findViewById(R.id.logo);
        welcomeText = (LinearLayout) findViewById(R.id.welcome_title);
        String category = SPLASH_SCREEN_OPTION_1;
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(SPLASH_SCREEN_OPTION)) {
            category = extras.getString(SPLASH_SCREEN_OPTION, SPLASH_SCREEN_OPTION_1);
        }
        setAnimation(category);



    }

    @Override
    public void onBackPressed() {
        finish();
    }

    /** Animation depends on category.
     * */
    private void setAnimation(String category) {
        if (category.equals(SPLASH_SCREEN_OPTION_1)) {
            mKenBurns.setImageResource(R.drawable.pic);
            animation1();
            animation3();
        } else if (category.equals(SPLASH_SCREEN_OPTION_2)) {
            //mLogo.setTextColor(R.color.main_color_500);
            mKenBurns.setImageResource(R.drawable.pic);
            animation2();
        } else if (category.equals(SPLASH_SCREEN_OPTION_3)) {
            mKenBurns.setImageResource(R.drawable.pic);
            animation2();
            animation3();
        }

        final Thread splashThread = new Thread() {
            @Override
            public void run() {
                try {

                    for (int i = 0; i <= 1000; i++) {
                        sleep(4);
                        mProgressBar.setProgress(mWaited / 10);
                        mWaited += 1;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                }
            }
        };
        splashThread.start();
    }

    private void animation1() {
        ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(mLogo, "scaleX", 5.0F, 1.0F);
        scaleXAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleXAnimation.setDuration(1200);
        ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(mLogo, "scaleY", 5.0F, 1.0F);
        scaleYAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleYAnimation.setDuration(1200);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(mLogo, "alpha", 0.0F, 1.0F);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setDuration(1200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleXAnimation).with(scaleYAnimation).with(alphaAnimation);
        animatorSet.setStartDelay(500);
        animatorSet.start();
    }

    private void animation2() {
        mLogo.setAlpha(1.0F);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate_top_to_center);
        mLogo.startAnimation(anim);
    }

    private void animation3() {
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(welcomeText, "alpha", 0.0F, 1.0F);
        alphaAnimation.setStartDelay(1700);
        alphaAnimation.setDuration(500);
        alphaAnimation.start();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private class RefreshToken extends AsyncTask<String, Void, String> {
        String message="";
        private Activity activity;
        private Context context;
        private Resources resources;
        private ProgressDialog progressDialog;
        String error = "";

        public RefreshToken(Activity activity) {
            super();
            this.activity = activity;
            this.context = activity.getApplicationContext();
            this.resources = activity.getResources();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            try {


                return "OK";

            } catch (Exception e) {
                e.printStackTrace();
            }
            return "FAIL";

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            //progressDialog.dismiss();
            switch (result) {
                case "FAIL":
                    break;
                case "OK":
                    break;
            }
        }


    }

}

