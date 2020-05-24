package com.appssion.gonplant;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
 
public class MusicService extends Service {
 
	public MediaPlayer mp;
 
	public IBinder onBind(Intent arg0) {
		return null;
	}
 

	public void onStart(Intent intent, int startId) {
		Log.i("gonplant", "Service onStart()"); 
		super.onStart(intent,  startId);
		mp = MediaPlayer.create(this, R.raw.gon_open);
		mp.setLooping(false); // �ݺ� ��� ���� (true�� false�� ���� ����)
		mp.start(); //���� ���

	}
	
	public void onDestroy() {
		Log.i("gonplant", "Service onDestroy()");
		super.onDestroy();
		mp.stop(); //���� ����
	}
}
