package cn.iolove.lui.Activity;

import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.context.RuntimeContext.RuntimeContextListener;
import cn.iolove.lui.page.NormalPagFragement;
import cn.iolove.lui.page.Page;
import cn.iolove.lui.sandbox.AppSandbox.AppSandboxCallback;
import cn.iolove.lui.service.PageService;
import cn.iolove.lui.utils.PageFactory;
import cn.iolove.lui.view.LuiView;
import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.RelativeLayout;

public class PageContainerActivity extends FragmentActivity{
	private Activity co = this;
	private FragmentManager fragmentManger;
	private RelativeLayout root;
@Override
		protected void onCreate(Bundle arg0) {
			// TODO Auto-generated method stub
			super.onCreate(arg0);
			root =new RelativeLayout(co);
			root.setId(0x1237156);
			setContentView(root);
			fragmentManger =getSupportFragmentManager();
		
			 
			RuntimeContext.init(getApplicationContext(),new RuntimeContextListener() {
				
				
				public void setView(View v) {
					LuiView	 roots = new LuiView(co);
					roots.addView(v);
					root.addView(roots);
					
					//setContentView(root);
					
				}
		
				
				public void RunOnUiThread(Runnable runnable) {
					runOnUiThread(runnable);
					
				}
		
		
				@Override
				public Activity getActivityContext() {
					// TODO Auto-generated method stub
					return co;
				}
			},new AppSandboxCallback() {
				
				@Override
				public void switchPage(final String obj) {
					RuntimeContext.runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							switchs(obj);
							
						}
					});
				
					
				}
				
				@Override
				public void pushPage(final String obj) {
					// TODO Auto-generated method stub

							push(obj);
		
				
					
				}
				
				@Override
				public void popPage() {
					// TODO Auto-generated method stub
					
					RuntimeContext.runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							pop();
							
						}
					});
					
				}
			});

			
		
	}
	public void push(String name)
	{
		Page p =PageFactory.CreatePage(name);
		PageService.getInstance().pushPage(p);
		NormalPagFragement fragements = new NormalPagFragement(p);
		RelativeLayout mParent = (RelativeLayout)findViewById(0x1237156);
		mParent.removeAllViews();
		
		fragmentManger.beginTransaction().add(0x1237156, fragements, name).commitAllowingStateLoss();
		
	}
	public void pop()
	{
		
		fragmentManger.beginTransaction().remove(fragmentManger.findFragmentByTag(PageService.getInstance().getTopPage().getPageName())).commit();
		PageService.getInstance().popPage();
	}
	public void switchs(String name)
	{
		pop();
		push(name);
		
	}

}
