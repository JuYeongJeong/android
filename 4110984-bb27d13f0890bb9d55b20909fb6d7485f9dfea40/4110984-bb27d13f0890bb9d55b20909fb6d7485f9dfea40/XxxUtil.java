package demo.powermock;

import java.io.File;


public class XxxUtil {

	public static boolean isSafe(int i) {
		if(i > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private String name = "XxxUtil";
	public String getName() {
    	return name;
    }
	public void setName(String name) {
    	this.name = name;
    }
	
	/*
	 * 1. mock java core library
	 *  - 无结果返回，只能verify方法是否被调用
	 *  - 且是Java自身类
	 */
	public static void sleep(long time) throws Exception {
		Thread.sleep(time);
	}
	
	/*
	 * 2. mock java core library
	 *  - new instance
	 */
	public static void readFile(String filename) throws Exception {
		File file = new File(filename);
		System.out.println(file.getAbsolutePath());
	}
	
}
