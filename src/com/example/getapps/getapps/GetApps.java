package com.example.getapps.getapps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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
		ArrayList<AppInfo> apps = new ArrayList<AppInfo>();
		Intent getAppsIntent = new Intent(Intent.ACTION_MAIN, null);
		getAppsIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		List<ResolveInfo> getAppsList = packageManager.queryIntentActivities(getAppsIntent, 0);
		for (ResolveInfo getAppsInfo : getAppsList) {
			apps.add(new AppInfo());
			apps.get(apps.size() - 1).setAppInfo(getAppsInfo.activityInfo.loadLabel(packageManager).toString(), getAppsInfo.activityInfo.applicationInfo.packageName.toString());
		}
		HashSet<AppInfo> a = new HashSet<AppInfo>(apps);
		apps = new ArrayList<AppInfo>(a);
		Collections.sort(apps, new AppInfoComparator());
		return apps;
	}
}
