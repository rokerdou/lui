package cn.iolove.lui.service;

public class Registry {

private static Registry obj = new Registry();
private Registry(){}
public static Registry getInstance(){return obj;}

}
