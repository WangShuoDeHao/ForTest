package com.software;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//Created by ws 首页面布局控件

    private TabLayout TableLayout;
    private ViewPager2 MainViewPager2;
    public static androidx.appcompat.widget.Toolbar toolbar;
    private List<Fragment> fragments;
    private ImageView SearchBox;
    public boolean onCreateOptionsMenu(Menu menu){//ws 调用Toolbar所用
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){//ws 调用Toolbar所用,判断点击的是toolbar当中的哪个组件
        switch (item.getItemId()){
            case R.id.user:
                Toast.makeText(this, "你点击了user", Toast.LENGTH_SHORT).show();
                break;
            case R.id.history:
                Toast.makeText(this, "你点击了history", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Settings:
                Toast.makeText(this, "你点击了设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Orthers:
                Toast.makeText(this, "你点击了其他", Toast.LENGTH_SHORT).show();
                break;
            case R.id.upload:
                Toast.makeText(this, "你点击了下载", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);//ws 调用setSupportActionBar方法,为了使用Toolbar
        findViews();//ws 用于配置布局组件id
        insertPages();//ws 用于添加页面
        listener();
        PageAdapter adapter =new PageAdapter(fragments,this);
        MainViewPager2.setAdapter(adapter);

        TabLayoutMediator mediator =new TabLayoutMediator(TableLayout,MainViewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position){
                            case 0:
                                tab.setText("首页");
                                break;
                            case 1:
                                tab.setText("历史");break;
                            case 2:
                                tab.setText("推荐");break;
                            case 3:
                                tab.setText("音乐");break;
                        }
                    }
                }
        );
        mediator.attach(); //ws 启动(TabLayoutMediator)mediator

    }

    private void listener() {
        OnCustomListener listener=new OnCustomListener();
        SearchBox.setOnClickListener(listener);
    }
    class OnCustomListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.search_box:
                    Toast.makeText(MainActivity.this, "TODO一个跳转页面", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }


    private void findViews() {
        TableLayout = findViewById(R.id.Tablayout);
        MainViewPager2 = findViewById(R.id.MainViewPage2);
        toolbar =findViewById(R.id.toolbar_main);
        SearchBox = findViewById(R.id.search_box);
    }
    private void insertPages() {
        fragments =new ArrayList<>();
        fragments.add(new Home_Fragment());
        fragments.add(new History_Fragment());
        fragments.add(new Recommendations_Fragment());
        fragments.add(new Screening_Fragment());
    }
}