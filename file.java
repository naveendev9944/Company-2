import java.util.*;
						//hr module
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
    private int empID;
    private Gender gender;
    private Role role;
    private Computer computer;

    public Employee(String name, int empID,byte g,byte role) {
        this.name = name;
        this.empID = empID;
        this.gender=Gender.values()[g-1];
        this.role=Role.values()[role-1];;
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


							//Sys admin module
							
abstract class Computer{
	private short ip;
	
	public short getIp(){
		return this.ip;
	}
	public void setIp(short ip){
		this.ip=ip;	
	}
}
class Laptop extends Computer{
	Laptop(short ip){
		super.setIp(ip);
	}
}
class Desktop extends Computer{
	Desktop(short ip){
		super.setIp(ip);
	}
}

class SysAdminModule implements EmployeeListener{
	static List<Computer> cmp=new ArrayList<>();
	static short i=1000;
	
	public boolean isIPPresent(short ip) {
	        for (Computer computer : cmp) {
	            if (ip==computer.getIp()) {
	                return true;
	            }
	        }
	        return false;
	}

	public void employeeAdded(Employee employee) {
        	Computer computer;
        	if (employee.getRole() == Role.Manager) {
        	    computer = new Laptop(i++);
        	}
        	else {
        	    computer = new Desktop(i++);
        	}
        	cmp.add(computer);
        	employee.setComputer(computer);
	} 
}

class file{
    public static void main(String[] args) {
        SysAdminModule sys = new SysAdminModule();
        HRModule.registerListener(sys);
	Scanner sc=new Scanner(System.in);

	boolean loop = true;
    	while (loop)
      	   {
		System.out.println("1.Add Employee  \n2.Show Employee\n3.Check Ip \n4.Exit");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice){
	  		case 1:{
	  			
	     		        System.out.println ("Enter the Employee Name:");
	     		        String name=sc.nextLine();
	     		        System.out.println ("Enter the Employee id:");
	     		        int id=sc.nextInt();
	     		        System.out.println ("Enter the gender\n1.Male\n2.Female");
	     		        byte gender=sc.nextByte();
	     		       	System.out.println ("Enter the role\n1.Manger\n2.Others");
	     		        byte role=sc.nextByte();
				sc.nextLine();
				Employee employee = new Employee(name, id, gender,role);
        			HRModule.addEmployee(employee);
				System.out.println(name+" was added as an employee\n");
	     			break;
	   		 }
	 		 case 2:{
				System.out.println("Employees in the organaization");
				for (Employee emp : HRModule.getEmployees()) {
            				Computer computer = emp.getComputer();
            				System.out.println("Employee: " + emp.getName() + ", IP: " + computer.getIp());
        			}
	      			break;
	    		}

	  		case 3:{
				System.out.println("Enter ip");
	    			short ip=sc.nextShort();
        			System.out.println("Is IP Present: " + sys.isIPPresent(ip));
				break;
	    		}
	    		
	  		case 4:{
	      			loop=false;
	 		 }
      	   }
       }

        
    }
}
