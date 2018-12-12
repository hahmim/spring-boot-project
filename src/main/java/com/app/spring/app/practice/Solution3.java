package com.app.spring.app.practice;

import java.math.BigDecimal;

class Solution3 {
	public int myAtoi(String str) {
		long num = 0L;
		if (str=="" || str.substring(0, 1).matches("[a-zA-z]{1}")) {
			return 0;
		}
		str = str.replaceAll("\\s+","");
		if(str.substring(0, 1).matches("\\d{1}")) {
			for (int i = 0; i < str.length(); i++) {
				if(!str.substring(i,i+1).matches("[a-zA-z]{1}")){
					if ((str.charAt(i)!='.')) {
						num = (Long.valueOf(String.valueOf(num) + str.charAt(i)));
					}else {
						num = (Long.valueOf(String.valueOf(num) + '.'));
					}
					
				}
				
			}
			
		}else if (str.substring(0, 1).matches("-")) {
			for (int i = 1; i < str.length(); i++) {
                if(!str.substring(i,i+1).matches("[a-zA-z]{1}")){
                    num = Long.valueOf(String.valueOf(num) + str.charAt(i));  
                  }
			}
			num = 0 - num;
		}
		if (num > (Math.pow(2, 31) - 1)) {
			num = 2147483647L;
		} else if (num < (Math.pow(-2, 31))) {
			num = -2147483648L;
		}
		return (int) (num);
	}

	public static void main(String args[]) {
		Solution3 solution = new Solution3();
		System.out.println(solution.myAtoi("3.14"));
	}
}
