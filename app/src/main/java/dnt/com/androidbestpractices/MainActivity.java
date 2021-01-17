package dnt.com.androidbestpractices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dnt.com.androidbestpractices.ads.admob.AdmobActivity;
import dnt.com.androidbestpractices.androidx.databinding.DataBindingActivity;
import dnt.com.androidbestpractices.button.ButtonActivity;
import dnt.com.androidbestpractices.communicate.CommunicateFragmentActivity;
import dnt.com.androidbestpractices.filter.FilterActivity;
import dnt.com.androidbestpractices.image.LoadingImageActivity;
import dnt.com.androidbestpractices.intent.IntentActivity;
import dnt.com.androidbestpractices.intro.IntroActivity;
import dnt.com.androidbestpractices.navigationdrawer.NavigationDrawerActivity;
import dnt.com.androidbestpractices.pager.adaperstate.PagerAdapterActivity;
import dnt.com.androidbestpractices.setting.SettingsActivity;
import dnt.com.androidbestpractices.tabbar.TabBarActivity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_list)
    RecyclerView mMainList;

    private List<ActivityInformation> listActivities;

    private final String TAG = this.getClass().getSimpleName();

    private void generateData() {
        listActivities = new ArrayList<>();
        listActivities.add(new ActivityInformation(IntroActivity.class, "Intro activity", "Describe how app intro showing"));
        listActivities.add(new ActivityInformation(IntentActivity.class, "Intent activity", "Describe how to use implicit and explicit intents"));
        listActivities.add(new ActivityInformation(FilterActivity.class, "Filterable RecyclerView", "Describe how to implement filter with RecyclerView"));
        listActivities.add(new ActivityInformation(DataBindingActivity.class, "AndroidX data binding","Describe data binding"));
        listActivities.add(new ActivityInformation(TabBarActivity.class, "Tab bar", "Sample for tab bar"));
        listActivities.add(new ActivityInformation(NavigationDrawerActivity.class, "Navigation drawer", "Sample for navigation drawer design principle"));
        listActivities.add(new ActivityInformation(CommunicateFragmentActivity.class, "Communicate activity and fragment", "This describe how to communicate between activity and fragments"));
        listActivities.add(new ActivityInformation(ButtonActivity.class,"Material Button","Sample material design button style"));
        listActivities.add(new ActivityInformation(LoadingImageActivity.class,"Loading image button","Showing loading image using animation"));
        listActivities.add(new ActivityInformation(PagerAdapterActivity.class,"PagerAdapter","Describe how to use pager adapter"));
        listActivities.add(new ActivityInformation(AdmobActivity.class,"Admob ads","Describe how to integrate admob"));
        listActivities.add(new ActivityInformation(SettingsActivity.class, "Settings fragment", "Describe how to add a setting activity using fragment setting"));
    }

    //region activity life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        generateData();
        mMainList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mMainList.setLayoutManager(linearLayoutManager);
        mMainList.setAdapter(new MainAdapter(this.listActivities));
    }
    //endregion
}

/*
* class for describe an activity info, what title and what description it is
*
* @Data annotation of Lombok, it auto generate getter, setter, toString method
* */
@Data
class ActivityInformation {
    //region properties
    private Class activityClass;
    private String title;
    private String subtitle;
    //endregion

    public ActivityInformation(Class activityClass, String title, String subtitle) {
        this.activityClass = activityClass;
        this.title = title;
        this.subtitle = subtitle;
    }
}

class MainAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<ActivityInformation> listActivities;

    public MainAdapter(List<ActivityInformation> listActivities) {
        this.listActivities = listActivities;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_main_cell, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ActivityInformation activityInformation = this.listActivities.get(position);
        holder.bind(activityInformation);
    }

    @Override
    public int getItemCount() {
        return this.listActivities.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.main_cell_title)
    @Getter
    protected TextView title;

    @BindView(R.id.main_cell_subtitle)
    @Getter
    protected TextView subtitle;

    @Getter
    @Setter
    protected ActivityInformation currentActivityInformation;

    public ViewHolder(final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemView.getContext().startActivity(new Intent(itemView.getContext(), currentActivityInformation.getActivityClass()));
            }
        });
    }

    public void bind(ActivityInformation activityInformation) {
        setCurrentActivityInformation(activityInformation);
        getTitle().setText(activityInformation.getTitle());
        getSubtitle().setText(activityInformation.getSubtitle());
    }

}