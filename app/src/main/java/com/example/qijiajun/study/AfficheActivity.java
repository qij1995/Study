package com.example.qijiajun.study;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.example.qijiajun.study.homepage.view.MyListView;
import com.example.qijiajun.study.listadapter.AfficheAdapter;
import com.example.qijiajun.study.listbean.Affiche;
import com.hietk.common.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.qijiajun.study.R.drawable.view;

public class AfficheActivity extends BaseActivity {

    @Bind(R.id.ll_back_afficheactivity)
    LinearLayout llBackAfficheactivity;
    @Bind(R.id.lv_listview_afficheactivity)
    MyListView lvListviewAfficheactivity;
    private String affiche = "不正确";
    private String Aaff = "不正确";

    @Override
    public void initView() {
        Log.e("affiche", affiche);
        setContentView(R.layout.activity_affiche);
        Log.e("activity_affiche", Aaff);
        ButterKnife.bind(this);
        lvListviewAfficheactivity.setDivider(getResources().getDrawable(view));
        lvListviewAfficheactivity.setAdapter(new AfficheAdapter(this, Affiche.MOCK_DATAS));
        lvListviewAfficheactivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AfficheActivity.this, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("picture", Affiche.MOCK_DATAS.get(position).getPicture());
                bundle.putString("content", Affiche.MOCK_DATAS.get(position).getContent());
                bundle.putString("date", Affiche.MOCK_DATAS.get(position).getDate());
                intent.putExtras(bundle);
                startActivity(intent, bundle);
            }
        });
    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.ll_back_afficheactivity)
    public void onClick() {
        onBackPressed();

    }

}
