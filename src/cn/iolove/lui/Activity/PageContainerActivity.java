package cn.iolove.lui.Activity;

import org.keplerproject.luajava.LuaException;

import cn.iolove.debug.LOG;
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
import android.app.Fragment;

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
	private NormalPagFragement lastfrag=null;
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
		NormalPagFragement fragements;
		try {
			fragements = new NormalPagFragement(p);

			RelativeLayout mParent = (RelativeLayout)findViewById(0x1237156);
			//mParent.removeAllViews();
			//fragmentManger
			Page ps =PageService.getInstance().getSecontPage();
			if(ps!=null)
			{
				//fragmentManger.beginTransaction().addToBackStack(ps.getPageName()).commit();
			fragmentManger.beginTransaction().hide(fragmentManger.findFragmentByTag(ps.getPageName())).commit();
			}
			
			fragmentManger.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).add(0x1237156, fragements, name).addToBackStack(null).commitAllowingStateLoss();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			RuntimeContext.showLuaError(e.getMessage());
			e.printStackTrace();
		}
	}
	public void pop()
	{
		
		if(PageService.getInstance().getStackSize()>1)
		{
		fragmentManger.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).remove(fragmentManger.findFragmentByTag(PageService.getInstance().getTopPage().getPageName())).commit();
		PageService.getInstance().popPage();
		if(PageService.getInstance().getTopPage()!=null)
		fragmentManger.beginTransaction().show(fragmentManger.findFragmentByTag(PageService.getInstance().getTopPage().getPageName())).commit();
	
		}
	}
	public void switchs(String name)
	{
		if(name.equals("main"))
		{
			int a=1;
			a=2;
			;;
		}
		PageService.getInstance().popPage();
		Page p =PageFactory.CreatePage(name);
		PageService.getInstance().pushPage(p);
		NormalPagFragement fragements;
		try {
			fragements = new NormalPagFragement(p);

			fragmentManger.beginTransaction().setCustomAnimations( R.anim.slide_in_left, R.anim.slide_out_right).replace(0x1237156, fragements,p.getPageName()).commit();
		} catch (LuaException e) {
			// TODO Auto-generated catch block
			RuntimeContext.showLuaError(e.getMessage());
			e.printStackTrace();
		}
		

		
	}
	@Override

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //监听按下返回键
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                /*已经是最后一个fragment
                 * getSupportFragmentManager()或者getFragmentManager()
                 * 具体要看你add to back stack 是用哪个*/
                //if no more history in stack
        	if(PageService.getInstance().getTopPage()!=null)
        	PageService.getInstance().getTopPage().OnNavBack();
        	LOG.i(this, "触发回退键");
        	

        }
        return true;
    }
	

}
