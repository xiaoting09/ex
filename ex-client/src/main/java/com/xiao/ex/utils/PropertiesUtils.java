
package com.xiao.ex.utils;

import java.util.Properties;


/**
 * 加载配置文件.
 */
public class PropertiesUtils {
	private static Properties props = new Properties();
	static {
		try {
			props.load(PropertiesUtils.class.getClassLoader()
					.getResourceAsStream("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		String code = "";
		try {
			code = props.getProperty(key);
			if (code!=null&&code.trim().length()>0) {
				code = new String(code.getBytes("ISO-8859-1"),"utf-8");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}

}
