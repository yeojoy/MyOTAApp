package me.yeojoy.myotaapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;

import me.yeojoy.myotaapp.R;
import me.yeojoy.myotaapp.adapter.MainAdapter;
import me.yeojoy.myotaapp.model.AppEntity;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends SherlockFragment implements OnClickListener {
    
    private ListView mLvAppList;
    private MainAdapter mAppAdapter;
    private List<AppEntity> mAppList;
    
    private Button mBtnGet;
    
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
        
        mBtnGet = (Button) view.findViewById(R.id.btn_get_app_list);
        mBtnGet.setOnClickListener(this);
        
        return view;
    }
    
    @Override
    public void onStart() {
        super.onStart();
        
    }

    @Override
    public void onClick(View v) {
        
        switch (v.getId()) {
            case R.id.btn_get_app_list :
                
                break;
        }
    }
    
}
