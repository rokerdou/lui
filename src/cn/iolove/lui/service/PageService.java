package cn.iolove.lui.service;

import java.util.Stack;



import cn.iolove.luajava.LuaException;
import cn.iolove.lui.page.Page;

import cn.iolove.lui.view.LuiView;

public class PageService implements PageServiceInterface {
	private PageService()
	{};
	private static PageService obj = new PageService();
	public static PageService getInstance(){return obj;}
	private static Stack<Page>  StackPage = new Stack<Page>() ;

	public static interface PageControolerCallback 
	{
		public abstract void  pushPage(LuiView v);
		
		
	}
	
	public void Refresh()
	{
		if(!StackPage.isEmpty())
		getTopPage().Refresh();
	}
	public Page getTopPage()
	{
		return StackPage.peek();
		
	}
	public int getStackSize()
	{
		return StackPage.size();
	}
	public Page getSecontPage()
	{
		if(StackPage.size()<2) return null;
		
		return StackPage.get(StackPage.indexOf(StackPage.peek())-1);
		
	}
	public void start() throws LuaException
	{
		
		//StackPage.push(CreateNewPage("main"));
		
		
		//getTopPage().Oncreate();
	}
	public Page CreateNewPage(String name)
	{
		Page page = new Page(name);
		return page;
		
	}
	@Override
	public void pushPage(Page obj) {
		StackPage.push(obj);
		LuaService.getInstance().init();
		Registry.getInstance();
		Registry.getInstance().pushServiceInLua();
	
		
		
	}
	@Override
	public void switchPage(Page obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void popPage() {
		StackPage.remove(StackPage.peek());
		// TODO Auto-generated method stub
		
	}
}