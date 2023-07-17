package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;
    public Employee getEmployeeById(int id) {
        Optional<Employee> empl = repository.findById(id);
        if (empl.isPresent()) {
            return empl.get();
        }
        return null;
    }
    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<Employee>();
        repository.findAll().forEach(employee -> employees.add(employee));
        return employees;
    }
    public void saveOrUpdate(Employee employee) {
        repository.save(employee);
    }
    public void deleteEmployeeById(int id) {
        repository.deleteById(id);
    }
}