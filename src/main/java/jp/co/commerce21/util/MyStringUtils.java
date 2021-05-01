package jp.co.commerce21.util;

public final class MyStringUtils {

	public static String setCsvStr(String str) {
		if (str == null) {
			str = "";
		}
        return "\"" + str.replace("\"", "\"\"") + "\"";
	}
	
	public static String csvDqDel(String str) {		
		if (str == null) {
			return "";
		}
		return str.replace("\"", "");
	}
	
	public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
	
}
