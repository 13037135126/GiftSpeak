package com.xiaoming.giftspeak.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaoming.giftspeak.R;

/**
 * Created by my on 2016/6/27.
 */
public class OthersFragment extends Fragment{

    public static OthersFragment newInstance(Bundle args){
        OthersFragment fragment=new OthersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
