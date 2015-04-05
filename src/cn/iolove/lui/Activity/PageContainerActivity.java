package cn.iolove.lui.Activity;

import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.context.RuntimeContext.RuntimeContextListener;
import cn.iolove.lui.page.NormalPagFragement;
import cn.iolove.lui.page.Page;
import cn.iolove.lui.sandbox.AppSandbox.AppSandboxCallback;
import cn.iolove.lui.service.PageService;
import cn.iolove.lui.utils.PageFactory;
import cn.iolove.lui.view.LuiView;
import android.R;
import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
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
				
				
	
				
				public void RunOnUiThread(Runnable runnable) {
					runOnUiThread(runnable);
					
				}
		
		
				@Override
				public Activity getActivityContext() {
					// TODO Auto-generated method stub
					return co;
				}


				@Override
				public void pushPage(String name) {
					push(name);
					
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
		//mParent.removeAllViews();
		//fragmentManger
		fragmentManger.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).add(0x1237156, fragements, name).addToBackStack(name).commitAllowingStateLoss();
		 ;
	}
	public void pop()
	{
		
		
		fragmentManger.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).remove(fragmentManger.findFragmentByTag(PageService.getInstance().getTopPage().getPageName())).commit();
		PageService.getInstance().popPage();
	}
	public void switchs(String name)
	{
		pop();
		push(name);
		
	}
	@Override

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //监听按下返回键
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                /*已经是最后一个fragment
                 * getSupportFragmentManager()或者getFragmentManager()
                 * 具体要看你add to back stack 是用哪个*/
                //if no more history in stack
        	PageService.getInstance().getTopPage().OnNavBack();
        	Log.i("lui", "触发回退键");
        	

        }
        return true;
    }
	

}
