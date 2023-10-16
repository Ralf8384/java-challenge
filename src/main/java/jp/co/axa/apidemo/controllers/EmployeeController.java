package jp.co.axa.apidemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import jp.co.axa.apidemo.utils.Result;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /**
     * getEmployees<br>
     * <br>
     * <br>
     * return all the results
     * 
     * @return Result all the results
     */
    @GetMapping("/employees")
    public synchronized Result getEmployees() {
        List<Employee> employees = employeeService.retrieveEmployees();
        return Result.success(employees,null);
    }

    /**
     * getEmployee<br>
     * <br>
     * <br>
     * return the result by employeeId
     * 
     * @return Result result by employeeId
     */
    @GetMapping("/employees/{employeeId}")
    public synchronized Result getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
       return Result.success(employee,null);
    }

    /**
     * saveEmployee<br>
     * <br>
     * <br>
     * insert the result
     * 
     * @return Result null
     */
    @PostMapping("/employees")
    public synchronized Result saveEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return Result.success("Employee Saved Successfully");
    }

    /**
     * deleteEmployee<br>
     * <br>
     * <br>
     * delete the result by employeeId
     * 
     * @return Result null
     */
    @DeleteMapping("/employees/{employeeId}")
    public synchronized Result deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return Result.success("Employee Deleted Successfully");
    }

    /**
     * udateEmployee<br>
     * <br>
     * <br>
     * update the result by employeeId
     * 
     * @return Result null
     */
    @PutMapping("/employees/{employeeId}")
    public synchronized Result updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name = "employeeId") Long employeeId) {
        Employee emp = employeeService.getEmployee(employeeId);
        if (emp != null) {
            employeeService.updateEmployee(employee);
            return Result.success("Employee Update Successfully");
        }
        return Result.error("Employee Update failed");
    }

}
