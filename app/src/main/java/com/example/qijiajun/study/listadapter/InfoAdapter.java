package com.example.qijiajun.study.listadapter;

import android.content.Context;

import com.example.qijiajun.study.R;
import com.example.qijiajun.study.listbean.Infomation;
import com.zhy.adapter.abslistview.MultiItemTypeAdapter;
import com.zhy.adapter.abslistview.ViewHolder;
import com.zhy.adapter.abslistview.base.ItemViewDelegate;

import java.util.List;

/**
 * Created by qijiajunmac on 2016/12/19.
 */

public class InfoAdapter extends MultiItemTypeAdapter<Infomation> {

    public InfoAdapter(Context context, List<Infomation> datas) {
        super(context, datas);
        addItemViewDelegate(new ItemViewDelegate<Infomation>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.list_item;
            }

            @Override
            public boolean isForViewType(Infomation item, int position) {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, Infomation infomation, int position) {
                holder.setImageResource(R.id.iv_picture_item,infomation.getiPicture());
                holder.setText(R.id.tv_content_item,infomation.getiContent());
                holder.setText(R.id.tv_date_item,infomation.getiDate());
            }
        });
    }
}
