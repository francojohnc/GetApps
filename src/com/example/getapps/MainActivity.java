package com.example.getapps;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.getapps.getapps.AppInfo;
import com.example.getapps.getapps.GetApps;

public class MainActivity extends Activity {
	public static final String TAG = MainActivity.class.getSimpleName();
	private GetApps getApps;
	private TextView txtApps;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtApps=(TextView)findViewById(R.id.txtApps);
		getApps = new GetApps(getApplicationContext());
		ArrayList<AppInfo> appList = getApps.getAppList();
		for(int i=0;i<appList.size();i++){
			AppInfo appInfo = appList.get(i);
			txtApps.setText(txtApps.getText().toString()+"\n"+appInfo.getAppName());
			Log.e(TAG, appInfo.getAppName());
			Log.e(TAG, appInfo.getPackageName());
		}

	}


}
