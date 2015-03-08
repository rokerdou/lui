package cn.iolove.lui.service;

import java.util.Stack;

import org.keplerproject.luajava.LuaException;

import cn.iolove.lui.page.Page;

import cn.iolove.lui.view.LuiView;

public class PageService {
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
		getTopPage().Refresh();
	}
	public Page getTopPage()
	{
		return StackPage.peek();
		
	}
	public void start() throws LuaException
	{
		
		StackPage.push(CreateNewPage("main"));
		LuaService.getInstance().init();
		getTopPage().Oncreate();
	}
	public Page CreateNewPage(String name)
	{
		Page page = new Page(name);
		return page;
		
	}
}