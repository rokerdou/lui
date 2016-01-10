package cn.iolove.lui.page;



import cn.iolove.luajava.LuaException;
import cn.iolove.lui.view.LuiView;

public interface PageCircle {
public void Oncreate() throws LuaException;
public void onDestroy();
public void OnFronted();
public LuiView getRootView();
public String getPageName();
public abstract void OnBackend();

public abstract boolean OnNavBack();

}
