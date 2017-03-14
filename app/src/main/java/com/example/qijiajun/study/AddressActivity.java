package com.example.qijiajun.study;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.hietk.common.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;

import static android.R.attr.data;
import static android.os.Build.VERSION_CODES.N;
import static com.example.qijiajun.study.R.drawable.view;


public class AddressActivity extends BaseActivity {
    @Bind(R.id.province)
    WheelView province;
    @Bind(R.id.city)
    WheelView city;
    private boolean scrolling = false;
    public String datas;
    private ArrayWheelAdapter<String> adapter;
    private int itemnumber;

    @Bind(R.id.bt_cancel_Address)
    Button btCancelAddress;
    @Bind(R.id.bt_determine_Address)
    Button btDetermineAddress;


    @Override
    public void initView() {
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);


        province.setViewAdapter(new ProvinceAdapter(this));

        final String cities[][] = new String[][]{
                new String[]{"杭州", "宁波", "温州", "绍兴", "湖州", "嘉兴", "金华", "衢州", "舟山", "台州", "丽水"},
                new String[]{"无锡", "常州", "镇江", "南京", "苏州", "南通", "泰州", "扬州", "淮安", "徐州", "盐城", "连云港", "宿迁"},
                new String[]{"济南", "青岛", "淄博", "枣庄", "东营", "烟台", "潍坊", "济宁", "泰安", "威海", "日照",
                        "莱芜", "临沂", "德州", "聊城", "滨州", "菏泽"},
                new String[]{"哈尔滨", "齐齐哈尔", "鸡西", "鹤岗", "双鸭山", "大庆", "伊春", "佳木斯", "七台河", "牡丹江", "黑河", "绥化"},
        };


        province.setCurrentItem(0);
        city.setCurrentItem(0);
        Log.e("初始化", String.valueOf(city.getCurrentItem()));
        updateCities(city, cities, 0);

        province.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                if (!scrolling) {
                    updateCities(city, cities, newValue);

                }
            }
        });

        province.addScrollingListener(new OnWheelScrollListener() {
            @Override
            public void onScrollingStarted(WheelView wheel) {
                scrolling = true;
            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                scrolling = false;
                updateCities(city, cities, province.getCurrentItem());
//                city.setCurrentItem(0);
//                data= cities[province.getCurrentItem()].toString();
            }
        });

        city.addScrollingListener(new OnWheelScrollListener() {
            @Override
            public void onScrollingStarted(WheelView wheel) {
            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
//                data= (cities[province.getCurrentItem()][city.getCurrentItem()]).toString();
                if (String.valueOf(city.getCurrentItem()) == null || String.valueOf(city.getCurrentItem()).equals("")) {
                    itemnumber = 0;
                    Log.e("number3", String.valueOf(itemnumber));
                } else {
                    itemnumber = city.getCurrentItem();
                    Log.e("number4", String.valueOf(itemnumber));
                }
                Log.e("init2", String.valueOf(city.getCurrentItem()));
            }
        });
//        datas = adapter.getItemText(itemnumber).toString();
//        Log.e("城市地址",datas);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.bt_cancel_Address, R.id.bt_determine_Address})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_cancel_Address:
                onBackPressed();
                break;
            case R.id.bt_determine_Address:
                datas = adapter.getItemText(itemnumber).toString();
                Log.e("城市地址",datas);
                Intent intent = new Intent();
                intent.putExtra("city", datas + "市");
                AddressActivity.this.setResult(3, intent);
                Log.e("地址", intent.getExtras().getString("city"));
                AddressActivity.this.finish();
                Toast.makeText(this, datas, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * Updates the city wheel
     */
    private void updateCities(WheelView city, String cities[][], int index) {
        adapter =
                new ArrayWheelAdapter<String>(this, cities[index]);
        adapter.setTextSize(18);
        city.setViewAdapter(adapter);
//        city.setCurrentItem(cities[index].length / 2);
        city.setCurrentItem(0);

    }

    /**
     * Adapter for countries
     */
    private class ProvinceAdapter extends AbstractWheelTextAdapter {
        // Countries names
        private String provinces[] =
                new String[]{"浙江", "江苏", "山东", "黑龙江"};
        // Countries flags
//        private int flags[] =
//                new int[] {R.drawable.usa, R.drawable.canada, R.drawable.ukraine, R.drawable.france};

        /**
         * Constructor
         */
        protected ProvinceAdapter(Context context) {
            super(context, R.layout.province_layout, NO_RESOURCE);
            setItemTextResource(R.id.province_name);
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            View view = super.getItem(index, cachedView, parent);
//            ImageView img = (ImageView) view.findViewById(R.id.flag);
//            img.setImageResource(flags[index]);
            return view;
        }

        @Override
        public int getItemsCount() {
            return provinces.length;
        }

        @Override
        protected CharSequence getItemText(int index) {
            return provinces[index];
        }
    }
}
