package com.app.spring.app.practice;

class Solution {
    public int divide(int dividend, int divisor) {
        
        int sum = 0;
        int counter = 0;
        int  positiveOverflow = 2147483647;
        int  negativeOverflow = -2147483648;
        if ((dividend <= negativeOverflow || dividend >=  positiveOverflow) && Math.abs(divisor) == 1){
            counter = positiveOverflow;
        }
        if( Math.abs(dividend) == 1 && Math.abs(divisor) == 1){
          counter = 1;  
        }else{
        for (int i = 0 ; i < dividend; i++){
        if (sum + Math.abs(divisor) <= Math.abs(dividend)){
            sum+=Math.abs(divisor);
            counter++;
        }
        }
        }
        if (counter-1 == negativeOverflow && (0 - divisor < 0 )){
            return negativeOverflow;
        }

        if((0 - divisor > 0 || 0 - dividend > 0) && !((0 - divisor > 0 ) && (0 - dividend > 0))){
            counter = 0 - counter;
        }

        return counter;
        
    }
    public static void main (String [] args){
        Solution solution = new Solution();
        System.out.println(solution.divide(-2147483648,-1));
        
        
    }
}