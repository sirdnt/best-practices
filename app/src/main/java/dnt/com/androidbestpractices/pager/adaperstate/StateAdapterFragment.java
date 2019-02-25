package dnt.com.androidbestpractices.pager.adaperstate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import dnt.com.androidbestpractices.R;
import lombok.Setter;

public class StateAdapterFragment extends Fragment {

    @BindView(R.id.fsa_image_view)
    ImageView mMainImage;

    @Setter
    private String mImageURL;

    public StateAdapterFragment() {
    }

    public static StateAdapterFragment newInstance(String imageUrl) {
        StateAdapterFragment fragment = new StateAdapterFragment();
        // Supply num input as an argument.
        fragment.setMImageURL(imageUrl);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_state_adapter, container, false);
        ButterKnife.bind(this,fragmentView);

        if (mImageURL != null) {
            Picasso.with(getContext()).load(mImageURL).placeholder(R.drawable.progress_animation).into(mMainImage);
        } else {
            Log.e(getTag(),"mImageURL null can not load image");
        }
        return fragmentView;
    }

}
