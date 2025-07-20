package com.learn.methods.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandsonStreams {

	private static List<Employee> e;

	public static void main(String[] args) {
		
		e = new ArrayList<>();
		
		e.add(new Employee(1,"Jhansi",32,"Female","Sales",2011,25000.0));
		e.add(new Employee(2,"Smith",25,"Male","Development",2015,13500.0));
		e.add(new Employee(3,"David",29,"Male","Infrastructure",2012,13500.0));
		e.add(new Employee(4,"Orlen",28,"Male","Development",2017,32500.0));
		e.add(new Employee(5,"Charles",27,"Male","Sales",2013,22700.0));
		
		System.out.println("======Count of males and females======");
		
		Map<String, Long> collect = e.stream()
		.collect(Collectors.groupingBy(x ->x.getGeneder(),Collectors.counting()));
		
		
		collect.forEach((gender,count) ->
		{
		       System.out.println("gender is: "+gender);
		       System.out.println("Count is: "+count);
		}
		       
		);
		
		
		System.out.println("======Print all departments======");
		
		List<String> distinctDepartments = e.stream()
				.map(x->x.getDepartment()).distinct()
				.collect(Collectors.toList());
		
		System.out.println(distinctDepartments);
		
		
		System.out.println("======Avg age of male and female======");
		
		Map<String, Double> avgAge = e.stream()
		.collect(Collectors.groupingBy(n->n.getGeneder(),
				Collectors.averagingInt(n->n.getAge())));
		
		avgAge.forEach((gender,count) ->
		{
		       System.out.println("gender is: "+gender);
		       System.out.println("Count is: "+count);
		}
		       
		);

		System.out.println("======Highest salary Employee======");
		
		Optional<Employee> maxSalary = e.stream()
				.max(Comparator.comparingDouble(Employee::getSalary).reversed());
		
		if(maxSalary.isPresent()) {
			System.out.println("Highest salary Employee is: "+maxSalary.get().getName());
		}
		
		System.out.println("======Employee joined after or equal to 2015======");
		
		e.stream()
		.filter(n ->n.getYearOfJoining()>=2015)
		.map(n->n.getName())
		.forEach(System.out::println);
		
		
		System.out.println("======Count of no of employees in each department======");
		
		Map<String, Long> departmentEmployeesCount = e.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		
		departmentEmployeesCount.forEach((department,count) ->
		{
		       System.out.println("Department is: "+department);
		       System.out.println("Count is: "+count);
		}
		       
		);
		
		
		System.out.println("======Average Salary of employees in each department======");
		
		Map<String, Double> avgSalariesInDepartments = e.stream().collect(Collectors.groupingBy(Employee::getDepartment
				,Collectors.averagingDouble(Employee::getSalary)));
		
		System.out.println(avgSalariesInDepartments);
		
		System.out.println("======Youngest Employee in Development department======");
		
	Optional<Employee> first = e.stream()
			.filter(n->n.getDepartment().equals("Development") && n.getGeneder().equals("Male"))
	.min(Comparator.comparing(Employee::getAge));
	
	if(first.isPresent()) {
		System.out.println("Youngest Employee in Development: "+first.get().getName());
	}
	else {
		System.out.println("Employee not present");
	}
	
	System.out.println("======Most working experience person======");
				
	Optional<Employee> min = e.stream().min(Comparator.comparing(Employee::getYearOfJoining));
	if(min.isPresent()) {
		System.out.println("Most working experience person: "+min.get().getName());
	}
	
	System.out.println("======Male and Female count in Sales Department======");
	
	Map<String, Long> collect2 = e.stream()
	.filter(n->n.getDepartment().equals("Sales"))
	.collect(Collectors.groupingBy(Employee::getGeneder,Collectors.counting()));
	
	System.out.println(collect2);
	
	
	Map<Boolean, List<Employee>> agePartioning = e.stream().collect(Collectors.partitioningBy(n->n.getAge()>=25));
	System.out.println("Age >=25: "+agePartioning.get(true));
	System.out.println("Age <=25: "+agePartioning.get(false));
		

	}

}
