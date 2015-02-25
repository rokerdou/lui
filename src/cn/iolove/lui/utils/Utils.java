package cn.iolove.lui.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.util.EncodingUtils;

import android.content.Context;

public class Utils {

	/**
	 * @param args
	 */
	public static String loadAssetsString(String resPath,Context co) {
		InputStream isread = null;
		byte[] luaByte = new byte[1];
		try { 
			isread = co.getAssets().open(resPath);
			int len = isread.available();
			luaByte = new byte[len];
			isread.read(luaByte);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (isread != null) {
				try {
					isread.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return EncodingUtils.getString(luaByte, "UTF-8");
	} 
}
