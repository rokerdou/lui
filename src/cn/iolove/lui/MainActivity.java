package cn.iolove.lui;

import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.context.RuntimeContext.RuntimeContextListener;
import cn.iolove.lui.view.LuiView;
import android.os.Bundle;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Context co = this;
		
		RuntimeContext.init(getApplicationContext(),new RuntimeContextListener() {
			
			
			public void setView(LuiView v) {
				setContentView(v);
				
			}

			
			public void RunOnUiThread(Runnable runnable) {
				runOnUiThread(runnable);
				
			}


			@Override
			public Context getActivityContext() {
				// TODO Auto-generated method stub
				return co;
			}
		});
		
		
		
		
	
	}
	



}
