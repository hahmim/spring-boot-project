package com.app.spring.app.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.util.StringUtils;

public class Student {
    private String name;
    private double cgpa;
    private int id;
    
    Student(int id, String name,double cgpa){
        this.id = id;
        this.cgpa = cgpa;
        this.name = name;
    }
    
    public int getId (){
        return this.id;
    }
    
    public double getCgpa(){
        return this.cgpa;
    }
    
    public String getName(){
        return this.name;
    }

    
    static class Priority{
        
        private static final String ENTER_STRING = "ENTER";
        private static final String SERVE_STRING = "SERVE";
        
        @SuppressWarnings("unchecked")
		public static List<Student> getStudent(List<String> events){
            List<Student> students = new ArrayList<>();
			Queue<Student> queue = new PriorityQueue<>(20,new StudentComparator());
            for (String s: events){
                if(StringUtils.startsWithIgnoreCase(s,"E")){
                   queue.add(parseInput(s));
                }else{
                    queue.poll();
                }
            }
            
            students.addAll(queue);
            return students;
        }
        
    private static Student parseInput(String input){
    		String newInput = input.substring(ENTER_STRING.length()+1);
           String [] arr = newInput.split("(?<=\\D)(?=\\d)");
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
        return new Student(Integer.valueOf(strs.get(2)),strs.get(0),Double.valueOf(strs.get(1)));
        
    }
}

    static class StudentComparator implements Comparator{
    
    	@Override    
    	public int compare (Object o1, Object o2){
    		Student s1 = (Student) o1;
    		Student s2 = (Student) o2;
            if (s1.getCgpa() < s2.getCgpa()){
                return 1;
            }else if (s1.getCgpa() > s2.getCgpa()){
                return -1;
            }else
                return studentNameCompare(s1,s2);
        }
    	
        private int studentNameCompare(Student s1, Student s2){
            if (s1.getName().compareTo(s2.getName()) > 0){
                return 1;
            }else if (s1.getName().compareTo(s2.getName()) < 0){
                return -1;
            } else 
                return studentIdCompare(s1,s2);
        }
        private int studentIdCompare(Student s1, Student s2){
            if (s1.getId() < s2.getId()) {
            	return 1;
            }
            if (s1.getId() > s2.getId()) {
            	return -1;
            }
			return 0;
        }

    }
    public static void main(String[] args) {
    	
    	List<String> events = new ArrayList<>();
    	events.add("ENTER Amy 3.75 50");
    	events.add("ENTER Jane 3.8 52");
    	events.add("ENTER Anil 3.8 53");
    	events.add("ENTER Anil 3.8 54");
    	events.add("ENTER Be 3.70 55");
    	
    	events.add("SERVED");
    	events.add("ENTER Mani 3.9 56");
    	events.add("ENTER Mike 3.4 57");

        
        List<Student> students = Priority.getStudent(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName()+ " "+st.getCgpa()+ " "+ st.getId());
            }
        }
}
}