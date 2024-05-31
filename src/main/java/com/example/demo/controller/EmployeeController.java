package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.repository.StatusHistoryRepository;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private StatusHistoryRepository statusHistoryRepository;

////	@Value("${project.image}")
	@Value("${file.upload-dir}")
	private String path;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// Build add Employee REST API
//	@PostMapping
//	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
//		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
//		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
//		
//	}

	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestPart("employee") EmployeeDto employeeDto,
			@RequestParam("image") MultipartFile image) {
		try {
			EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto, image, path);
			return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
		} catch (IOException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// Build get Employee REST API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);

	}

	// Build get allEmployee Rest API
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);

	}

	// Build update Employee REST API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee( @PathVariable("id") Long employeeId , @RequestBody EmployeeDto updatedEmployee){
	EmployeeDto employeeDto =	employeeService.updateEmployee(employeeId, updatedEmployee);
	return ResponseEntity.ok(employeeDto);
	}
//	@PutMapping("{id}")
//	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @ModelAttribute EmployeeDto updatedEmployee,  @RequestParam MultipartFile file) throws IOException {
//		EmployeeDto updatedEmployeeDto = employeeService.updateEmployee(employeeId, updatedEmployee, file);
//		return ResponseEntity.ok(updatedEmployeeDto);
//	}

	// Build Delete EmployeeREST APi
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted successfully");
	}

//	@PutMapping("/{id/status}")
//	public Emplo

}
