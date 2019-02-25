package dnt.com.androidbestpractices.ads.admob;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dnt.com.androidbestpractices.R;

import static dnt.com.androidbestpractices.Constant.ADMOB_ADS_INTERSTITIAL;

public class AdmobActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admob);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.aa_btn_show_interstitial)
    public void showInterstitialAds(Button button) {

        RelativeLayout layout = new RelativeLayout(this);
        progressBar = new ProgressBar(this,null,android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.VISIBLE);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100,100);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        layout.addView(progressBar,params);
        setContentView(layout);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(ADMOB_ADS_INTERSTITIAL);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("54A09697D3F8289DD585264F83078A7F").build();
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                setContentView(R.layout.activity_admob);
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
                setContentView(R.layout.activity_admob);
            }
        });
    }
}
