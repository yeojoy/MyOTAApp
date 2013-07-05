
package me.yeojoy.myotaapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;

import me.yeojoy.myotaapp.fragment.MainFragment;

public class MainActivity extends SherlockFragmentActivity implements Constants {

    private final static AccessType ACCESS_TYPE = AccessType.DROPBOX;
    
    private FragmentManager mFragmentManager;
    
    
    public DropboxAPI<AndroidAuthSession> mDropboxApi;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mFragmentManager = getSupportFragmentManager();
        Fragment mainFragment = new MainFragment();
        
        mFragmentManager.beginTransaction().add(R.id.rl_frag_container, mainFragment, FRAGMENT_TAG_MAIN).commit();
        
        AppKeyPair appKeys = new AppKeyPair(DROPBOX_APP_KEY, DROPBOX_APP_SECRET);
        AndroidAuthSession dropboxSession = new AndroidAuthSession(appKeys, ACCESS_TYPE);
        mDropboxApi = new DropboxAPI<AndroidAuthSession>(dropboxSession);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSherlock().getMenuInflater().inflate(R.menu.main, menu);
        
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_conn_dropbox :
                
                mDropboxApi.getSession().startAuthentication(MainActivity.this);
                
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        if (mDropboxApi.getSession().authenticationSuccessful()) {
            try {
                mDropboxApi.getSession().finishAuthentication();
                AccessTokenPair tokens = mDropboxApi.getSession().getAccessTokenPair();
            } catch (IllegalStateException e) {
                Log.i("DbAuthLog", "Error authenticating", e);
            }
        }
        
    }
}
