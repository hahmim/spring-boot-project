package com.app.spring.app.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


class Solution7 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outterList = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        Set<List<Integer>> outterSet = new HashSet<>();
        for (int i = 0; i< nums.length-2;i++){
            for(int j= i+1; j<nums.length-1;j++){
                for (int k = j+1; k<nums.length;k++){
                    if (nums[i]+nums[j]+nums[k]== 0){
                        innerList.add(nums[i]);
                        innerList.add(nums[j]);
                        innerList.add(nums[k]); 
                        Collections.sort(innerList);
                        outterSet.add(new ArrayList(innerList));
                        innerList.clear();
                    }
                }                               
            }
        }
        addElms(outterList,outterSet);
       return outterList; 
    }
    private static List<List<Integer>>addElms(List<List<Integer>> list,Set<List<Integer>> set){
    		for (List<Integer> l:set) {
    			list.add(l);
    		}
		return list;
    	
    }
    public static void main (String args[]){
        Solution7 solution7 = new Solution7();
        int [] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> numsList = solution7.threeSum(arr);
        for (List<Integer> list: numsList){
            System.out.println(list);
        }
            
    }
}