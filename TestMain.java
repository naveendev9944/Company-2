package main;
import hr.Hr;	
import sysadmin.Sysad;
import java.util.*;
public class TestMain{
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
            				System.out.println("Employee: " + emp.getName() + ", IP: " + emp.getIp());
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
