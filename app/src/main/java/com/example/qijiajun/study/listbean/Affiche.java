package com.example.qijiajun.study.listbean;

import com.example.qijiajun.study.R;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by qijiajunmac on 2016/12/19.
 */

public class Affiche {
    private int picture;
    private String content;
    private String date;

    public Affiche(int picture,String content,String date){
        this.picture=picture;
        this.content=content;
        this.date=date;
    }
    public String getDate() {
        return date;
    }

    public int getPicture() {
        return picture;
    }

    public String getContent() {
        return content;
    }
    public static List<Affiche> MOCK_DATAS=new ArrayList<>();
    static {
        Affiche affiche=null;
        affiche=new Affiche(R.mipmap.picture,"内容1内容2内容3内容4内容","2016-12-19");
        MOCK_DATAS.add(affiche);
        affiche=new Affiche(R.mipmap.picture,"内容1内容2","2016-12-19");
        MOCK_DATAS.add(affiche);
        affiche=new Affiche(R.mipmap.picture,"内容1内容2内容3","2016-12-19");
        MOCK_DATAS.add(affiche);
        affiche=new Affiche(R.mipmap.picture,"内容1内容2内容3内容4","2016-12-19");
        MOCK_DATAS.add(affiche);
        affiche=new Affiche(R.mipmap.picture,"内容1内容2内容3内容4内容5","2016-12-19");
        MOCK_DATAS.add(affiche);
        affiche=new Affiche(R.mipmap.picture,"内容1内容2内容3内容4内容5内容6","2016-12-19");
        MOCK_DATAS.add(affiche);
        affiche=new Affiche(R.mipmap.picture,"内容1内容2内容3内容4内容5内容6","2016-12-19");
        MOCK_DATAS.add(affiche);
        affiche=new Affiche(R.mipmap.picture,"内容1内容2内容3内容4内容5内容6","2016-12-19");
        MOCK_DATAS.add(affiche);
    }
}
