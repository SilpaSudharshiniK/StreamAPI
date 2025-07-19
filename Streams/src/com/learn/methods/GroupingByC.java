package com.learn.methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByC {

	public static void main(String[] args) {
		
		
		List<StudentDetails> l = new ArrayList<>();
		StudentDetails sd1 = new StudentDetails(123,"Silpa",'F');
		StudentDetails sd2 = new StudentDetails(143,"Sweety",'F');
		StudentDetails sd3 = new StudentDetails(153,"Shiny",'F');
		l.add(sd3);
		l.add(sd2);
		l.add(sd1);
		
		Iterator<StudentDetails> it = l.iterator();

       while (it.hasNext()) {
            System.out.println(it.next());
        }
       
       
       List<String> names = Arrays.asList("Silpa","Aice","Silpa","Aice");
       Map<String, Long> collect2 = names
    		   .stream()
    		   .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
       
       collect2.forEach((word,freq) ->
       {
    	   System.out.println("Word : "+word+"\n"+"Count : "+" "+freq);
    	  
       });   
       
       
       //grouping students based on sex
       
       List<StudentDetails> stud0 = Arrays.asList(
    		   new StudentDetails(123,"Silpa",'F'),
    		   new StudentDetails(143,"Sweety",'M'),
    		   new StudentDetails(123,"Shony",'F'),
    		   new StudentDetails(113,"Sheeny",'M'));
       
       Map<Object, List<StudentDetails>> collect = stud0
    		   .stream()
    		   .collect(Collectors.groupingBy(n -> n.getSex()));
       
       System.out.println(collect);
       
       collect.forEach((key,value) ->
       {
    	   System.out.println("Grade: "+key);
    	   
    	   value.forEach(x ->System.out.println("   "+x.getName()));
       }
    		   
    		   );
       
	}
}
