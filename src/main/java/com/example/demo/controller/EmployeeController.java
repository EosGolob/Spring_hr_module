package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
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
import com.example.demo.dto.InterviewsRequestDto;
import com.example.demo.entity.Employee;
import com.example.demo.entity.InterviewProcesses;
import com.example.demo.repository.StatusHistoryRepository;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

//	@Autowired
	private EmployeeService employeeService;
	
	

//	@Autowired
//	private StatusHistoryRepository statusHistoryRepository;

	@Value("${file.upload-dir}")
	private String path;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
    
	
//	
//	public EmployeeController(StatusHistoryRepository statusHistoryRepository) {
//		this.statusHistoryRepository = statusHistoryRepository;
//	}



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
			if (employeeDto == null || image == null || image.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

			// Debugging statements
			System.out.println("EmployeeDto: " + employeeDto);
			System.out.println("Image Original Filename: " + image.getOriginalFilename());

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
	
	@GetMapping("/getAllEmp")
	public ResponseEntity<List<EmployeeDto>> getAllEmp(){
		List<EmployeeDto> employees = employeeService.getEmployeeWithSelectedValuefiled();
		return ResponseEntity.ok(employees);	
		
	}

	// Build update Employee REST API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDto updatedEmployee) {
		EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
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

	@PatchMapping("/{id}/status")
	public ResponseEntity<EmployeeDto> updateEmployeeStatus(@PathVariable("id") Long employeeId,
			@RequestParam String newStatus) {
		EmployeeDto updatedEmployee = employeeService.updateEmployeeStatus(employeeId, newStatus);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	@PostMapping("/{employeeId}/interview-process")
	public ResponseEntity<Void> assignInterviewProcess(@PathVariable Long employeeId,
			@RequestBody InterviewProcesses interviewProcesses) {
		String newStatus = interviewProcesses.getStatus();
		employeeService.assignInterviewProcessAndUpdateStatus(employeeId, interviewProcesses, newStatus);
		return ResponseEntity.ok().build();
	}

//	 @GetMapping("/employeesProcessesInterview")
//	    public ResponseEntity<List<EmployeeDto>> getEmployeesByInterviewProcessStatus(@RequestParam String status) {
//		 List<EmployeeDto> employees = employeeService.getEmployeesByInterviewProcessStatus(status);
//			return ResponseEntity.ok(employees);
//	    }

	@GetMapping("/employees-schedule-interview")
	public ResponseEntity<List<EmployeeDto>> employeeScheduleInterview() {
		List<EmployeeDto> employees = employeeService.getAllScheduleInterview();
		return ResponseEntity.ok(employees);
	}

	@PutMapping("/{id}/hrResponse")
	public ResponseEntity<EmployeeDto> updateEmployeehrRespone(@PathVariable("id") Long employeeId,
			@RequestBody Map<String, String> requestBody) {
		String newStatus = requestBody.get("newStatus");
		EmployeeDto updatedEmployee = employeeService.updateEmployeeHrResponseStatus(employeeId, newStatus);
		System.out.println("new Status value" + newStatus);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	@GetMapping("/managerResponeField")
	public ResponseEntity<List<EmployeeDto>> managerResponseField() {
		List<EmployeeDto> employees = employeeService.getAllHrResponseValue();
		return ResponseEntity.ok(employees);
	}
	
	@PutMapping("/{id}/mRResponse")
	public ResponseEntity<EmployeeDto> updateEmployeeMrRespone(@PathVariable("id") Long employeeId,
			@RequestBody Map<String, String> requestBody) {
		String newStatus = requestBody.get("newStatus");
		EmployeeDto updatedEmployee = employeeService.updateEmployeeMrResponseStatus(employeeId, newStatus);
		System.out.println("new Status value" + newStatus);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

}
