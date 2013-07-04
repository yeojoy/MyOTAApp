
package me.yeojoy.myotaapp;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import me.yeojoy.myotaapp.fragment.MainFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class MainActivity extends SherlockFragmentActivity {

    
    private FragmentManager mFragmentManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mFragmentManager = getSupportFragmentManager();
        Fragment mainFragment = new MainFragment();
        
        mFragmentManager.beginTransaction().add(R.id.rl_frag_container, mainFragment, "Main_Fragment").commit();
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSherlock().getMenuInflater().inflate(R.menu.main, menu);
        
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            
        }
        return super.onOptionsItemSelected(item);
    }
}
