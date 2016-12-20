package com.example.qijiajun.study.listadapter;


import android.content.Context;

import com.example.qijiajun.study.R;
import com.example.qijiajun.study.listbean.Affiche;
import com.zhy.adapter.abslistview.MultiItemTypeAdapter;
import com.zhy.adapter.abslistview.ViewHolder;
import com.zhy.adapter.abslistview.base.ItemViewDelegate;

import java.util.List;

import static com.example.qijiajun.study.R.mipmap.picture;


/**
 * Created by qijiajunmac on 2016/12/19.
 */

public class AfficheAdapter extends MultiItemTypeAdapter<Affiche>{

    public AfficheAdapter(final Context context, List<Affiche> datas) {
        super(context, datas);
        addItemViewDelegate(new ItemViewDelegate<Affiche>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.list_item;
            }

            @Override
            public boolean isForViewType(Affiche item, int position) {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, Affiche affiche, int position) {
                holder.setImageResource(R.id.iv_picture_item,affiche.getPicture());
                holder.setText(R.id.tv_content_item,affiche.getContent());
                holder.setText(R.id.tv_date_item,affiche.getDate());
            }
        });
    }




}
