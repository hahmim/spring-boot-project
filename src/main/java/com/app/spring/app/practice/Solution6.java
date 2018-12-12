package com.app.spring.app.practice;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
	static ListNode head;
    class ListNode {
    		 
         int val;
         ListNode next;
         ListNode(int x) { 
        	 val = x;
        	 next = null;
        	 }
    }
    private void push (int val) {
    	ListNode new_node = new ListNode(val);
    	new_node.next = head;
    	head = new_node;
    }
    private List<Integer> valsList(ListNode head){
    	List<Integer> dataList = new ArrayList<>();
    	while(head!=null) {
    		dataList.add(head.val);
    		head = head.next;
    	}
    	return dataList;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	 List<Integer> dataList = valsList(head);
    	int val = dataList.get(dataList.size()-n);
        return removeNthElm(head,val);
        
    }
    
    public static void dispNode(ListNode node){
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    
    public ListNode removeNthElm(ListNode head, int pointer){


        ListNode prev = null;
        ListNode temp = head;
        if (temp!=null && temp.val == pointer) {
        		return temp.next;
        }
        while(temp!=null && temp.val!= pointer) {
        		prev = head;
        		temp = temp.next;
        }
        if (temp == null) {
        	return null;
        }
        prev.next = temp.next;
        return prev;
    }
    
    public static void main (String []args){
    	Solution6 solution = new Solution6();
    		solution.push(1);
    		solution.push(2);
    		solution.push(3);
    		solution.push(4);
    		solution.push(5);
        dispNode(head);
      
        
        
        ListNode newHead = solution.removeNthFromEnd(head,2);
        dispNode(newHead);
    }
}
