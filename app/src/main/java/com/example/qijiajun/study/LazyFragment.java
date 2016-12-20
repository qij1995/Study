package com.example.qijiajun.study;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * Created by 纸折扇 on 2016/10/20.
 */

public abstract class LazyFragment extends Fragment {

    private boolean isVisible = false;//当前Fragment是否可见
    private boolean isInitView = false;//是否与View建立起映射关系
    private boolean isFirstLoad = true;//是否是第一次加载数据

    private View convertView;
    private SparseArray<View> mViews;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        convertView = initView(inflater);
        mViews = new SparseArray<>();
        isInitView = true;
        lazyLoadData();
        return convertView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        logUtil.m("context" + "   " + this.getClass().getSimpleName());

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
//        logUtil.m("isVisibleToUser " + isVisibleToUser + "   " + this.getClass().getSimpleName());
        if (isVisibleToUser) {
            isVisible = true;
            lazyLoadData();

        } else {
            isVisible = false;
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    private void lazyLoadData() {
        if (isFirstLoad) {
//            logUtil.m("第一次加载 " + " isInitView  " + isInitView + "  isVisible  " + isVisible + "   " + this.getClass().getSimpleName());
        } else {
//            logUtil.m("不是第一次加载" + " isInitView  " + isInitView + "  isVisible  " + isVisible + "   " + this.getClass().getSimpleName());
        }
        if (!isFirstLoad || !isVisible || !isInitView) {
//            logUtil.m("不加载" + "   " + this.getClass().getSimpleName());
            return;
        }

//        logUtil.m("完成数据第一次加载"+ "   " + this.getClass().getSimpleName());
        initData();
        isFirstLoad = false;
    }


    /**
     * 界面初始化
     *
     * @param inflater
     * @return
     */
    protected abstract View initView(LayoutInflater inflater);


    /**
     * 加载要显示的数据
     */
    protected abstract void initData();


}
