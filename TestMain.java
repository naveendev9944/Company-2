import com.pratian.hr.*;
import com.pratian.sysadmin.*;
import java.util.*;
public class TestMain{
    public static void main(String[] args) {
        SysAdminModule sys = new SysAdminModule();
        HRModule.registerListener(sys);

        // Add an employee to the HR Module
        byte g=1;
        Employee employee = new Employee("John", 1, g,g);
        HRModule.addEmployee(employee);

        // Check if SysAdminModule's isIPPresent method works
        short ip=1000;
        System.out.println("Is IP Present: " + sys.isIPPresent(ip));

        // Print all employees with their IP addresses
        for (Employee emp : HRModule.getEmployees()) {
            Computer computer = emp.getComputer();
            System.out.println("Employee: " + emp.getName() + ", IP: " + computer.getIp());
        }
    }
}
