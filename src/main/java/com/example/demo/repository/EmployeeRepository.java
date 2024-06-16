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
}
