import java.util.*;
						//hr module
enum Gender{
	Male,
	Female
}
class Employee {
    private String name;
    private long empID;
    private Gender gender;
    private Computer computer;

    public Employee(String name, long empID, Gender gender) {
        this.name = name;
        this.empID = empID;
        this.gender = gender;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public String getName() {
        return name;
    }

    public Computer getComputer() {
        return computer;
    }
}

interface EmployeeListener{ 
	void employeeAdded(Employee e){
	} 
}
class Company{
	
	Private Set<Employee> emp=new HashSet<>();
	Private Set<EmployeeListener> emplistener=new HashSet<>();
	private List<Employee> employees=new ArrayList<>();
	static void addEmployee(Employee e) {
		emp.add(e);
		notifyListners(e);
	}
	
	static void registerListener(EmployeeListener listener){
		emplistener.add(e);
	}
	
	
	static void notifyListners(Employee e){
		
	}
	/*public Employee getEmployee(String name){
		for(Employee employee :employees){
			if(employee.getName().equals(name))
				return employee;
		}
		return null;
	}*/
}


							//Sys admin module
							
abstract class Computer{
	private String ip;
	
	public getIp(){
		return this.ip;
	}
	public setIp(String ip){
		this.ip=ip;	
	}
}
class Laptop extends Computer{
	Laptop(String ip){
		super.setIp(ip);
	}
}
class Desktop extends Computer{
	Desktop(String ip){
		super.setIp(ip);
	}
}

class SysAdminModule implements EmployeeListener{
	static List<Computer> cmp=new ArrayList<>();
	static assignIp() 
}
