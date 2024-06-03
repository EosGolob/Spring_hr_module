package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.EmployeeDto;

public interface EmployeeService {

//	EmployeeDto createEmployee(EmployeeDto employeeDto);
		
	EmployeeDto getEmployeeById(Long employeeId);

	List<EmployeeDto> getAllEmployees();

	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

//	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee, MultipartFile file) throws IOException;
	
	void deleteEmployee(Long employeeId);

	EmployeeDto updateStatus(Long employeeId, String newStatus);

	EmployeeDto createEmployee(EmployeeDto employeeDto, MultipartFile file, String path) throws IOException;

	

}