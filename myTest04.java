/**
* Title: myTest04.java
* Description: All Rights Reserved !!!
* Copyright: Copyright (c) 2017
* Company: BUCT
* @author JiangXingAn
* @date 2017年5月5日
* @time 下午5:26:06
* @version 1.0
*/
public class myTest04 {
	public static boolean replaceblank(char[] str,int length) {
		for(int i=0;i<str)
	}
}
class Solution {
    public static String replaceSpace(StringBuffer str) {
    	if (str == null ){
            return null ;
        }
        StringBuffer new_str = new StringBuffer();
        for(int i=0;i<str.length();i++){
            if (str.charAt(i) == ' ') {
                new_str.append('%');
                new_str.append('2');
                new_str.append('0');
            }else {
                new_str.append(str.charAt(i));
            }
        }
        return new_str.toString();
    }
}