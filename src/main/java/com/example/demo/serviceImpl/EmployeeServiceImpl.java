package com.example.demo.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.example.demo.dto.InterviewsRequestDto;
import com.example.demo.dto.StatusHistoryDto;
import com.example.demo.entity.Employee;
import com.example.demo.entity.InterviewProcesses;
import com.example.demo.entity.ManagerDetails;
import com.example.demo.entity.StatusHistory;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.InterviewProcessesRepository;
import com.example.demo.repository.ManagerDetailsRepository;
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

	@Autowired
	private InterviewProcessesRepository interviewProcessesRepository;
	
    @Autowired
	private ManagerDetailsRepository managerDetailsRepository;
	
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
		 if (checkDuplicateEmailAndAddharNo(employeeDto.getEmail(), employeeDto.getAadhaarNumber())) {
		        throw new RuntimeException("Email or Aadhaar number already exists");
		    }
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
	public List<EmployeeDto> getEmployeeWithSelectedValuefiled() {

		List<Object[]> results = employeeRepository.getEmployeeWithSelectedValue();
		List<EmployeeDto> employees = new ArrayList<>();
		
		for (Object[] result : results) {
            EmployeeDto employee = new EmployeeDto();
            employee.setId((Long) result[0]);
            employee.setFullName((String) result[1]);
            employee.setEmail((String) result[2]);
            employee.setJobProfile((String) result[3]);
            employee.setMobileNo((Long) result[4]);
            employee.setPermanentAddress((String) result[5]);
            employee.setCurrentAddress((String) result[6]);
            employee.setGender((String) result[7]);
            employee.setCreationDate((Date) result[8]);
        

            employees.add(employee);
        }
		  return employees;
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
//	        employee.setStatus(latestStatus.getStatus());
	    	employee.setInitialStatus(latestStatus.getStatus());
	        employeeRepository.save(employee);
	    }
}
	@Override
	public EmployeeDto updateEmployeeStatus(Long employeeId, String newStatus) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
		statusHistoryService.trackStatusChange(employee, newStatus ,null);
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public void assignInterviewProcessAndUpdateStatus(Long employeeId, InterviewProcesses interviewProcesses,
			String newStatus) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(()->  new RuntimeException("Employee not found"));
		interviewProcesses.setEmployee(employee);
		
		assignManagerForInterview(interviewProcesses);
		String processNameUpdateInEmp =interviewProcesses.getProcessName();
		employee.setProcessesStatus(processNameUpdateInEmp);
		employee.setLastInterviewAssin(processNameUpdateInEmp);
		InterviewProcesses savedInterviewProcess = interviewProcessesRepository.save(interviewProcesses);
//		interviewProcesses.setManagerDetails(managerId);
		setStatusHistoryRecored(employeeId,savedInterviewProcess, newStatus,employee)  ; 
		
//		employee.setProcessesStatus(newStatus);
		    
		   
	}

	@Override
	public boolean checkDuplicateEmailAndAddharNo(String email, String aadhaarNumber) {
		// TODO Auto-generated method stub
		boolean emailExists = employeeRepository.existsByEmail(email);
		boolean addharnoExists = employeeRepository.existsByAadhaarNumber(aadhaarNumber);
		return emailExists || addharnoExists;
	}

//	@Override
//	public List<EmployeeDto> getAllScheduleInterview() {
//		List<Employee> employees = employeeRepository.findEmployeesWithScheduledInterviews();
//		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
//				.collect(Collectors.toList());
//	}
//	@Override
//	public List<EmployeeDto> getEmployeesByInterviewProcessStatus(String status) {
//		List<EmployeeDto> employees = employeeRepository.findByInterviewProcessStatus(status);
//		return employees.stream()
//				.map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
//				.collect(Collectors.toList());
//	}

	@Override
	public EmployeeDto updateEmployeeHrResponseStatus(Long employeeId, String newStatus , String responseSubmitbyName) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
		employee.setHrStatus(newStatus);
		statusHistoryService.trackStatusChange(employee, newStatus,responseSubmitbyName);
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	
	@Override
	public EmployeeDto updateEmployeeMrResponseStatus(Long employeeId, String newStatus , String responseSubmitbyname) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
		employee.setManagerStatus(newStatus);
		employee.setProcessesStatus(newStatus);
		statusHistoryService.trackStatusChange(employee, newStatus ,responseSubmitbyname);
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	
	@Override
	public List<EmployeeDto> getAllScheduleInterview() {
		 List<Object[]> employeeObjects = employeeRepository.findEmployeesWithScheduledInterviews();
		 List<EmployeeDto> employees = new ArrayList<>();

			for (Object[] result : employeeObjects) {
	            EmployeeDto employee = new EmployeeDto();
	            employee.setId((Long) result[0]);
	            employee.setFullName((String) result[1]);
	            employee.setEmail((String) result[2]);
	            employee.setJobProfile((String) result[3]);
	            employee.setMobileNo((Long) result[4]);
	            employee.setPermanentAddress((String) result[5]);
	            employee.setGender((String) result[6]);
                employee.setCreationDate((Date) result[7]);
	            employees.add(employee);
	        }
			  return employees;
	}

	@Override
	public List<EmployeeDto> getAllHrResponseValue() {
		// TODO Auto-generated method stub
//		List<Employee> employees = employeeRepository.findEmployeeWithHrResponseStatus();
//		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
//				.collect(Collectors.toList());
		 List<Object[]> employeeObjects = employeeRepository.findEmployeeWithHrResponseStatus();
		 List<EmployeeDto> employees = new ArrayList<>();

			for (Object[] result : employeeObjects) {
	            EmployeeDto employee = new EmployeeDto();
	            employee.setId((Long) result[0]);
	            employee.setFullName((String) result[1]);
	            employee.setEmail((String) result[2]);
	            employee.setJobProfile((String) result[3]);
	            employee.setMobileNo((Long) result[4]);
	            employee.setPermanentAddress((String) result[5]);
	            employee.setGender((String) result[6]);

	            employees.add(employee);
	        }
			  return employees;
	}
	
	@Override
	public List<EmployeeDto> getAllHdfcResponseValue() {
		
		 List<Object[]> employeeObjects = employeeRepository.findEmployeeOnHdfcProcesses();
		 List<EmployeeDto> employees = new ArrayList<>();
			for (Object[] result : employeeObjects) {
	            EmployeeDto employee = new EmployeeDto();
	            employee.setId((Long) result[0]);
	            employee.setFullName((String) result[1]);
	            employee.setEmail((String) result[2]);
	            employee.setJobProfile((String) result[3]);
	            employee.setMobileNo((Long) result[4]);
	            employee.setPermanentAddress((String) result[5]);
	            employee.setGender((String) result[6]);
	            employee.setPreviousOrganisation((String) result[7]);
	            employee.setProcessesStatus((String) result[8]);
	            employee.setCreationDate((Date) result[9]);

	            employees.add(employee);
	        }
			  return employees;
	}
	

	@Override
	public List<EmployeeDto> getAllIciciResponseValue() {
		 List<Object[]> employeeObjects = employeeRepository.findEmployeeOnIciciProcesses();
		 List<EmployeeDto> employees = new ArrayList<>();
			for (Object[] result : employeeObjects) {
	            EmployeeDto employee = new EmployeeDto();
	            employee.setId((Long) result[0]);
	            employee.setFullName((String) result[1]);
	            employee.setEmail((String) result[2]);
	            employee.setJobProfile((String) result[3]);
	            employee.setMobileNo((Long) result[4]);
	            employee.setPermanentAddress((String) result[5]);
	            employee.setGender((String) result[6]);
	            employee.setPreviousOrganisation((String) result[7]);
	            employee.setProcessesStatus((String) result[8]);
	            employee.setCreationDate((Date) result[9]);

	            employees.add(employee);
	        }
			  return employees;
	}



	@Override
	public List<EmployeeDto> getAllMisResponseValue() {
		 List<Object[]> employeeObjects = employeeRepository.findEmployeeOnMisProcesses();
		 List<EmployeeDto> employees = new ArrayList<>();
			for (Object[] result : employeeObjects) {
				 EmployeeDto employee = new EmployeeDto();
		            employee.setId((Long) result[0]);
		            employee.setFullName((String) result[1]);
		            employee.setEmail((String) result[2]);
		            employee.setJobProfile((String) result[3]);
		            employee.setMobileNo((Long) result[4]);
		            employee.setPermanentAddress((String) result[5]);
		            employee.setGender((String) result[6]);
		            employee.setPreviousOrganisation((String) result[7]);
		            employee.setProcessesStatus((String) result[8]);
		            employee.setCreationDate((Date) result[9]);
	            employees.add(employee);
	        }
			  return employees;
	}
	
	
	@Override
	public List<EmployeeDto> getAllRejectedEmp() {
		 List<Object[]> employeeObjects = employeeRepository.getRejectedEmployeeInfo();
		 List<EmployeeDto> employees = new ArrayList<>();
			for (Object[] result : employeeObjects) {
	            EmployeeDto employee = new EmployeeDto();
	            employee.setId((Long) result[0]);
	            employee.setFullName((String) result[1]);
	            employee.setEmail((String) result[2]);
	            employee.setJobProfile((String) result[3]);
	            employee.setMobileNo((Long) result[4]);
	            employee.setPermanentAddress((String) result[5]);
	            employee.setGender((String) result[6]);
	            employee.setPreviousOrganisation((String) result[7]);
	            employee.setProcessesStatus((String) result[8]);
	            employee.setCreationDate((Date) result[9]);

	            employees.add(employee);
	        }
			  return employees;
	}
	@Override
	public List<EmployeeDto> getAllApprovedEmp() {
		 List<Object[]> employeeObjects = employeeRepository.getApprovedEmployeeInfo();
		 List<EmployeeDto> employees = new ArrayList<>();
			for (Object[] result : employeeObjects) {
	            EmployeeDto employee = new EmployeeDto();
	            employee.setId((Long) result[0]);
	            employee.setFullName((String) result[1]);
	            employee.setEmail((String) result[2]);
	            employee.setJobProfile((String) result[3]);
	            employee.setMobileNo((Long) result[4]);
	            employee.setPermanentAddress((String) result[5]);
	            employee.setGender((String) result[6]);
	            employee.setCreationDate((Date) result[7]);

	            employees.add(employee);
	        }
			  return employees;
	}


	@Override
	public List<EmployeeDto> getEmpDetailsInfoById(Long employeeId) {
		// TODO Auto-generated method stub
		List <Object[]> empObj = employeeRepository.getEmpDetailsInfoById(employeeId);
//		 List<EmployeeDto> employees = new ArrayList<>();
//		 for (Object[] result : empObj) {
//	            EmployeeDto employee = new EmployeeDto();
//	            employee.setId((Long) result[0]);
//	            employee.setFullName((String) result[1]);
//	            employee.setAadhaarNumber((String) result[2]);
//	            employee.setEmail((String) result[3]);
//	            // Assuming creationDate is of type java.util.Date or java.sql.Timestamp
//	            employee.setCreationDate((Date) result[4]);
//	            employee.setStatus((String) result[5]);
//	            // Assuming changesDateTime is of type java.util.Date or java.sql.Timestamp
//	            employee.setChangesDateTime((Date) result[6]);
//
//	            employees.add(employee);
//	        }
//
//	        return employees;
		 Map<Long, EmployeeDto> employeeMap = new HashMap<>();

	        for (Object[] result : empObj) {
	            Long id = (Long) result[0];
	            String fullName = (String) result[1];
	            String aadhaarNumber = (String) result[2];
	            String email = (String) result[3];
	            // Assuming creationDate is of type java.util.Date or java.sql.Timestamp
	            Date creationDate = (Date) result[4];
	            String status = (String) result[5];
	            // Assuming changesDateTime is of type java.util.Date or java.sql.Timestamp
	            Date changesDateTime = (Date) result[6];
                String hrName = (String) result[7];
	            if (!employeeMap.containsKey(id)) {
	                EmployeeDto employeeDetailsDto = new EmployeeDto();
	                employeeDetailsDto.setId(id);
	                employeeDetailsDto.setFullName(fullName);
	                employeeDetailsDto.setAadhaarNumber(aadhaarNumber);
	                employeeDetailsDto.setEmail(email);
	                employeeDetailsDto.setCreationDate(creationDate);
	                
	                List<StatusHistory> statusHistoryList = new ArrayList<>();
	                employeeDetailsDto.setStatusHistories(statusHistoryList);
	                employeeMap.put(id, employeeDetailsDto);
	            }

	            StatusHistory statusHistory = new StatusHistory();
	            statusHistory.setStatus(status);
	            statusHistory.setChangesDateTime(changesDateTime);
	            statusHistory.setHrName(hrName);
	            employeeMap.get(id).getStatusHistories().add(statusHistory);
	        }

	        return new ArrayList<>(employeeMap.values());
	    }
	  	
	
	private void assignManagerForInterview(InterviewProcesses interviewProcesses) {
		 Long managerId = null;
         String processType = interviewProcesses.getProcessName();
         if(processType != null) {
         	switch (processType) {
				case "HDFC": {
					managerId = 1L;
					break;
				}
				case "ICICI": {
					managerId = 2L;
					break;
				}
				case "MIS": {
					managerId = 3L;
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + processType);
				}
         }
         
         if (managerId != null) {
           ManagerDetails ma = managerDetailsRepository.findById(managerId) 
           		.orElseThrow(() -> new RuntimeException("Manager details not found for id: "));;
            interviewProcesses.setManagerDetails(ma);
         }
	}
	
	private void setStatusHistoryRecored(Long employeeId , InterviewProcesses savedInterviewProcess ,String newStatus ,Employee employee ) {
		 StatusHistory statusHistory = new StatusHistory();
	        statusHistory.setEmployee(employee);
	        statusHistory.setInterviewProcess(savedInterviewProcess);
	        statusHistory.setStatus(newStatus);
	        statusHistory.setHrName(savedInterviewProcess.getScheduledBy());
	        LocalDateTime currentDateTime = LocalDateTime.now();
	        Date currentDate = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
	        statusHistory.setChangesDateTime(currentDate);     
//         interviewProcessesRepository.save(savedInterviewProcess);

	        statusHistoryRepository.save(statusHistory);
	}







	






	





	







	
}
