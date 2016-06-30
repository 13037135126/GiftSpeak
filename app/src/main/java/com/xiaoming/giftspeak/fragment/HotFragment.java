package com.xiaoming.giftspeak.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by my on 2016/6/29.
 */
public class HotFragment extends Fragment{

    public static HotFragment newInstance(Bundle args){
        HotFragment fragment=new HotFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
