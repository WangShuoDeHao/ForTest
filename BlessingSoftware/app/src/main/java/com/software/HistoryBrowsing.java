package com.software;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class HistoryBrowsing extends AppCompatActivity {
    public static androidx.appcompat.widget.Toolbar historyToolbar;
    private ViewPager2 HistoryViewPager2;
    private TabLayout HistoryTableLayout;
    private ImageView turnBackImage;
    private List<Fragment> fragmentList;
    public boolean onCreateOptionsMenu(Menu menu){//ws 调用Toolbar所用
        getMenuInflater().inflate(R.menu.history_brosing_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){//ws 调用Toolbar所用,判断点击的是toolbar当中的哪个组件
        switch (item.getItemId()) {
            case R.id.garbage:
                Toast.makeText(this, "正在开发当中", Toast.LENGTH_SHORT).show();
                break;
                case R.id.search:
                    Toast.makeText(this, "去打赏程序猿可加速开发", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_browsing_page);
        findviews();
        setSupportActionBar(historyToolbar);//ws 调用setSupportActionBar方法,为了使用Toolbar
        insertPages();//ws 用于添加页面
        setListener();//ws 创建点击事件监听器
        PageAdapter adapter =new PageAdapter(fragmentList,this);
        HistoryViewPager2.setAdapter(adapter);
        TabLayoutMediator mediator =new TabLayoutMediator(HistoryTableLayout,HistoryViewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position){
                            case 0:
                                tab.setText("全部");
                                break;
                            case 1:
                                tab.setText("乐史");break;
                            case 2:
                                tab.setText("乐曲");break;
                            case 3:
                                tab.setText("乐器");break;
                        }
                    }
                }
        );
        mediator.attach(); //ws 启动(TabLayoutMediator)mediator
    }

    private void setListener() {
        OnCustomListener listener =new OnCustomListener();
        turnBackImage.setOnClickListener(listener);
    }
    class OnCustomListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.historyBrowsingBack:
                    finish();
                    break;
                default:
                    break;
            }
        }
    }
    private void insertPages() {
        fragmentList =new ArrayList<>();
        HBPath hp1 = new HBPath(); hp1.mark=1; fragmentList.add(hp1);
        HBPath hp2 = new HBPath(); hp2.mark=2; fragmentList.add(hp2);
        HBPath hp3 = new HBPath(); hp3.mark=3; fragmentList.add(hp3);
        HBPath hp4 = new HBPath(); hp4.mark=4; fragmentList.add(hp4);
    };

    private void findviews() {
        HistoryViewPager2 = findViewById(R.id.historyBrowsingViewPage2);
        HistoryTableLayout = findViewById(R.id.historyBrowsingTablayout);
        turnBackImage = findViewById(R.id.historyBrowsingBack);
        historyToolbar =findViewById(R.id.toolbar_historyBrowsing);
    }
}
