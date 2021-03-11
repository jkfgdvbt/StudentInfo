package com.jkfgdvbt.util;

/**
 * 字符串工具：判断是否为空
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年2月1日
 */

public class StringUtil {
	public static boolean isEmpty(String str)
	{

		if("".equals(str) || str == null) { // if String == null, str.equals()会抛异常。不要用未知的变量调用方法（空指针异常）
			return true;
		}
		return false;
	}
}
