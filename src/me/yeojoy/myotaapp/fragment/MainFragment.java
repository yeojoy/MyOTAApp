package me.yeojoy.myotaapp.fragment;

import com.actionbarsherlock.app.SherlockFragment;

import me.yeojoy.myotaapp.R;
import me.yeojoy.myotaapp.adapter.MainAdapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MainFragment extends SherlockFragment {
    
    private ListView mLvAppList;
    private MainAdapter mAppAdapter;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, null);
        
        mLvAppList = (ListView) view.findViewById(R.id.lv_app_list);
        mAppAdapter = new MainAdapter(getActivity());
        mLvAppList.setAdapter(mAppAdapter);
        
        return view;
    }
}
