package cn.iolove.lui.controller;

import java.util.Stack;

import cn.iolove.lui.view.LuiView;
import cn.iolove.lui.page.Page;
public class PageController {
	private PageController()
	{};
	private static PageController obj = new PageController();
	public static PageController getInstance(){return obj;}
	private static Stack<Page>  StackPage = new Stack<Page>() ;

	public static interface PageControolerCallback 
	{
		public abstract void  pushPage(LuiView v);
		
		
	}
	public Page getTopPage()
	{
		return StackPage.peek();
		
	}
	public void start()
	{
		
		StackPage.push(CreateNewPage("main"));
	}
	public Page CreateNewPage(String name)
	{
		Page page = new Page(name);
		return page;
		
	}
}
