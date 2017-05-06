public class myTest04_1 {
    public static String replaceSpace(StringBuffer str) {
    	if (str == null) {
    		return null;
    	}
    	int blanknum = 0;
       for(int i=0;i<str.length();i++) {
    	   if (str.charAt(i) == ' ') 
    		   blanknum++;
       }
       if (blanknum == 0)
    		   return str.toString();
       int strlengthold = str.length()-1;
       int strlength = str.length()+2*blanknum;
       int strlengthnew = strlength -1;
       str.setLength(strlength);
       for (;strlengthold>=0 && strlengthnew >=0;--strlengthold) {
    	   if (str.charAt(strlengthold) == ' ' ){
    			   str.setCharAt(strlengthnew--, '0');
    			   str.setCharAt(strlengthnew--, '2');
    			   str.setCharAt(strlengthnew--, '%');
    	   } else {
    		   str.setCharAt(strlengthnew--, str.charAt(strlengthold));
    	   }
       }
       return str.toString();
    }
    public static void main(String[] args) {
    	StringBuffer str1 = new StringBuffer("We are happy.");//正常
    	String string1 = replaceSpace(str1);
    	System.out.println(string1);
    	StringBuffer str2 = new StringBuffer("We are happy. ");//末尾空格
    	String string2 = replaceSpace(str2);
    	System.out.println(string2);
    	StringBuffer str3 = new StringBuffer(" We are happy.");//起始空格
    	String string3 = replaceSpace(str3);
    	System.out.println(string3);
    	StringBuffer str4 = new StringBuffer("We are  happy.");//连续空格
    	String string4 = replaceSpace(str4);
    	System.out.println(string4);
    	StringBuffer str5 = new StringBuffer("Wearehappy.");//没有空格
    	String string5 = replaceSpace(str5);
    	System.out.println(string5);
    	StringBuffer str6 = new StringBuffer("");//空字符串
    	String string6 = replaceSpace(str6);
    	System.out.println(string6);
    	StringBuffer str7 = new StringBuffer();//null
    	String string7 = replaceSpace(str7);
    	System.out.println(string7);
    	StringBuffer str8 = new StringBuffer(" ");//单个空格
    	String string8 = replaceSpace(str8);
    	System.out.println(string8);
    	StringBuffer str = new StringBuffer("   ");//多个空格
    	String string = replaceSpace(str);
    	System.out.println(string);
    }
}
