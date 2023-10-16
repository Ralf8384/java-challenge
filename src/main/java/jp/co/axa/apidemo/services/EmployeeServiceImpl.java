package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> retrieveEmployees() {
        try {
            return employeeRepository.findAll();
        } catch (Exception e) {
            logger.error("Error retrieving employees", e);
            throw e;
        }
    }

    public Employee getEmployee(Long employeeId) {
        try {
            Optional<Employee> optEmp = employeeRepository.findById(employeeId);
            return optEmp.orElse(null);
        } catch (Exception e) {
            logger.error("Error getting employee with ID " + employeeId, e);
            throw e;
        }
    }

    public void saveEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            logger.info("Employee saved with ID: " + employee.getId());
        } catch (Exception e) {
            logger.error("Error saving employee", e);
            throw e;
        }
    }

    public void deleteEmployee(Long employeeId) {
        try {
            employeeRepository.deleteById(employeeId);
            logger.info("Employee deleted with ID: " + employeeId);
        } catch (Exception e) {
            logger.error("Error deleting employee with ID " + employeeId, e);
            throw e;
        }
    }

    public void updateEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            logger.info("Employee updated with ID: " + employee.getId());
        } catch (Exception e) {
            logger.error("Error updating employee with ID " + employee.getId(), e);
            throw e;
        }
    }
}
