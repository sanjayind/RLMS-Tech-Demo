package com.rlms.activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rlms.R;
import com.rlms.utils.SharedPreferencesUtil;

public class SplashPageActivity extends AppCompatActivity {

    private ImageView mImageView;
    private ProgressBar mProgressbar;
    private TextView mTryAgainTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);
        initializeViews();
        setupSplashPageAnimation();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * At start,
     * Loading view is disabled,
     * Try Again View is disabled,
     */
    private void initializeViews() {
        mImageView = (ImageView) findViewById(R.id.splash_page_icon_view);
        mProgressbar = (ProgressBar) findViewById(R.id.loading_view);
        mProgressbar.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.colorPrimaryDark), PorterDuff.Mode.SRC_IN);
        mTryAgainTextView = (TextView) findViewById(R.id.splash_try_again);

        mTryAgainTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTryAgainTextView.setVisibility(View.GONE);
                mProgressbar.setVisibility(View.VISIBLE);
//                loginAsGuestUser();
            }
        });

        mProgressbar.setVisibility(View.INVISIBLE);
        mTryAgainTextView.setVisibility(View.INVISIBLE);
    }

    /**
     * Animation setup for splash page branding image
     */
    private void setupSplashPageAnimation() {
        Animation slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_slide_up);
        mImageView.startAnimation(slideUpAnimation);
        slideUpAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mProgressbar.setVisibility(View.VISIBLE);
                SharedPreferencesUtil sharedPreferencesUtil = new SharedPreferencesUtil();
                String userId = sharedPreferencesUtil.getUserId(SplashPageActivity.this);
                if (userId != null) {
                    Intent intent = new Intent(SplashPageActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashPageActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    /**
     * 1. If user exists, then go to landing/main page
     */
    protected void performUserLogin() {
//        final UserDao userDao = new UserDao();
//        UserDataManager.getInstance().setAppUser(userDao.getUser());
//        User user = UserDataManager.getInstance().getAppUser();//User.getUser();
//        if (user != null && !TextUtils.isEmpty(user.getAccessToken())) {
//            validateTenantSetting();
//        } else {
//            loginAsGuestUser();
//        }
    }
}
