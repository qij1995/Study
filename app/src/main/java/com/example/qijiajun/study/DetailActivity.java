package com.example.qijiajun.study;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hietk.common.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends BaseActivity {

    @Bind(R.id.iv_affiche_detail)
    ImageView ivAfficheDetail;
    @Bind(R.id.tv_content_detail)
    TextView tvContentDetail;
    @Bind(R.id.tv_date_detail)
    TextView tvDateDetail;
    @Bind(R.id.ll_back_detail)
    LinearLayout llBackDetail;
    @Bind(R.id.activity_detail)
    LinearLayout activityDetail;

    @Override
    public void initView() {
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Bundle bundle = this.getIntent().getExtras();
        int mPicture = bundle.getInt("picture");
        String mContent = bundle.getString("content");
        String mDate = bundle.getString("date");
        ivAfficheDetail.setImageResource(mPicture);
        tvContentDetail.setText(mContent);
        tvDateDetail.setText(mDate);
    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.ll_back_detail)
    public void onClick() {
        onBackPressed();
    }
}
