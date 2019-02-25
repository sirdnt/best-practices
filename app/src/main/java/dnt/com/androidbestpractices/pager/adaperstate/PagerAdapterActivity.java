package dnt.com.androidbestpractices.pager.adaperstate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dnt.com.androidbestpractices.R;

public class PagerAdapterActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_adater);
        ButterKnife.bind(this);
        MyFragmentStateAdapter pagerAdapter = new MyFragmentStateAdapter(getSupportFragmentManager(),listImages());
        mViewPager.setAdapter(pagerAdapter);
    }

    private List<String> listImages() {
        List<String> listImageUrls = new ArrayList<>();
        listImageUrls.add("http://palina.p.a.pic.centerblog.net/hb5yvh6a.jpg");
        listImageUrls.add("http://www.publicdomainpictures.net/pictures/170000/velka/portrait-background-1.jpg");
        listImageUrls.add("https://ae01.alicdn.com/kf/HTB1jIryIpXXXXagXpXXq6xXFXXXb/8x10ft-blue-bokeh-font-b-photography-b-font-backdrops-scenic-vinyl-print-font-b-photo-b.jpg");
        listImageUrls.add("https://s-media-cache-ak0.pinimg.com/originals/12/f4/65/12f4656a02310b4eee7873f40f48d7ee.jpg");
        listImageUrls.add("https://ae01.alicdn.com/kf/HTB1dHa4NXXXXXbVXpXXq6xXFXXXk/12ft-font-b-beach-b-font-wedding-vinyl-print-font-b-photography-b-font-backdrops-for.jpg");
        return listImageUrls;
    }
}

class MyFragmentStateAdapter extends FragmentStatePagerAdapter {

    List<String> mListUrls;

    public MyFragmentStateAdapter(FragmentManager fm, List<String> listUrls) {
        super(fm);
        this.mListUrls = listUrls;
    }

    @Override
    public Fragment getItem(int position) {
        return StateAdapterFragment.newInstance(mListUrls.get(position));
    }

    @Override
    public int getCount() {
        return mListUrls.size();
    }
}