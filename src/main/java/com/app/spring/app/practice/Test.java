package com.app.spring.app.practice;

import java.util.*;
public class Test {
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
//    	6 3
//    	5 3 5 2 3 2
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        List<List<Integer>> intList = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(Integer.valueOf(num));
        }
        
        for (int i = 0; i < n; i++) {
        	if (deque.size() < m) {
        		break;
        	}
        Deque temp = new ArrayDeque<>(deque);
        
            for (int j = 0 ; j < m ; j++){
                innerList.add((Integer) temp.pollFirst());
                }
                intList.add(new ArrayList(innerList));
                innerList.clear();
                deque.removeFirst();
         }
        

        int res = countUniqValues(intList);
        System.out.println(res);
    }
    public static int countUniqValues(List<List<Integer>> list){
        int count = 0;
        int max = 0;
        Set <Integer> set = new HashSet<>();
        for (List<Integer> l: list){
            for (Integer elem: l){
                if(set.add(elem))
                    count++;
                if(count>max){
                    max = count;
                }
            }
        }
        return max;
    }
}