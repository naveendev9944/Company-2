package hr;

import java.util.*;
						
enum Gender{
	Male,
	Female
}


public class HRModule{
	
	private static List<Employee> emp= new ArrayList<>();
    	private static List<EmployeeListener> emplistener = new ArrayList<>();
	public static void addEmployee(Employee e) {
		emp.add(e);
		notifyListners(e);
	}
	
	public static void registerListener(EmployeeListener listener){
		emplistener.add(listener);
	}
	
	public static void notifyListners(Employee e){
		for(EmployeeListener em:emplistener){
			em.employeeAdded(e);	
		}
	}
	public static List<Employee> getEmployees(){
		return emp;
	}
}
