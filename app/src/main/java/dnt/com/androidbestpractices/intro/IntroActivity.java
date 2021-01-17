package dnt.com.androidbestpractices.intro;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Arrays;

import dnt.com.androidbestpractices.R;
import lombok.NonNull;

public class IntroActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private static final String TAG = IntroActivity.class.getSimpleName();

    private Button mBtnNext;
    private ViewPager mViewPager;
    private IntroPagerAdapter mAdapter;
    private int[] mLayouts = {R.layout.intro_slide_1,
            R.layout.intro_slide_2,
            R.layout.intro_slide_3,
            R.layout.intro_slide_4};
    private int[] mDotLayouts = {R.id.dot_1, R.id.dot_2, R.id.dot_3, R.id.dot_4};
    private View[] mDotViews = new View[4];
    private float dotSelectedAlpha = 1.0f;
    private float dotDefaultAlpha = 0.4f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mBtnNext = findViewById(R.id.btn_next);
        mViewPager = findViewById(R.id.intro_view_pager);
        mViewPager.setOnPageChangeListener(this);
        mAdapter = new IntroPagerAdapter(mLayouts);
        mViewPager.setAdapter(mAdapter);
        for (int i = 0; i < mDotLayouts.length; i++) {
            mDotViews[i] = findViewById(mDotLayouts[i]);
            mDotViews[i].setAlpha(dotDefaultAlpha);
        }
        mDotViews[0].setAlpha(dotSelectedAlpha);
    }

    public void buttonSkipSelected(View view) {
        Log.d(TAG, "buttonSkipSelected");
        finish();
    }

    public void buttonNextSelected(View view) {
        Log.d(TAG, "buttonNextSelected");
        if (mViewPager.getCurrentItem() >= mAdapter.getCount() - 1) {
            finish();
        } else {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
        Log.d(TAG, "onPageScrolled : " + i);

        //clear dot alpha
        for (View dot : mDotViews) {
            dot.setAlpha(dotDefaultAlpha);
        }
        mDotViews[i].setAlpha(dotSelectedAlpha);

        if (i == (mAdapter.getCount() - 1)) {
            mBtnNext.setText(getText(R.string.btn_got_it));
        } else {
            mBtnNext.setText(getText(R.string.btn_next));
        }
    }

    @Override
    public void onPageSelected(int i) {
        Log.d(TAG, "onPageSelected " + i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {
//        Log.d(TAG, "onPageScrollStateChanged " + i);
    }

    class IntroPagerAdapter extends PagerAdapter {

        int[] layouts;

        public IntroPagerAdapter(int[] layouts) {
            this.layouts = layouts;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            try {
                View view = (View) object;
                container.removeView(view);
            } catch (ClassCastException e) {
                Log.e(TAG, "destroyItem: " + Arrays.toString(e.getStackTrace()));
            }
        }
    }

}

