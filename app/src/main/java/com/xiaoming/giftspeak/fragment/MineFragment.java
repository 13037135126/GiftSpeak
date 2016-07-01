package com.xiaoming.giftspeak.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xiaoming.giftspeak.R;
import com.xiaoming.giftspeak.app.LoginActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/6/29.
 */
public class MineFragment extends Fragment{


    private TabLayout tabLayout;
    private String []tabName={"单品","攻略"};
    private List<Fragment> mFragmentList = new ArrayList<>();
    private int curIndex;
    private LinearLayout linearLayout;
    private ImageView ivLogin;
    private View view;

    public static MineFragment newInstance(Bundle args){
        MineFragment fragment=new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_mine,null);


        initData();
        initView();


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }



    private void initView() {

    }

    private void initData() {

    }


}
