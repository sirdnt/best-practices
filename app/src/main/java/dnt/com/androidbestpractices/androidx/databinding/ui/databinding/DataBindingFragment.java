package dnt.com.androidbestpractices.androidx.databinding.ui.databinding;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dnt.com.androidbestpractices.R;
import dnt.com.androidbestpractices.databinding.DataBindingFragmentBinding;


public class DataBindingFragment extends Fragment {

    private DataBindingFragmentBinding mBinding;
    private DataBindingViewModel mViewModel;

    public static DataBindingFragment newInstance() {
        return new DataBindingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.data_binding_fragment, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DataBindingViewModel.class);
        mBinding.setModel(mViewModel);
    }

}
