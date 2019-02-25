package dnt.com.androidbestpractices;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

import static dnt.com.androidbestpractices.Constant.ADMOB_APP_ID;


public class AndroidBestPracticesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this,ADMOB_APP_ID);
    }

}
