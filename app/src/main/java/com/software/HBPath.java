package com.software;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;



public class HBPath extends Fragment {//Created By Ws 历史界面下的子Fragment
    public int mark=-1;  //创建时传入，记录自己所在位置
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View HBpath = inflater.inflate(R.layout.hb_path_page, container);
        ((AppCompatActivity) getActivity()).setSupportActionBar(HistoryBrowsing.historyToolbar);
        return HBpath;
    }
}
