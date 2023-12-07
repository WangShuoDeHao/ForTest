package com.software;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class HBPath extends Fragment {//Created By Ws 历史界面下的子Fragment
    public int mark=-1;  //创建时传入，记录自己所在位置
    private ListView listView;
    private List<HBhistories> historiesList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View HBpath = inflater.inflate(R.layout.hb_path_page, container);
        ((AppCompatActivity) getActivity()).setSupportActionBar(HistoryBrowsing.historyToolbar);
        findViews(HBpath);
        ReadeDateBase();//查找数据，添加到historiesList当中
        MyBaseAdapter mAdapter=new MyBaseAdapter();
        listView.setAdapter(mAdapter);
        return HBpath;
    }

    private void ReadeDateBase() {
        historiesList = new ArrayList<>();
        for(int i=0;i<10;i++){ // TODO 查找数据库，或设置点击事件
            HBhistories hbs = new HBhistories();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String time = formatter.format(date);
            hbs.setTitle("第"+ i +"条");
            hbs.setDate(time);
            historiesList.add(hbs);
        }
    }

    private void findViews(View view) {
        listView = view.findViewById(R.id.HB_listView);
    }
    public class MyBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return historiesList.size();
        }

        @Override
        public Object getItem(int i) {
            return historiesList.get(i).getTitle();
        }

        @Override
        public long getItemId(int possition) {
            return possition;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            ViewHolder holder;
            if(convertView==null) {
                convertView = View.inflate(getActivity(), R.layout.path_list_item, null);
                holder = new ViewHolder();
                holder.title=convertView.findViewById(R.id.HBpath_title);
                holder.time=convertView.findViewById(R.id.HBpath_time);
                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(historiesList.get(position).getTitle());
            holder.time.setText(historiesList.get(position).getDate());
            return convertView;
        }
    }
    class ViewHolder{
        TextView title;
        TextView time;
    }
}
