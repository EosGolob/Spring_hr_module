package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.InterviewsRequestDto;
import com.example.demo.entity.Employee;
import com.example.demo.entity.InterviewProcesses;

public interface EmployeeService {

//	EmployeeDto createEmployee(EmployeeDto employeeDto);
		
	EmployeeDto getEmployeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();

//	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee, MultipartFile file) throws IOException;
	
	void deleteEmployee(Long employeeId);

	EmployeeDto createEmployee(EmployeeDto employeeDto, MultipartFile file, String path) throws IOException;
	
	void assignInterviewProcessAndUpdateStatus(Long employeeId, InterviewProcesses interviewProcesses, String newStatus);
	
    boolean checkDuplicateEmailAndAddharNo(String email ,String aadhaarNumber);

	List<EmployeeDto> getAllScheduleInterview();
	
	List<EmployeeDto> getAllHrResponseValue();
    
	List<EmployeeDto> getAllHdfcResponseValue();
	 
	List<EmployeeDto> getAllIciciResponseValue();
	
	List<EmployeeDto> getAllMisResponseValue();
	
	List<EmployeeDto> getAllResponseValueOnProcessType(String role);
	
	List<EmployeeDto> getEmployeeWithSelectedValuefiled();

	List<EmployeeDto> getEmpDetailsInfoById(Long employeeId);

	List<EmployeeDto> getAllRejectedEmp();

	List<EmployeeDto> getAllApprovedEmp();

	List<EmployeeDto> getHrRejectedEmp();

//	EmployeeDto updateEmployeeHrRejectedScreeningResponse(Long employeeId, String reSetHrField, String responseSubmitByName);
	
    EmployeeDto updateEmployeeHrResponseStatus(Long employeeId, String newStatus,String responseSubmitbyName);
	
	EmployeeDto updateEmployeeMrResponseStatus(Long employeeId, String newStatus,String responseSubmitbyName);
	
	EmployeeDto updateStatus(Long employeeId, String newStatus);
	
	EmployeeDto updateEmployeeStatus(Long employeeId, String newStatus);
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

	EmployeeDto updateEmployeeHrRejectedScreeningResponse(Long employeeId, String reSetHrField, String newStatus,
			String responseSubmitByName);

	void updateEmployeeRemarksHrAndManager(Long employeeId, String hrRemarks,String managerRemaks,String profileScreenRemark );


    
}
