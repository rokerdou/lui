package cn.iolove.lui.service;

import cn.iolove.lui.page.Page;

public interface PageServiceInterface {
	abstract public void pushPage(Page obj);
	abstract public void switchPage(Page obj);
	abstract public void popPage();
}
