package com.example.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class InterviewProcesses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false )
	@JoinColumn(name = "employee_id" , nullable = false)
	@JsonIgnore
	private Employee employee;
	
	@Column(name = "process_name")
	private String processName;
	
	@Column(name = "interview_date")
	private Date interviewDate;
	
	@Column(name = "interview_time")
	private String interviewTime;
	
	@Column(name = "status")
	private String status;
	
	public InterviewProcesses() {
	super();
}


public InterviewProcesses(Long id, Employee employee, String processName, Date interviewDate, String interviewTime,
		String status) {
	super();
	this.id = id;
	this.employee = employee;
	this.processName = processName;
	this.interviewDate = interviewDate;
	this.interviewTime = interviewTime;
	this.status = status;
}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public String getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(String interviewTime) {
		this.interviewTime = interviewTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	
	
	
	
}
