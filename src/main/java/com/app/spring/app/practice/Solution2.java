package com.app.spring.app.practice;

class Solution2 {
    public String longestPalindrome(String s) {
        if (s.equals("")|| s.length() == 1){
            return s;
        }
        int num = 0;
        String longestPalidrom = "";
        boolean isPalindrom = false;
        int i = 0;
        for (i = 0; i<= s.length()/2; i++){
            if (s.charAt(i)==s.charAt(s.length()-1-i)){
                isPalindrom = true;
                continue;
            }else{
                num = i;
             }
        }
        if(isPalindrom){
           longestPalidrom = s.substring(num+1,s.length()-(num+1)); 
        }
        
        return longestPalidrom;
    }
    public static void main (String args[]){
       Solution2 solution = new Solution2(); 
        System.out.println(solution.longestPalindrome("aaabaaaa"));
    }
}
