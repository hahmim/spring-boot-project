package com.app.spring.app.practice;

class Solution4 {
    public int[] twoSum(int[] nums, int target) {
        int [] sums = new int [2];
        for (int i=0; i<nums.length;i++){
            for (int j=i+1; j<nums.length;j++){
                if (nums[i]+nums[j] == target) {
                    sums[0]=i;
                    sums[1]=j;
                }

            }
        }
        return sums;
    }
    
    public static void main (String args []){
   
    			
        Solution4 solution4 = new Solution4();
        int [] arr = {3,2,4};
        int [] sol = new int [2];
        sol = solution4.twoSum(arr,6);
        System.out.println(sol[0]+" " +sol[1]);
        
    }
}
