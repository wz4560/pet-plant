package com.appssion.gonplant;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

public class Launch extends Activity implements OnTouchListener{

	private Timer launchTimer;
	private static final int DELAY = 3000 ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.launch);
		
		LinearLayout launchLinear = (LinearLayout)findViewById(R.id.launch_linear);
		launchLinear.setOnTouchListener(this);
		
		viewLoading();
		//launchTimer = new Timer();
		//launchTimer.schedule(new LaunchTimerTask(this), DELAY);

		startService(new Intent("com.appssion.gonplant.service.music")); //Activity 시작과 함께 배경음악을 재생한다.

	}

    private void viewLoading(){
    	Handler handler = new Handler(){
    		@Override
    		public void handleMessage(Message msg){
    			finish();
    		}
    	};
    	handler.sendEmptyMessageDelayed(0, DELAY);
    }
    
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		//launchTimer.cancel();
		
		//Intent i = new Intent(); 
		//i.setClassName(getApplicationContext(), "com.appssion.gonplant.Main" );
		//startActivity(i);
        finish();
        
		return false;
	}	
	
	/*	
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
		stopService(new Intent("com.appssion.gonplantation.service.music")); //종료되면 배경음악이 꺼진다.
    }
	
	class LaunchTimerTask extends TimerTask
	{
		private Launch launch;
		
		public LaunchTimerTask(Launch launch) {
			this.launch = launch;
		}

		@Override
		public void run() {
			Intent i = new Intent(); 
			i.setClassName(launch, "com.appssion.gonplant.Main" );
			launch.startActivity(i);
	        launch.finish();
		}
	}*/
	
}
