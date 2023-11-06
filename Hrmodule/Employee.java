package hr;

import java.util.*;

public class Employee {
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
    public short getIp(){
		return this.computer;
	}
  
    public Role getRole(){
		return this.role;
	}
}
