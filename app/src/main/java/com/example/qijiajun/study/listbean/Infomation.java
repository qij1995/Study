package com.example.qijiajun.study.listbean;

import com.example.qijiajun.study.R;
import com.example.qijiajun.study.homepage.view.InfoFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.qijiajun.study.R.mipmap.picture;
import static com.example.qijiajun.study.listbean.Affiche.MOCK_DATAS;

/**
 * Created by qijiajunmac on 2016/12/19.
 */

public class Infomation {
    private int iPicture;
    private String iContent;
    private String iDate;

    public Infomation(int iPicture, String iContent, String iDate) {
        this.iPicture = iPicture;
        this.iContent = iContent;
        this.iDate = iDate;
    }

    public int getiPicture() {
        return iPicture;
    }

    public void setiPicture(int iPicture) {
        this.iPicture = iPicture;
    }

    public String getiContent() {
        return iContent;
    }

    public void setiContent(String iContent) {
        this.iContent = iContent;
    }

    public String getiDate() {
        return iDate;
    }

    public void setiDate(String iDate) {
        this.iDate = iDate;
    }



    public static List<Infomation> INFO_MOCK_DATAS =new ArrayList<>();
    static {
        Infomation infomation=null;
        infomation=new Infomation(picture,"资讯1资讯2资讯3资讯4","2016-12-19");
        INFO_MOCK_DATAS.add(infomation);
        infomation=new Infomation(picture,"资讯1资讯2资讯3资讯4资讯5","2016-12-19");
        INFO_MOCK_DATAS.add(infomation);
        infomation=new Infomation(picture,"资讯1资讯2资讯4","2016-12-19");
        INFO_MOCK_DATAS.add(infomation);
        infomation=new Infomation(picture,"资讯1资讯3资讯4","2016-12-19");
        INFO_MOCK_DATAS.add(infomation);
        infomation=new Infomation(picture,"资讯2资讯3资讯4","2016-12-19");
        INFO_MOCK_DATAS.add(infomation);
        infomation=new Infomation(picture,"资讯1资讯2资讯4","2016-12-19");
        INFO_MOCK_DATAS.add(infomation);
        infomation=new Infomation(picture,"资讯1资讯3资讯4","2016-12-19");
        INFO_MOCK_DATAS.add(infomation);
        infomation=new Infomation(picture,"资讯1资讯2资讯3资讯4资讯5","2016-12-19");
        INFO_MOCK_DATAS.add(infomation);
    }
}
