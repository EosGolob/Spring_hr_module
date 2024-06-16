package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

public class EmployeeMapper {
//	@Autowired
//	private ModelMapper modelMapper;
	
	public static  EmployeeDto mapToEmployeeDto(Employee employee) {
//		EmployeeDto employees = this.modelMapper.map(employee,EmployeeDto.class);
		return new EmployeeDto(
				employee.getId(),
				employee.getFullName(),
				employee.getEmail(),
				employee.getJobProfile(),
				employee.getQualification(),
				employee.getMobileNo(),
				employee.getPermanentAddress(),
				employee.getCurrentAddress(),
				employee.getGender(),
				employee.getPreviousOrganisation(),
				employee.getDob(),
				employee.getMaritalStatus(),
				employee.getRefferal(),
				employee.getAadharFilename(),
				employee.getInitialStatus(),
				employee.getProcessesStatus(),
				employee.getHrStatus(),
				employee.getManagerStatus(),
				employee.getStatusHistories(),
				employee.getInterviewProcesses(),
				employee.getAadhaarNumber(),
				employee.getLanguages(),
				employee.getExperience(),
				employee.getSource(),
				employee.getSubSource()
				
				);
//		return employees;
	}

	
  public static Employee mapToEmployee(EmployeeDto employeeDto) {
//	  Employee emp = this.modelMapper.map(employeeDto, Employee.class);
	  return new Employee(
			  employeeDto.getId(),
			  employeeDto.getFullName(),
			  employeeDto.getEmail(),
			  employeeDto.getJobProfile(),
			  employeeDto.getQualification(),
			  employeeDto.getMobileNo(),
			  employeeDto.getPermanentAddress(),
			  employeeDto.getCurrentAddress(),
			  employeeDto.getGender(),
			  employeeDto.getPreviousOrganisation(),
			  employeeDto.getDob(),
			  employeeDto.getMaritalStatus(),
			  employeeDto.getRefferal(),  		 
			  employeeDto.getAadhaarNumber(),
			  employeeDto.getLanguages(),
			  employeeDto.getExperience(),
			  employeeDto.getSource(),
			  employeeDto.getSubSource(),
			  employeeDto.getInitialStatus(),
			  employeeDto.getProcessesStatus(),
			  employeeDto.getHrStatus(),
			  employeeDto.getManagerStatus(),
			  employeeDto.getStatusHistories(),
			  employeeDto.getInterviewProcesses(),
			  employeeDto.getAadharFilename()
				
			  );
//	return emp;
  }
}
