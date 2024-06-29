package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	boolean existsByEmail(String email);

	boolean existsByAadhaarNumber(String aadhaarNumber);

//	@Query("SELECT e FROM Employee e JOIN InterviewProcess ip ON e.id = ip.employee.id WHERE ip.status = :status")
//    List<EmployeeDto> findByInterviewProcessStatus(@Param("status") String status);
	
//	@Query("SELECT e FROM Employee e JOIN e.interviewProcesses ip WHERE ip.status = 'Scheduled'")
//	 @Query(value = "SELECT e.* FROM employees e JOIN interview_processes ip ON e.id = ip.employee_id WHERE ip.status = 'Scheduled'", nativeQuery = true)
//	 @Query("SELECT e, ip.processName FROM Employee e JOIN e.interviewProcesses ip WHERE ip.status = 'Scheduled'")
	@Query("SELECT e FROM Employee e WHERE e.processesStatus = 'scheduled'")
    List<Employee> findEmployeesWithScheduledInterviews();
	
//	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender"+ " FROM Employee e "+" WHERE e.hrStatus = 'Approved' or e.hrStatus = 'Rejected'"+"ORDER BY e.creationDate ASC")
	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender FROM Employee e  WHERE e.hrStatus = 'Approved' or e.hrStatus = 'Rejected'")
	List<Object[]> findEmployeeWithHrResponseStatus();
	
	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender From Employee e where e.initialStatus = 'Active'")
	List<Object[]> getEmployeeWithSelectedValue();
	
//	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender " +
//	           "FROM Employee e " +
//	           "JOIN e.interviewProcesses ip " +
//	           "WHERE ip.processName = 'HDFC'")
	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender " +
	           "FROM Employee e WHERE e.processesStatus = 'HDFC' ")
	List<Object[]> findEmployeeOnHdfcProcesses();

	
//	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender " +
//	           "FROM Employee e " +
//	           "JOIN e.interviewProcesses ip " +
//	           "WHERE ip.processName = 'MIS'")
	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender " +
	           "FROM Employee e WHERE e.processesStatus = 'MIS' ")
	List<Object[]> findEmployeeOnMisProcesses();
    
//	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender " +
//	           "FROM Employee e " +
//	           "JOIN e.interviewProcesses ip " +
//	           "WHERE ip.processName = 'ICICI'")
	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender " +
	           "FROM Employee e WHERE e.processesStatus = 'ICICI' ")
	List<Object[]> findEmployeeOnIciciProcesses();
    
	 @Query("SELECT e.id, e.fullName, e.aadhaarNumber, e.email, e.creationDate, sh.status, sh.changesDateTime " +
	           "FROM Employee e " +
	           "JOIN StatusHistory sh ON e.id = sh.employee.id " +
	           "WHERE e.id = :id")
	List<Object[]> getEmpDetailsInfoById(@Param("id") Long employeeId);

	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender " +
	           "FROM Employee e WHERE e.managerStatus = 'Rejected' ")
	List<Object[]> getRejectedEmployeeInfo();
	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender " +
	           "FROM Employee e WHERE e.managerStatus = 'Approved' ")
	List<Object[]> getApprovedEmployeeInfo();
	
	
}
