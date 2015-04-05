package cn.iolove.lui.utils;

import cn.iolove.lui.page.Page;

public class PageFactory {
	public static Page CreatePage(String pagename)
	{
		return new Page(pagename);
	}

}
