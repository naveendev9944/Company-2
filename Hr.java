package hr;

import java.util.*;
						
enum Gender{
	Male,
	Female
}
enum Role{
	Manager,
	Others
}
class Employee {
    private String name;
    private long empID;
    private Gender gender;
    private Role role;
    private short computer;

    public Employee(String name, long empID,byte g,byte role) {
        this.name = name;
        this.empID = empID;
        this.gender=Gender.values()[g-1];
        this.role=Role.values()[role-1];;
    }

    public void setComputer(short computer) {
        this.computer = computer;
    }

    public String getName() {
        return name;
    }

  
    public Role getRole(){
		return this.role;
	}
}

interface EmployeeListener{ 
	void employeeAdded(Employee e);
}
class HRModule{
	
	private static List<Employee> emp= new ArrayList<>();
    	private static List<EmployeeListener> emplistener = new ArrayList<>();
	static void addEmployee(Employee e) {
		emp.add(e);
		notifyListners(e);
	}
	
	static void registerListener(EmployeeListener listener){
		emplistener.add(listener);
	}
	
	static void notifyListners(Employee e){
		for(EmployeeListener em:emplistener){
			em.employeeAdded(e);	
		}
	}
	public static List<Employee> getEmployees(){
		return emp;
	}
}
