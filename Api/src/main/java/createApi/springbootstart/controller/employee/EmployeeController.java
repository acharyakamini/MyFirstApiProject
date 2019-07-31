package createApi.springbootstart.controller.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employee")
	public List<Employee> getAllTopics(){
	return employeeService.getAllEmployee();
	}

	@RequestMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return employeeService.getEmployee(id);
	}

	@RequestMapping(method= RequestMethod.POST, value="/employee")
	public void addEmployee(@RequestBody Employee emp) {
		employeeService.addEmployee(emp);
	}
	@RequestMapping(method= RequestMethod.PUT, value="/employee/{id}")
	public void updateEmployee(@RequestBody Employee emp,@PathVariable String id) {
		employeeService.updateEmployee(id,emp);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value="/employee/{id}")
	public void deleteEmployee(@PathVariable String id) {
		employeeService.deleteTopics(id);
	}

}
	
