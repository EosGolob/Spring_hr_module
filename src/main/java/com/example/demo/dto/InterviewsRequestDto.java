package com.example.demo.dto;

import java.util.Date;

public class InterviewsRequestDto {
	private Long id;
	private Long employeeId;
	private String processName;
	private Date interviewDate;
	private String interviewTime;
	private String status;
	
	
	public InterviewsRequestDto(Long id, Long employeeId, String processName, Date interviewData, String interviewTime,
			String status) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.processName = processName;
		this.interviewDate = interviewDate;
		this.interviewTime = interviewTime;
		this.status = status;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	
	
	
	

}
