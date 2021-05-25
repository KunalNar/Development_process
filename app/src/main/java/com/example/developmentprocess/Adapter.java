package com.example.developmentprocess;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {


    Activity activity;
    List<Usermodel> users;
    LayoutInflater inflater;



    public Adapter(Activity activity) {
        this.activity = activity;
    }

    public Adapter(Activity activity, List<Usermodel> users) {
        this.activity   = activity;
        this.users      = users;

        inflater        = activity.getLayoutInflater();
    }


    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;

        if (view == null){

            view = inflater.inflate(R.layout.list_view_item, viewGroup, false);

            holder = new ViewHolder();

            holder.tvUserName = (TextView)view.findViewById(R.id.tv_user_name);
            holder.ivCheckBox = (ImageView) view.findViewById(R.id.iv_check_box);

            view.setTag(holder);
        }else
            holder = (ViewHolder)view.getTag();

        Usermodel model = users.get(i);

        holder.tvUserName.setText(model.getUserName());

        if (model.isSelected()) {
            holder.ivCheckBox.setBackgroundResource(R.drawable.checked);
            holder.tvUserName.setBackgroundColor(Color.GREEN);
        }

        else

            holder.ivCheckBox.setBackgroundResource(R.drawable.check);
            holder.tvUserName.setBackgroundColor(Color.WHITE);

        return view;

    }

    public void updateRecords(List<Usermodel> users){
        this.users = users;

        notifyDataSetChanged();
    }

    class ViewHolder{

        TextView tvUserName;
        ImageView ivCheckBox;

    }
}
