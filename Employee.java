package hr;

import java.util.*;
enum Role{
	Manager,
	Others
}
enum Gender{
	Male,
	Female
}

public class Employee {
    private String name;
    private byte empID;
    private Gender gender;
    private Role role;
    private short computer;
    private int accno;

    public Employee(String name, byte empID,byte g,byte role) {
        this.name = name;
        this.empID = empID;
        this.gender=Gender.values()[g-1];
        this.role=Role.values()[role-1];;
    }

    public void setComputer(short computer) {
        this.computer = computer;
    }
    public void setAccount(int accno) {
        this.accno = accno;
    }

    public String getName() {
        return name;
    }
    public short getIp(){
		return this.computer;
	}
  
    public Role getRole(){
		return this.role;
	}
	
    public Role getMan(){
		return Role.Manager;
	}
}
