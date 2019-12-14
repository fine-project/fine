package com.fineframework.util;

/**
 * 文字列を扱うユーティリティ。
 * @author masanii15
 * @since 0.1
 */
public class StringUtil {

    /**
     * Check if the string has value.
     * @param str String
     * @return true if has value
     */
    public static final boolean hasValue(String str) {
        if(str == null || str.length() == 0) {
            return false;
        }
        return true;
    }

    /**
     * Check if the string was null or empty.
     * @param str String
     * @return true if null or empty
     */
    public static final boolean isNullOrEmpty(String str) {
        if(str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Padding to left
     * @param str String
     * @param len length of after padding
     * @param paddingChar padding char
     * @return string after padding
     */
    public static final String leftPadding(String str, int length, char paddingChar) {
        if(str == null || str.length() == 0 || str.length() >= length) {
            return str;
        }
        
        int paddingLength = length - str.length();
        
        String returnValue = "";
        for(int i = 0; i < paddingLength; i++) {
            returnValue += paddingChar;
        }
            
        return returnValue + str;
    }
    
    /**
     * Padding to left
     * @param int Number
     * @param len length of after padding
     * @param paddingChar padding char
     * @return string after padding
     */
    public static final String paddingToBefore(int number, int length, char paddingChar) {
        return leftPadding(String.valueOf(number), length, paddingChar);
    }

    /**
     * Trim the left 
     * @param str String
     * @param trimChar charctor to trim
     * @return trimed string
     */
    public static final String leftTrim(String str, char trimChar) {
        if(str == null) {
            return null;
        }
        int beginIndex = 0;
        for(int i = 0; i < str.length(); i++) {
            beginIndex = i;
            if(str.charAt(i) != trimChar) {
                break;
            } 
        }
        return str.substring(beginIndex);
    }

}
