package com.mohmos.springboot.Backend.Service;

import com.mohmos.springboot.Backend.ExceptionHandling.ResourceNotFound;
import com.mohmos.springboot.Backend.Model.Employee;
import com.mohmos.springboot.Backend.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    /**
     * method for saving employee to database
     * @param employee Employee object
     * @return sql queries for saving data to the database
     */

    @Override
    public Employee save_Employee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * method for returning a list of employee
     * @return a list of employee object
     */

    @Override
    public List<Employee> getAll_Employee() {
        return employeeRepository.findAll();
    }

    /**
     * method to find å employee by id
     * @param id take the id from employee as a parameter
     * @return return an employee by id
     */

    @Override
    public Employee getEmployeeBiId(long id) {
        Optional<Employee> emp =  employeeRepository.findById(id);
        if(emp.isPresent()){
            return emp.get();
        }
        else{
            throw new ResourceNotFound("employee", "Id", id);
        }
    }

    /**
     * method for updating a employee object
     * @param employee take a employee object as ajson format
     * @param id take the id from the employee object
     * @return returs an update employee object
     */

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee checkEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Emplooye", "id", employee));
        checkEmployee.setFirstName(employee.getFirstName());
        checkEmployee.setLastName(employee.getLastName());
        checkEmployee.setEmail(employee.getEmail());
        employeeRepository.save(checkEmployee);

        return checkEmployee;
    }

    /**
     * method for deleting a employee
     * @param id take a employee object
     */

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFound("Employee", "id", id));
        employeeRepository.delete(employee);
    }


}
