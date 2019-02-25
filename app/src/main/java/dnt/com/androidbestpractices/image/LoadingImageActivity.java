package dnt.com.androidbestpractices.image;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import dnt.com.androidbestpractices.R;

public class LoadingImageActivity extends AppCompatActivity {

    @BindView(R.id.loading_image)
    ImageView loadingImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_image);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Picasso.with(this).load("https://images.unsplash.com/photo-1488217820102-3ef7cfe8bb4e?dpr=1&auto=compress,format&fit=crop&w=2700&h=&q=80&cs=tinysrgb&crop=").placeholder(R.drawable.progress_animation).into(loadingImage);
    }

}
