package com.software;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(mPagerAdapter);
        return home;
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
