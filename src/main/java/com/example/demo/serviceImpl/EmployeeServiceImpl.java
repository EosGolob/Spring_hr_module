package com.example.demo.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.entity.StatusHistory;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.StatusHistoryRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.FileService;
import com.example.demo.service.StatusHistoryService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private FileService fileService;

	@Autowired
	private StatusHistoryService statusHistoryService;
	
	@Autowired
	private StatusHistoryRepository statusHistoryRepository;

	@Value("${file.upload-dir}")
	private String path;

	private static final String UPLOAD_DIR = "./src/main/resources/static/img";

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.fileService = fileService;
		this.statusHistoryService = statusHistoryService;
	}

//	@Override
//	public EmployeeDto createEmployee(EmployeeDto employeeDto) {		
//		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
//		Employee savedEmployee = employeeRepository.save(employee);
//		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
//	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto, MultipartFile file, String path) throws IOException {
		// TODO Auto-generated method stub
		String fileName = fileService.uploadImage(path, file);

		// Set the filename in the employeeDto
		employeeDto.setAadharFilename(fileName);

		// Convert DTO to entity
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

		// Save the employee entity
		Employee savedEmployee = employeeRepository.save(employee);

		// Convert entity to DTO and return
		statusHistoryService.createInitialStatus(savedEmployee);
		
		updateEmployeeStatus(savedEmployee);
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not Exist with the given id" + employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));

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

//		 if (!file.isEmpty()) {
//	            String fileName = fileService.uploadImage(path, file);
//	            employee.setAadharFilename(fileName);
//	        }
//
//	        if (!employee.getStatus().equals(updatedEmployee.getStatus())) {
//	            statusHistoryService.trackStatusChange(employee);
//	        }

		Employee updatedEmployeeObj = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));

		employeeRepository.deleteById(employeeId);
	}

	@Override
	public EmployeeDto updateStatus(Long employeeId, String newStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Override public EmployeeDto updateStatus(Long employeeId, String newStatus)
	 *           { Employee employee =
	 *           employeeRepository.findById(employeeId).orElseThrow(()-> new
	 *           ResourceNotFoundException("Employee is not exists with given id :
	 *           "+ employeeId)); StatusHistory statusHistory = new StatusHistory();
	 *           statusHistory.setEmployee(employee);
	 *           statusHistory.setStatus(newStatus);
	 *           statusHistory.setChangesDateTime(LocalDateTime.now());
	 *           StatusHistory save = StatusHistoryRepository.save(statusHistory);
	 * 
	 *           Employee .setStatus(newStatus);
	 * 
	 *           return employeeRepository.save(emplo);
	 * 
	 *           }
	 */
	private void updateEmployeeStatus(Employee employee) {
	    StatusHistory latestStatus = statusHistoryRepository.findTopByEmployeeOrderByChangesDateTimeDesc(employee);
	    if (latestStatus != null) {
	        employee.setStatus(latestStatus.getStatus());
	        employeeRepository.save(employee);
	    }
}
	@Override
	public EmployeeDto updateEmployeeStatus(Long employeeId, String newStatus) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
		statusHistoryService.trackStatusChange(employee, newStatus);
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	
}
