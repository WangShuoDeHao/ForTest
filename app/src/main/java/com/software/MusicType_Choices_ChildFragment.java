package com.software;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

//Created By ws 在Home_Fragment页面下实现嵌套Fragment
public class MusicType_Choices_ChildFragment extends Fragment {
    public  TextView text;
    public View choices;
    public int mark = -1;
    private String[] buttonTitle ={"古琴","古筝","二胡","琵琶","箜篌","柳琴","扬琴","竖箜篌","阮", "凤首箜篌","双排弦箜篌","雁柱箜篌","转调箜篌","卡龙琴","弓琴","达比亚","傣玎","托甫秀尔","东布尔","菲特克呐",
    "唢呐","笛子","埙","箫","笙","葫芦丝","芦笙","小号","牛角","海螺","夜箫","侗笛","塞箫","瓦格洛","雄林","塔吉克竖笛","嘟噜","低音嘟噜","太平箫","嘎嗦",
    "编钟","锣","镲","木鱼","木琴","竹杠","钹","铙","铜铃","彝族中三弦","八宝铜铃","师刀","竹簧","蹈到","铁簧","锡伯族铁簧","大铙","钗","司涅","布哉",
    "大鼓","排鼓","腰鼓","战鼓","扁鼓","长鼓","手鼓","小鼓","太平鼓","环鼓","抬鼓","朗达玛","纳格拉","达玛如","建鼓","神鼓","那额","塔布尔","竹鼓","夏尔巴鼓"};
    RecyclerView FragmentMusicChoicesRecyclerView;
    private List<MusicButtons> musicButtonsList =new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        choices =inflater.inflate(R.layout.musictype_choices_child_fragment_page,null);
        super.onViewCreated(choices, savedInstanceState);
        initMusicChoice();
        findViews();
        setTextView();
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        FragmentMusicChoicesRecyclerView.setLayoutManager(layoutManager);
        MusicButtonAdapter adapter =new MusicButtonAdapter(musicButtonsList);
        FragmentMusicChoicesRecyclerView.setAdapter(adapter);
        return choices;
    }

    private void initMusicChoice() {
        for (int i =0;i<20;i++){
            MusicButtons musicView = new MusicButtons(buttonTitle[i+(mark-1)*20],1);
            musicButtonsList.add(musicView);
        }
    }


    private void findViews() {
        text = choices.findViewById(R.id.text_test);
        FragmentMusicChoicesRecyclerView = choices.findViewById(R.id.Fragment_Choices_RecycleView);
    }

    private void setTextView() {
        switch (mark){
            case 1:
                text.setText("1玄冥");
                break;
            case 2:
                text.setText("2气鸣");
                break;
            case 3:
                text.setText("3体鸣");
                break;
            case 4:
                text.setText("4膜鸣");
                break;
            case -1:
                text.setText("未传入成功");
                break;
            default:
                break;
        }
    }


}





