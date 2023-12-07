package com.software;

import static androidx.core.view.ViewCompat.canScrollHorizontally;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends Fragment {
    public com.google.android.material.tabs.TabLayout tabLayout;
    private androidx.viewpager.widget.ViewPager viewPager;
    private ImageView guzheng, erhu, pipa, dizi, xiao, hulusi,bianzhong, konghou;
    private List<Fragment> fragmentList;
    String[] temp = {"玄鸣乐器","气鸣乐器","体鸣乐器","膜鸣乐器"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View home =inflater.inflate(R.layout.home_page,container);
        findViews(home);
        ((AppCompatActivity) getActivity()).setSupportActionBar(MainActivity.toolbar);
// ws  fragment中嵌套fragment, Manager需要用(getChildFragmentManager())
        MPagerAdapter mPagerAdapter = new MPagerAdapter(getChildFragmentManager());
        insertPages();
        setListener();//ws 创建点击事件监听器
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(mPagerAdapter);
        return home;
    }

    private void setListener() {
        OnCustomListener listener=new OnCustomListener();
        guzheng.setOnClickListener(listener);
        erhu.setOnClickListener(listener);
        pipa.setOnClickListener(listener);
        dizi.setOnClickListener(listener);
        xiao.setOnClickListener(listener);
        hulusi.setOnClickListener(listener);
        bianzhong.setOnClickListener(listener);
        konghou.setOnClickListener(listener);

    }

    class OnCustomListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.guzheng_jpg   :  Toast.makeText(getActivity(), "你点击了", Toast.LENGTH_SHORT).show();    Intent intent1 =new Intent();intent1.setClass(getActivity(),InstrumentDetailsActivity.class); intent1.putExtra("guzheng_jpg","0");  startActivity(intent1);  break;
                case R.id.erhu_jpg      :  Toast.makeText(getActivity(), "你点击了", Toast.LENGTH_SHORT).show();    Intent intent2 =new Intent();intent2.setClass(getActivity(),InstrumentDetailsActivity.class); intent2.putExtra("erhu_jpg","0");     startActivity(intent2);  break;
                case R.id.pipa_jpg      :  Toast.makeText(getActivity(), "你点击了", Toast.LENGTH_SHORT).show();    Intent intent3 =new Intent();intent3.setClass(getActivity(),InstrumentDetailsActivity.class); intent3.putExtra("pipa_jpg","0");     startActivity(intent3);  break;
                case R.id.dizi_jpg      :  Toast.makeText(getActivity(), "你点击了", Toast.LENGTH_SHORT).show();    Intent intent4 =new Intent();intent4.setClass(getActivity(),InstrumentDetailsActivity.class); intent4.putExtra("dizi_jpg","0");     startActivity(intent4);  break;
                case R.id.xiao_jpg      :  Toast.makeText(getActivity(), "你点击了", Toast.LENGTH_SHORT).show();    Intent intent5 =new Intent();intent5.setClass(getActivity(),InstrumentDetailsActivity.class); intent5.putExtra("xiao_jpg","0");     startActivity(intent5);  break;
                case R.id.hulusi_jpg    :  Toast.makeText(getActivity(), "你点击了", Toast.LENGTH_SHORT).show();    Intent intent6 =new Intent();intent6.setClass(getActivity(),InstrumentDetailsActivity.class); intent6.putExtra("hulusi_jpg","0");   startActivity(intent6);  break;
                case R.id.bianzhong_jpg :  Toast.makeText(getActivity(), "你点击了", Toast.LENGTH_SHORT).show();    Intent intent7 =new Intent();intent7.setClass(getActivity(),InstrumentDetailsActivity.class); intent7.putExtra("bianzhong_jpg","0");startActivity(intent7);  break;
                case R.id.konghou_jpg   :  Toast.makeText(getActivity(), "你点击了", Toast.LENGTH_SHORT).show();    Intent intent8 =new Intent();intent8.setClass(getActivity(),InstrumentDetailsActivity.class); intent8.putExtra("konghou_jpg","0");  startActivity(intent8);  break;
                default:break;
            }
        }
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void insertPages() {
        fragmentList =new ArrayList<>();
        MusicType_Choices_ChildFragment fragment1 =new MusicType_Choices_ChildFragment();
        fragment1.mark =1;
        fragmentList.add(fragment1);
        MusicType_Choices_ChildFragment fragment2 =new MusicType_Choices_ChildFragment();
        fragment2.mark =2;
        fragmentList.add(fragment2);
        MusicType_Choices_ChildFragment fragment3 =new MusicType_Choices_ChildFragment();
        fragment3.mark =3;
        fragmentList.add(fragment3);
        MusicType_Choices_ChildFragment fragment4 =new MusicType_Choices_ChildFragment();
        fragment4.mark =4;
        fragmentList.add(fragment4);

    }


    private void findViews(View home) {
        tabLayout= home.findViewById(R.id.tablelayout_fragment);
        viewPager = home.findViewById(R.id.FragmentViewPage);
        guzheng= home.findViewById(R.id.guzheng_jpg);
        erhu= home.findViewById(R.id.erhu_jpg);
        pipa= home.findViewById(R.id.pipa_jpg);
        dizi= home.findViewById(R.id.dizi_jpg);
        xiao= home.findViewById(R.id.xiao_jpg);
        hulusi= home.findViewById(R.id.hulusi_jpg);
        bianzhong= home.findViewById(R.id.bianzhong_jpg);
        konghou= home.findViewById(R.id.konghou_jpg);
    }

    class MPagerAdapter extends FragmentPagerAdapter {

        public MPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return (Fragment) fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        //返回tablayout的标题文字;
        @Override
        public CharSequence getPageTitle(int position) {
            return temp[position];
        }
    }


}
