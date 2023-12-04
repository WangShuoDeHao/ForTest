package com.software;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

//Created by ws 适配器,用于绑定四个基本页面
public class PageAdapter extends FragmentStateAdapter {

    private List<Fragment> fragments; //ws  关于Fragment的List，放入Fragment布局

    public PageAdapter(List<Fragment> fragments , @NonNull FragmentActivity fragmentActivity){
        //ws 对构造方法重载，在首页面调用，将4个子页面关联起来
        super(fragmentActivity);
        this.fragments=fragments;
    }

    public PageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public PageAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public PageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);//ws 返回（int）position位置
    }

    @Override
    public int getItemCount() {
        return fragments.size();//ws 返回（list）fragments包含的子页面数量
    }
}
