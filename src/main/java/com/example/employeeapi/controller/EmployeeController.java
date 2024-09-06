package com.example.employeeapi.controller;

import com.example.employeeapi.model.Employee;
import com.example.employeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

   

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

	/*
	 * @PutMapping("/{id}") public ResponseEntity<Employee>
	 * updateEmployee(@PathVariable Long id, @RequestBody Employee employee) { if
	 * (!employeeRepository.existsById(id)) { return
	 * ResponseEntity.notFound().build(); } employee.setId(id); Employee
	 * updatedEmployee = employeeRepository.save(employee); return
	 * ResponseEntity.ok(updatedEmployee); }
	 * 
	 */
    @DeleteMapping("/{id}") 
    public ResponseEntity<Void>deleteEmployee(@PathVariable Long id) { 
    	if(!employeeRepository.existsById(id)) { 
    		return ResponseEntity.notFound().build(); 
    		} 
    	employeeRepository.deleteById(id);
	 return ResponseEntity.noContent().build(); 
	 }
}
