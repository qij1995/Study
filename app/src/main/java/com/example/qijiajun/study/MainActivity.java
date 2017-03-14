package com.example.qijiajun.study;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.qijiajun.study.homepage.view.AfficheFragment;
import com.example.qijiajun.study.homepage.view.InfoFragment;
import com.example.qijiajun.study.homepage.view.utils.ViewFindUtils;
import com.flyco.tablayout.SegmentTabLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    @Bind(R.id.rl_address_homepage)
    RelativeLayout rlAddressHomepage;
    @Bind(R.id.tv_address_homepage)
    TextView tvAddressHomepage;
    private String[] mTitles = {"公告", "资讯"};
    private ArrayList<Fragment> mFragment = new ArrayList<>();
    private Banner banner;
    private String Amai = "正确main";
    private String fmain = "正确main";
    String[] mImage = new String[]{"http://pic.pp3.cn/uploads//201608/20160801009.jpg", "https://d13yacurqjgara.cloudfront.net/users/1354463/screenshots/3165610/parallel_newyorktimes_1x.jpg", "https://d13yacurqjgara.cloudfront.net/users/37624/screenshots/3159632/designingwordswithdata_1x.jpg"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("main", fmain);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.e("activity_main", Amai);
        AfficheFragment afficheFragment = new AfficheFragment();
        InfoFragment infoFragment = new InfoFragment();
        mFragment.add(afficheFragment);
        mFragment.add(infoFragment);
        View mDecorView = getWindow().getDecorView();
        SegmentTabLayout navigationBarMid = ViewFindUtils.find(mDecorView, R.id.st_navigationbarmid_homepage);
        navigationBarMid.setTabData(mTitles, this, R.id.ll_notice_homepage, mFragment);
        banner = (Banner) findViewById(R.id.ba_banner_homepage);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImages(mImage);
    }

    @OnClick(R.id.rl_address_homepage)
    public void onClick() {
        Intent intent = new Intent(MainActivity.this, AddressActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1||resultCode==3){
        tvAddressHomepage.setText(data.getExtras().getString("city"));
        Log.e("地址",data.getExtras().getString("city"));
        }
    }
}
