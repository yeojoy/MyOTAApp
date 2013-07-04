package me.yeojoy.myotaapp.fragment;

import com.actionbarsherlock.app.SherlockFragment;

import me.yeojoy.myotaapp.R;
import me.yeojoy.myotaapp.adapter.MainAdapter;
import me.yeojoy.myotaapp.model.AppEntity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends SherlockFragment {
    
    private ListView mLvAppList;
    private MainAdapter mAppAdapter;
    private List<AppEntity> mAppList;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        mAppList = new ArrayList<AppEntity>();
        AppEntity newApp = new AppEntity();
        newApp.iconResouceId = R.drawable.ic_launcher;
        newApp.appTitle = getResources().getString(R.string.app_title);
        newApp.appDesc = getResources().getString(R.string.app_desc);
        
        mAppList.add(newApp);
        
        
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // View는 container에 attach되고 마지막 true일 때 한 번 더 attach 되므로 false가 되어야 함.
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        
        mLvAppList = (ListView) view.findViewById(R.id.lv_app_list);
        mAppAdapter = new MainAdapter(getActivity(), mAppList);
        mLvAppList.setAdapter(mAppAdapter);
        
        return view;
    }
    
}
