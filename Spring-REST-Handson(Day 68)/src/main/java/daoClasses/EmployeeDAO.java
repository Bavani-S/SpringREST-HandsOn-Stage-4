package daoClasses;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.Employee;

import Exception.EmployeeNotFoundException;


@Component
public class EmployeeDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAO.class);
	static ArrayList<Employee> empList;
	public EmployeeDAO() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		empList = (ArrayList<Employee>) context.getBean("employeeList");
	}
	
	public List<Employee> getAllEmployee(){
		return empList;
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException
	{
		
		for(Employee emp: empList)
		{
			if(emp.getId()==employee.getId())
			{
				emp.setName(employee.getName());
				emp.setSalary(employee.getSalary());
				emp.setDateOfBirth(employee.getDateOfBirth());
				emp.setPermanent(employee.getPermanent());
				emp.setDepartment(employee.getDepartment());
				emp.setSkill(employee.getSkill());
				
				return emp;
			}
		}
		throw new EmployeeNotFoundException();
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException
	{
		Employee temp=null;
		for(Employee emp: empList)
		{
			if(emp.getId()==id)
			{
				temp=emp;
						
			}
		}
		if(temp!=null)
		{
			empList.remove(temp);
		}
		else
		{
			throw new EmployeeNotFoundException();
		}
	}
}