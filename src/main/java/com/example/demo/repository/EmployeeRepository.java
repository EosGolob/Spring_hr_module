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

	@Query("SELECT e.id, e.fullName, e.email, e.jobProfile, e.mobileNo, e.permanentAddress, e.gender, e.creationDate "
			+ "FROM Employee e WHERE e.initialStatus = 'Active' AND e.hrStatus IS NULL")
	List<Object[]> findEmployeesWithScheduledInterviews();

	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender "
			+ "FROM Employee e  WHERE e.hrStatus = 'Select' or e.hrStatus = 'Reject'")
	List<Object[]> findEmployeeWithHrResponseStatus();

	@Query("SELECT e.id, e.fullName, e.email, e.jobProfile, e.mobileNo, e.permanentAddress, e.currentAddress, e.gender,e.creationDate "
			+ "FROM Employee e " + "WHERE e.hrStatus = 'Select' AND e.processesStatus Is NUll")
	List<Object[]> getEmployeeWithSelectedValue();

	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender, e.previousOrganisation, e.processesStatus ,e.creationDate "
			+ "FROM Employee e WHERE e.processesStatus = 'HDFC' ")
	List<Object[]> findEmployeeOnHdfcProcesses();

	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender,e.previousOrganisation,e.processesStatus, e.creationDate "
			+ "FROM Employee e WHERE e.processesStatus = 'MIS' ")
	List<Object[]> findEmployeeOnMisProcesses();

	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender ,e.previousOrganisation,e.processesStatus , e.creationDate   "
			+ "FROM Employee e WHERE e.processesStatus = 'ICICI' ")
	List<Object[]> findEmployeeOnIciciProcesses();

	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender ,e.previousOrganisation,e.processesStatus , e.creationDate   "
			+ "FROM Employee e WHERE e.processesStatus = :role")
	List<Object[]> findEmployeesByRoleType(String role);

	@Query("SELECT e.id, e.fullName, e.aadhaarNumber, e.email, e.creationDate,sh.status, sh.changesDateTime ,sh.hrName "
			+ "FROM Employee e " + "JOIN StatusHistory sh ON e.id = sh.employee.id " + "WHERE e.id = :id")
	List<Object[]> getEmpDetailsInfoById(@Param("id") Long employeeId);

	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender, e.creationDate ,e.profileScreenRemarks  "
			+ "FROM Employee e  WHERE e.hrStatus = 'Reject'")
	List<Object[]> getHrRejectedEmployeeInfo();

	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender , e.previousOrganisation,e.processesStatus,e.creationDate,e.reMarksByHr,e.reMarksByManager,e.profileScreenRemarks "
			+ "FROM Employee e WHERE e.processesStatus = 'Reject' ")
	List<Object[]> getRejectedEmployeeInfo();

	@Query("SELECT e.id,e.fullName,e.email, e.jobProfile, e.mobileNo, e.permanentAddress ,e.gender , e.creationDate,e.reMarksByHr,e.reMarksByManager,e.profileScreenRemarks "
			+ "FROM Employee e WHERE e.managerStatus = 'Select' ")
	List<Object[]> getApprovedEmployeeInfo();

}
