package com.app.spring.app.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution5 {
    public int threeSumClosest(int[] nums, int target) {
        List<Integer> outterList = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        Set<List<Integer>> outterSet = new HashSet<>();
        
        for (int i = 0; i< nums.length-2;i++){
            for(int j= i+1; j<nums.length-1;j++){
                for (int k = j+1; k<nums.length;k++){
                    innerList.add(nums[i]);
                    innerList.add(nums[j]);
                    innerList.add(nums[k]);
                    outterSet.add(new ArrayList<Integer>(innerList));
                    innerList.clear();
                }
            }
        } 
        addSetVals(outterList,outterSet);
       
        return getClosestSum(outterList,target);
    }
    
    private  List<Integer> addSetVals(List<Integer> list,Set<List<Integer>> set){
        Integer sum = 0;
        
        for (List<Integer> l:set){
            for (Integer i:l){
                sum+=i;
            }
            list.add((sum));
            sum = 0;
        }
        for (Integer i :list) {
        		System.out.println(i);
        }
       return list;
    }
    
    private  int getClosestSum(List<Integer> list,int target){
        int closest = 0;
        int diff = 1000;
        for (Integer elem: list){
            if(Math.abs(target-elem) < diff){
                diff = Math.abs(target-elem);
                closest = elem;
            }
        }
        return closest;
    }
    
    public static void main (String [] args){
        Solution5 s = new Solution5();
        int[] nums = {1,1,1,0};
        int target = -100;
        System.out.format("Closest Sum is : %s ",s.threeSumClosest(nums,target));
        
    }
}
