package com.xiaoming.giftspeak.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by my on 2016/6/29.
 */
public class ClassifyFragment extends Fragment{

    public static ClassifyFragment newInstance(Bundle args){
        ClassifyFragment fragment=new ClassifyFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
