package org.news.util;
import java.util.*;
import java.io.*;
//单例模式
public class ConfigManager extends Properties {
	private static final long serialVersionUID = 1L;
	private static volatile ConfigManager config = null;
	private ConfigManager() {
		// 读取属性文件
		InputStream in = null;
		try {
			in = ConfigManager.class.getClassLoader().getResourceAsStream("database.properties");
			load(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static ConfigManager getInstance() {
		if (config == null) {
			synchronized (ConfigManager.class) {
				if (config == null) {
					config = new ConfigManager();
				}
			}
		}
		return config;
	}
	public static void main(String[] args) {
		ConfigManager config = ConfigManager.getInstance();
		System.out.println(config.getProperty("driver"));
	}
}
