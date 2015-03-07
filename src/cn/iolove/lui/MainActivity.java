package cn.iolove.lui;

import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.context.RuntimeContext.RuntimeContextListener;
import cn.iolove.lui.view.LuiView;
import android.os.Bundle;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private Activity co = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.activity_main);
		//final 
		/*
		 getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				 WindowManager.LayoutParams.FLAG_FULLSCREEN);
				 */
		 
		RuntimeContext.init(getApplicationContext(),new RuntimeContextListener() {
			
			
			public void setView(View v) {
				LuiView	 root = new LuiView(co);
				root.addView(v);
				setContentView(root);
				
			}

			
			public void RunOnUiThread(Runnable runnable) {
				runOnUiThread(runnable);
				
			}


			@Override
			public Activity getActivityContext() {
				// TODO Auto-generated method stub
				return co;
			}
		});
		
		
		
		
	
	}
	



}
