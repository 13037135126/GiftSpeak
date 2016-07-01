package com.xiaoming.giftspeak.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.google.gson.Gson;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.squareup.picasso.Picasso;
import com.xiaoming.giftspeak.R;
import com.xiaoming.giftspeak.bean.BannerInfo;
import com.xiaoming.giftspeak.constant.UrlConfig;
import com.xiaoming.giftspeak.utils.IOKCallBack;
import com.xiaoming.giftspeak.utils.OkHttpTool;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by my on 2016/6/27.
 */
public class WellChosenFragment extends Fragment{

    private View view;
    @BindView(R.id.wellchosen_list)
    ExpandableListView expandableListView;
    private Context mContext;
    HeaderViewHolder headerViewHolder;
    private List<BannerInfo.DataBean.BannersBean> imageDatas = new ArrayList<>();
    public HeaderRVAdapter headerRVAdapter;

    public static WellChosenFragment newInstance(Bundle args){
        WellChosenFragment fragment=new WellChosenFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_well_chosen,container,false);
        ButterKnife.bind(this,view);
        setupHeaderView();
        setupExpandListView();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    //添加头部视图
    private void setupHeaderView() {
        View headerView=LayoutInflater.from(mContext).inflate(R.layout.fragment_header_view,null);
        headerViewHolder=new HeaderViewHolder(headerView);
        setupHeaderRecyclerView(headerViewHolder);
        //动态加载数据
        loadBannerDatas();
        setupBanner(headerViewHolder);
        expandableListView.addHeaderView(headerView);
    }

    private void loadBannerDatas() {
        OkHttpTool.newInstance().start(UrlConfig.BANNER_URL).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();
                BannerInfo bannerInfo=gson.fromJson(result,BannerInfo.class);
                imageDatas.addAll(bannerInfo.getData().getBanners());
                headerViewHolder.convenientBanner.getViewPager().getAdapter().notifyDataSetChanged();
            }
        });
    }

    private void setupBanner(HeaderViewHolder headerViewHolder) {

        headerViewHolder.convenientBanner.setPages(new CBViewHolderCreator<HeaderBannerViewHolder>(){
            @Override
            public HeaderBannerViewHolder createHolder() {
                return new HeaderBannerViewHolder();
            }
        },imageDatas)
                .setPageIndicator(new int[]{R.drawable.btn_check_disabled_nightmode,R.drawable.btn_check_normal})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
    }

    class HeaderBannerViewHolder implements Holder<BannerInfo.DataBean.BannersBean>{
        ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView=new ImageView(context);
            return imageView;
        }
        @Override
        public void UpdateUI(Context context, int position, BannerInfo.DataBean.BannersBean data) {
            Picasso.with(mContext).load(data.getImage_url()).into(imageView);
        }
    }

    /**
     * 初始化头部RecyclerView
     * @param headerViewHolder
     */
    private void setupHeaderRecyclerView(HeaderViewHolder headerViewHolder) {
        //创建布局管理器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
        headerViewHolder.mRecyclerView.setLayoutManager(linearLayoutManager);
        //创建一个适配器
        headerRVAdapter=new HeaderRVAdapter();
        headerViewHolder.mRecyclerView.setAdapter(headerRVAdapter);

    }

    private void setupExpandListView() {

    }

    class HeaderViewHolder {
        @BindView(R.id.header_view_rv)
        RecyclerView mRecyclerView;
        @BindView(R.id.header_view_cb)
        ConvenientBanner convenientBanner;

        public HeaderViewHolder(View headerView){
            ButterKnife.bind(this,headerView);
        }
    }

    private class HeaderRVViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public HeaderRVViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView;
        }
    }

    //创建适配器
    private class HeaderRVAdapter extends RecyclerView.Adapter<HeaderRVViewHolder>{
        @Override
        public HeaderRVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ImageView imageView=new ImageView(mContext);
            return new HeaderRVViewHolder(imageView);
        }

        @Override
        public void onBindViewHolder(HeaderRVViewHolder holder, int position) {
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }


}
