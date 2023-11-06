package hr;

import java.util.*;
						
enum Gender{
	Male,
	Female
}



interface EmployeeListener{ 
	void employeeAdded(Employee e);
}