package jp.co.axa.apidemo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiDemoApplicationTests {

	@Autowired
	private EmployeeService employeeService;


	@Test
	public void contextLoads() {

	}


	@Test
	public void testRetrieveEmployees() {
		List<Employee> employees = employeeService.retrieveEmployees();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	@Test
	public void testGetEmployee() {
		Employee employee = employeeService.getEmployee(1L);
		System.out.println(employee);
	}


	@Test
	public void testSaveEmployee() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("testOne");
		employee.setSalary(6000);
		employee.setDepartment("001");
		employeeService.saveEmployee(employee);
	}

	@Test
	public void testDeleteEmployee() {
		employeeService.deleteEmployee(1L);
	}


	@Test
	public void testUpdateEmployee() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("testOneUPload");
		employee.setSalary(6000);
		employee.setDepartment("001");
		employeeService.updateEmployee(employee);
	}
}
