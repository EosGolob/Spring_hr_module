package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.InterviewsRequestDto;
import com.example.demo.entity.InterviewProcesses;

public interface InterviewProcessesService {
	InterviewsRequestDto addInterviewProcess(InterviewsRequestDto interviewProcessesDto);

	List<InterviewsRequestDto> getAllInterviewProcessesByEmployeeId(Long employeeId);
	
	
	

//	 public List<InterviewProcesses> getInterviewProcessesByStatus(String status);
//	  
	    
	


}
