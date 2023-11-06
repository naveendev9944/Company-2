package payroll;
import java.util.*;
import hr.*;
import java.lang.Math;
					
abstract class Account{
	private int accno;
	
	public int getAcc(){
		return this.accno;
	}
	public void setAcc(int accno){
		this.accno=accno;
	}
}
class Bank1 extends Account{
	Bank1(int accno){
		super.setAcc(accno);
	}
}
class Bank2 extends Account{
	Bank2(int accno){
		super.setAcc(accno);
	}
}

public class PayrollModule implements EmployeeListener{
	static List<Account> account=new ArrayList<>();
	static int i=(int)(Math.random() * 34567893) ;
	Scanner sc=new Scanner(System.in);
	public void employeeAdded(Employee employee) {
        	Account acc;
		System.out.println("Choose the bank\n1.Bank1\n2.Bank2");
        	byte ch=sc.nextByte();
		sc.nextLine();
        	if (ch ==1) {
        	    acc = new Bank1(i);
        	}
        	else {
        	    acc = new Bank2(i);
        	}
        	account.add(acc);
        	employee.setAccount(i);
	} 
}  
