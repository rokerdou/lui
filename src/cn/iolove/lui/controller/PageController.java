package cn.iolove.lui.controller;

import java.util.Stack;

import cn.iolove.lui.view.LuiView;
import cn.iolove.lui.page.Page;
public class PageController {
	private PageController()
	{};
	private static PageController obj = new PageController();
	public PageController getInstance(){return obj;}
	private static Stack<Page>  StackPage = new Stack<Page>() ;

	public static interface PageControolerCallback 
	{
		public abstract void  pushPage(LuiView v);
		
		
	}
}
