package dnt.com.androidbestpractices.androidx.databinding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import dnt.com.androidbestpractices.R;
import dnt.com.androidbestpractices.androidx.databinding.ui.databinding.DataBindingFragment;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_binding_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, DataBindingFragment.newInstance())
                    .commitNow();
        }
    }
}
