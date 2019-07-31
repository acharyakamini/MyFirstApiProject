package createApi.springbootstart.controller.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

	private List<Employee> employee = new ArrayList<> (Arrays.asList(
			new Employee("101","Jack","Engg"),
			new Employee("102","Marry","Tech"),
			new Employee("103","Harry","HR")
			));

	public List<Employee> getAllEmployee() {
		return employee;
	}

	public Employee getEmployee(String id) {
		return employee.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addEmployee(Employee emp) {
		employee.add(emp);

	}

	public void updateEmployee(String id, Employee emp) {
		for(int i =0; i <employee.size();i++) {
			Employee t = employee.get(i);
			if(t.getId().equals(id)) {
				employee.set(i,emp);
				return;

			}


		}
	}
	public void deleteTopics(String id) {
		employee.removeIf(t ->t.getId().equals(id));
}
}




