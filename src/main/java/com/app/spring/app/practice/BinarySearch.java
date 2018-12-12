package com.app.spring.app.practice;

public class BinarySearch {
	
	private static int [] sort(int [] arr) {
		for (int i = 0; i<arr.length;i++) {
			for (int j=i+1; j<arr.length;j++) {
				if (arr[j]<arr[i]) {
					int temp = arr[j];
					arr[j]=arr[i];
					arr[i]=temp;

				}
			}
		}
		return arr;
		
	}

	
	public Integer search(int []arr, int l,int r,int x) {
		if (arr.length == 0) {
			return null;
		}
		while(l <= r) {
			int mid = (l + (r-1))/2;
			if (arr[mid] == x) {
				return mid;
			}else if (x > mid){
				search(arr,mid+1,arr.length,x);
			}
				 
			return search(arr,1,mid-1,x);
			
		}
		return -1;
	}
	
	public static void main (String [] args) {
		BinarySearch binarySearch = new BinarySearch();
		int [] arr = {1,5,3,8,12,6,4,9};
		sort(arr);
		
		
		Integer p = binarySearch.search(arr,0, arr.length, 5);
		if (p!=null) {
			System.out.println(p);
		}else {
			System.out.println("Something went wrong ...");
		}
		
	}

}
