package com.xiaoming.giftspeak;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaoming.giftspeak.app.LoginActivity;
import com.xiaoming.giftspeak.app.SearchActivity;
import com.xiaoming.giftspeak.fragment.ClassifyFragment;
import com.xiaoming.giftspeak.fragment.GuideFragment;
import com.xiaoming.giftspeak.fragment.HotFragment;
import com.xiaoming.giftspeak.fragment.MineFragment;


import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragmentList = new ArrayList<>();
    private TextView topName;
    private RadioGroup rgTab;
    private RadioButton[] rbTitle;
    private int preIndex;
    private ImageView ivSign;
    private ImageView ivSearch;
    private RelativeLayout rlTop;
    private long exitTime = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initListener();
    }

    private void initData() {
        GuideFragment fragment1= GuideFragment.newInstance(null);
        HotFragment fragment2= HotFragment.newInstance(null);
        ClassifyFragment fragment3= ClassifyFragment.newInstance(null);
        MineFragment fragment4= MineFragment.newInstance(null);

        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);

        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transation=manager.beginTransaction();
        transation.add(R.id.fragment_drawer,fragmentList.get(0));

        transation.commit();
    }

    private void initListener() {
        rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i <rbTitle.length ; i++) {
                    if(checkedId==rbTitle[i].getId()){
                        switchFragment(i);
                    }
                }
                switch (checkedId){
                    case R.id.rb_guide:
                            topName.setText("礼物说");
                            rlTop.setVisibility(View.VISIBLE);
                            ivSign.setVisibility(View.VISIBLE);
                            ivSearch.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_hot:
                        topName.setText("热门");
                        ivSign.setVisibility(View.GONE);
                        ivSearch.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_classify:
                        topName.setText("攻略单品");
                        ivSign.setVisibility(View.GONE);
                        ivSearch.setVisibility(View.GONE);
                        break;
                    case R.id.rb_mine:
                        rlTop.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }

    private void switchFragment(int i) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transation=manager.beginTransaction();
        Fragment fragment=fragmentList.get(i);
        Fragment preFragment=fragmentList.get(preIndex);
        if(!fragment.isAdded()){
            transation.hide(preFragment).add(R.id.fragment_drawer,fragment);
        }else{
            transation.hide(preFragment).show(fragment);
        }
        preIndex=i;
        transation.commit();
    }


    private void initView() {
        rlTop = (RelativeLayout) findViewById(R.id.rl_top);
        ivSign = (ImageView) findViewById(R.id.iv_sign);
        ivSearch = (ImageView) findViewById(R.id.iv_search);
        topName = (TextView) findViewById(R.id.tv_topName);
        rgTab = (RadioGroup) findViewById(R.id.rg_main);
        rbTitle=new RadioButton[rgTab.getChildCount()];
        for (int i = 0; i <rbTitle.length ; i++) {
            rbTitle[i]= (RadioButton) rgTab.getChildAt(i);
            rbTitle[i].setTag(i);
        }
        checkRadioButton(0);
    }

    private void checkRadioButton(int position) {
        for (int i = 0; i < rbTitle.length; i++) {
            if (i == position) {
                rbTitle[i].setChecked(true);
            } else {
                rbTitle[i].setChecked(false);
            }
        }
    }

    public void onSignIn(View view){
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
    public void onSearch(View view){
        Intent intent=new Intent(MainActivity.this,SearchActivity.class);
        startActivity(intent);
    }

    //    设置按两次返回键 退出的效果
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
