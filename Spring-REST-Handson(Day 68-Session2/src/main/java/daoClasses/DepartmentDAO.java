package daoClasses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.Department;


@Component
public class DepartmentDAO {

	static ArrayList<Department> deptList;
	
	@SuppressWarnings({ "unchecked", "resource" })
	public DepartmentDAO() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		deptList = (ArrayList<Department>) context.getBean("departmentList");
	}

	public List<Department> getAllDepartments() {
		return deptList;
	}
}