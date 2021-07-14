package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Department;

import daoClasses.DepartmentDAO;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDAO department;
	public List<Department> getAllDepartments() {
		
		return department.getAllDepartments();
	}

	
}