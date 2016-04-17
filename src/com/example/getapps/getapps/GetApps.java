package com.example.getapps.getapps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

public class GetApps {
	private Context context;
	public GetApps(Context context){
		this.context=context;
	}
	public ArrayList<AppInfo> getAppList(){
		PackageManager packageManager = context.getPackageManager();
		ArrayList<AppInfo> appList = new ArrayList<AppInfo>();
		Intent getAppsIntent = new Intent(Intent.ACTION_MAIN, null);
		getAppsIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		List<ResolveInfo> getAppsList = packageManager.queryIntentActivities(getAppsIntent, 0);
		for (ResolveInfo getAppsInfo : getAppsList) {
			AppInfo appInfo = new AppInfo();
			appInfo.setAppName(getAppsInfo.activityInfo.loadLabel(packageManager).toString());
			appInfo.setPackageName(getAppsInfo.activityInfo.applicationInfo.packageName.toString());
			appInfo.setIcon(getAppsInfo.loadIcon(packageManager));
			appList.add(appInfo);
		}
		Collections.sort(appList, new AppInfoComparator());
		return appList;
	}
}
