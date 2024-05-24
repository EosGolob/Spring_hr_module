package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeRepository employeeRepository;
	
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}



	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee =  employeeRepository.findById(employeeId)
		.orElseThrow(() -> 
		new ResourceNotFoundException("Employee is not Exist with the given id" + employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}



	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}



	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee =  employeeRepository.findById(employeeId).orElseThrow(()-> 
		new ResourceNotFoundException("Employee is not exists with given id : "+ employeeId));
		
	    employee.setFullName(updatedEmployee.getFullName());
	    employee.setEmail(updatedEmployee.getEmail());
	    employee.setJobProfile(updatedEmployee.getJobProfile());
	    employee.setQualification(updatedEmployee.getQualification());
	    employee.setMobileNo(updatedEmployee.getMobileNo());
	    employee.setPermanentAddress(updatedEmployee.getPermanentAddress());
	    employee.setCurrentAddress(updatedEmployee.getCurrentAddress());
	    employee.setGender(updatedEmployee.getGender());
	    employee.setPreviousOrganisation(updatedEmployee.getPreviousOrganisation());
	    employee.setDob(updatedEmployee.getDob());
	    employee.setMaritalStatus(updatedEmployee.getMaritalStatus());
	    employee.setRefferal(updatedEmployee.getRefferal());
	    
	    Employee updatedEmployeeObj  = employeeRepository.save(employee);
	    
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}



	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee =  employeeRepository.findById(employeeId).orElseThrow(()-> 
		new ResourceNotFoundException("Employee is not exists with given id : "+ employeeId));
		
		employeeRepository.deleteById(employeeId);		
	}

}
