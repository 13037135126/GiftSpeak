package com.xiaoming.giftspeak.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaoming.giftspeak.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/6/29.
 */
public class GuideFragment extends Fragment{

    private View view;
    private TabLayout tabLayout;
    private List<Fragment> mFragmentList = new ArrayList<>();
    //当前位置
    private int curIndex;
    private String[] tabName = {
            "精选", "海淘","创意生活","送女票","科技苑","送爸妈",
            "送基友","送闺蜜","送同事","送宝贝","设计感","文艺风"
            ,"奇葩搞怪","萌萌哒"
    };
    private Context mContext;



    public static GuideFragment newInstance(Bundle args){
        GuideFragment fragment=new GuideFragment();
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
        //加载界面
        view=inflater.inflate(R.layout.fragment_guide,null);
        //tabLayout初始化
        tabLayout= (TabLayout) view.findViewById(R.id.guide_index_tl);
        //加载数据
        initData();
        //初始化控件
        initView();
        //初始化监听
        initListener();
        //添加头部视图
        setupHeaderView();

        return view;
    }

    private void setupHeaderView() {
        View headerView=LayoutInflater.from(mContext).inflate(R.layout.fragment_header_view,null);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initListener() {

    }

    private void initView() {
        FragmentManager manager=getChildFragmentManager();
        FragmentTransaction transation=manager.beginTransaction();
        transation.add(R.id.fl_guide,mFragmentList.get(0));
        transation.commit();
        curIndex=0;
    }

    private void initData() {
        //给TabLayout动态加载内容，加载Fragment数据
        for (int i = 0; i <tabName.length ; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabName[i]));
        }
        //根据tab的位置来更换Fragment
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switchFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        initFragmentList();
        
    }

    private void initFragmentList() {
        mFragmentList.add(WellChosenFragment.newInstance(null));
        for (int i = 0; i <13 ; i++) {
            mFragmentList.add(OthersFragment.newInstance(null));
        }

    }

    private void switchFragment(int position) {
        FragmentManager manager=getChildFragmentManager();
        FragmentTransaction transation=manager.beginTransaction();
        Fragment fragment=mFragmentList.get(position);
        if (!fragment.isAdded()){
            transation.hide(mFragmentList.get(curIndex)).add(R.id.fl_guide,fragment);
        }else{
            transation.hide(mFragmentList.get(curIndex)).show(fragment);
        }
        transation.commit();
        curIndex=position;
    }
}
