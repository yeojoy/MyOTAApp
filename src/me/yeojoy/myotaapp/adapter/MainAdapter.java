package me.yeojoy.myotaapp.adapter;

import me.yeojoy.myotaapp.R;
import me.yeojoy.myotaapp.model.AppEntity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<AppEntity> mAppList;
    
    public MainAdapter(Context context) {
        new MainAdapter(context, new ArrayList<AppEntity>());
    }
    
    public MainAdapter(Context context, List<AppEntity> appList) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mAppList = appList;
    }
    
    @Override
    public int getCount() {
        
        return mAppList.size() == 0 ? 1 : mAppList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAppList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    
    public void setAppList(List<AppEntity> appList) {
        mAppList = appList;
    }
    
    public void addAppList(List<AppEntity> appList) {
        mAppList.addAll(appList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        
        // View 설정
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_app, null);            
            
            viewHolder = new ViewHolder();
            viewHolder.mIvAppIcon = (ImageView) convertView.findViewById(R.id.iv_app_icon);
            viewHolder.mTvAppTitle = (TextView) convertView.findViewById(R.id.tv_app_title);
            viewHolder.mTvAppDesc = (TextView) convertView.findViewById(R.id.tv_app_desc);
            
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        
        int resourceId = mAppList.get(position).resouceId; 
        String appTitle = mAppList.get(position).appTitle;
        String appDesc = mAppList.get(position).appDesc;

        if (resourceId != -1)
            viewHolder.mIvAppIcon.setImageResource(resourceId);
        
        if (appTitle != null)
            viewHolder.mTvAppTitle.setText(appTitle);
        
        if (appDesc != null)
            viewHolder.mTvAppDesc.setText(appDesc);
        
        return convertView;
    }
    
    class ViewHolder {
        ImageView mIvAppIcon;
        TextView mTvAppTitle;
        TextView mTvAppDesc;
    }
}
