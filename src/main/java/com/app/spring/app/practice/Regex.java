package com.app.spring.app.practice;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Predicate;

public class Regex {
	
	public String [] splitInput(String str) {
		String [] arr = str.split("(?<=\\D)(?=\\d)");
		return arr;
	}
	
	public static void main (String [] args) {
		Regex regex = new Regex();
		String[] arr = regex.splitInput("John 3.75 50");
		LinkedList<String> strs = new LinkedList<>();
		for (int i = 0; i < arr.length;i++) {
			strs.add(arr[i]);			
		}
		for (int i=0;i<strs.size();i++) {
			if(strs.get(i).contains(".")) {
				strs.add(i, strs.get(i)+strs.get(i+1));
				strs.remove(i+1);
				if(strs.get(i).contains(strs.get(i+1))) {
					strs.remove(i+1);
				}
				
			}
		}
	}


}
