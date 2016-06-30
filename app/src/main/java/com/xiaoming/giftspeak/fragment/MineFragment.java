package com.xiaoming.giftspeak.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by my on 2016/6/29.
 */
public class MineFragment extends Fragment{

    public static MineFragment newInstance(Bundle args){
        MineFragment fragment=new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
