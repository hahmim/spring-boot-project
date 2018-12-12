package com.app.spring.app.practice;

import java.util.HashSet;
import java.util.Set;

class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int initMax = 0;
        int max = 0;
    	    set.add(s.charAt(0));
        for (int i = 0;i<s.length();i++){
        	set.add(s.charAt(i));
            for (int j=i+1;j<s.length();j++){
                if (s.charAt(i) != (s.charAt(j))){
                    set.add(s.charAt(i));
                    set.add(s.charAt(j));
                    initMax = set.size();
                }else {
                	set.clear();
                	break;
                	
                }
                
            }
            if (max<initMax) {
            	max = initMax;
            }else {
            	max = set.size();
            }
        }
       return max; 
    }
    
    public static void main (String args[]){
        Solution1 solution = new Solution1();
            System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
    
}