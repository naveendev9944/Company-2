package sysadmin;
import java.util.*;
import hr.*;							
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
        	employee.setComputer(i-1);
	} 
}
