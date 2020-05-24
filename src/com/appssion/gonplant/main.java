package com.appssion.gonplant;

//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.ActionBar;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.os.Build;

public class main extends Activity implements OnTouchListener /*extends ActionBarActivity*/ {
	
	int flgInit = 0; //처음 로딩 구분을 위한 flag
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        /*
        Intent intent = getIntent();
        if(intent!=null){
        	flgInit=intent.getIntExtra("flgInit", flgInit);
        }
        Log.i("gonplant", "flgInit="+flgInit); 
        if(flgInit<=0) {
        	startActivity(new Intent(this, Launch.class));
            //startService(new Intent("com.appssion.gonplant.service.music")); //Activity 시작과 함께 배경음악을 재생한다.
        }
        */

/*        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) 
	{
		// TODO Auto-generated method stub
		stopService(new Intent("com.appssion.gonplant.service.music1")); //종료되면 배경음악이 꺼진다.
		return false;
	}

	public boolean onKeyDown(int keyCode, KeyEvent event){
        switch (keyCode){
        	case KeyEvent.KEYCODE_BACK:
        		exit();
        }
        return super.onKeyDown(keyCode, event);    
	}   
	
	public void exit(){
		ActivityManager am = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
		am.restartPackage(getPackageName());
		stopService(new Intent("com.appssion.gonplant.service.music")); //종료되면 배경음악이 꺼진다.
    }
	
    /*    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    *//**
     * A placeholder fragment containing a simple view.
     *//*
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }*/

}
