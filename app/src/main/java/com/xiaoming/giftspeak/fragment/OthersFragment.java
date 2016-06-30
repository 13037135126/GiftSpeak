package com.xiaoming.giftspeak.fragment;

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

    public static OthersFragment newInstance(){
        OthersFragment fragment=new OthersFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_well_chosen,container,false);
    }
}
