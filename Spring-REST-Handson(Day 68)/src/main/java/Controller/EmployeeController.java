package Controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Employee;

import Service.EmployeeService;
import Exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value="/allEmployees",method = RequestMethod.GET)
	List<Employee> getAllEmployees(){
		LOGGER.info("List of all employees:");
		return employeeService.getAllEmployees();
		
	}
	
	@RequestMapping(value="/updateEmployee/{id}",method = RequestMethod.PUT)
	public Employee updateEmployee( @RequestBody Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("Employee detail update:");
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException
	{
                                   LOGGER.info("Employee removal:");
		employeeService.deleteEmployee(id);
	}
}
