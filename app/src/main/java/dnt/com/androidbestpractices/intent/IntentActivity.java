package dnt.com.androidbestpractices.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import dnt.com.androidbestpractices.R;
import dnt.com.androidbestpractices.intro.IntroActivity;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
    }

    public void buttonExplicitIntentClick(View v) {
        Intent intentIntoActivity = new Intent(this, IntroActivity.class);
        this.startActivity(intentIntoActivity);
    }

    public void buttonImplicitIntentClick(View v) {
        Intent intentViewWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com.vn"));
        this.startActivity(intentViewWeb);
    }
}
