package com.mohmos.springboot.Backend.Service;

import com.mohmos.springboot.Backend.Model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee save_Employee(Employee employee);
    List<Employee> getAll_Employee();
    Employee getEmployeeBiId(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(Long id);




}
