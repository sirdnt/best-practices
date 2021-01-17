package dnt.com.androidbestpractices.androidx.databinding.ui.databinding;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

public class DataBindingViewModel extends ViewModel {

    private LiveData<String> title;



    public LiveData<String> getTitle() {
        return title;
    }
}
