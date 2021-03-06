package cn.iolove.lui.page;


import cn.iolove.debug.LOG;
import cn.iolove.luajava.LuaException;
import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.service.PageService;
import cn.iolove.lui.utils.PageFactory;
import cn.iolove.lui.view.LuiView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;





@SuppressLint("ValidFragment")
public class NormalPagFragement extends Fragment {
	FrameLayout mContainer;
	RelativeLayout mParent;
	private PageCircle page;
	private String name;
	public NormalPagFragement(PageCircle names) throws LuaException
	{
		page=names;

		page.Oncreate();
		LOG.i(this, "onCreate : "+page.getPageName());

	}

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 super.onCreateView(inflater, container, savedInstanceState);
			mParent = (RelativeLayout)(getActivity().findViewById(0x1237156));
			LOG.i(this, "exe..Oncreated.."+ page.getPageName());
			if (mContainer == null)
			{
				mContainer = new LuiView(getActivity());
				

					mContainer.addView(page.getRootView());

				
			
			}else
			{
				 ViewGroup parent = (ViewGroup) mContainer.getParent();
			        if (parent != null) {
			            parent.removeView(mContainer);
			        } 
			}
			
		return mContainer;
	}
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		page.OnFronted();
		LOG.i(this, "OnFronted : "+page.getPageName());
	}
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		page.OnBackend();
		LOG.i(this, "OnBackend : "+page.getPageName());
	}
	@Override	
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		LOG.i(this, "onDestroy : "+page.getPageName());
	}

}
