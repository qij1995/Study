package com.example.qijiajun.study.homepage.view.databindingbean;

/**
 * Created by qijiajunmac on 2016/12/11.
 */

public class Image {
    public final int mofficialwebsite;
    public final int mcard;
    public final int mmall;
    public final int mclass;

    public Image(int mofficialwebsite,int mcard,int mmall,int mclass)
    {
        this.mofficialwebsite=mofficialwebsite;
        this.mcard=mcard;
        this.mmall=mmall;
        this.mclass=mclass;
    }


    public int getMclass() {
        return mclass;
    }

    public int getMofficialwebsite() {
        return mofficialwebsite;
    }

    public int getMcard() {
        return mcard;
    }

    public int getMmall() {
        return mmall;
    }




}
