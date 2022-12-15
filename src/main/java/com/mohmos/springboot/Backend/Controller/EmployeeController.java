package com.mohmos.springboot.Backend.Controller;

import com.mohmos.springboot.Backend.Model.Employee;
import com.mohmos.springboot.Backend.Repository.EmployeeRepository;
import com.mohmos.springboot.Backend.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController  {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Save employee data to database
     * @param employee Add a employee model from the modelclass
     * @return a http status if created
     */
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

        return new ResponseEntity<Employee>(employeeService.save_Employee(employee), HttpStatus.CREATED);
    }

    /**
     * endpoint for returning a list of employee to the request
     * @return return a status 200 OK
     */

    @GetMapping()
    public List<Employee> getAllEmploye(){
        return employeeService.getAll_Employee();
    }

    /**
     * method for mapping the endoint for a specific employee by id
     * @param id parameter id
     * @return status 200 ok
     */

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
        return new ResponseEntity<Employee>(employeeService.getEmployeeBiId(id), HttpStatus.OK);
    }

    /**
     * method fo updating employee endpoints
     * @param id take the id as a parameter
     * @param employee need the json representation of employee
     * @return status 200 ok
     */
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
                                                   @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);

    }

    /**
     * deleting the employee endpoints
     * @param id take the employee id as a parameter
     * @return return status 200 ok
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
    }
}
