package com.example.demo.serviceImpl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.StatusHistory;
import com.example.demo.repository.StatusHistoryRepository;
import com.example.demo.service.StatusHistoryService;

@Service
public class StatusHistoryServiceImpl implements StatusHistoryService {
	
	@Autowired
    private StatusHistoryRepository statusHistoryRepository;
	
	
	
	@Override
	public void createInitialStatus(Employee employee) {
		// TODO Auto-generated method stub
		    
		    StatusHistory initialStatus = new StatusHistory();
		    initialStatus.setId(generateUniqueId());
	        initialStatus.setEmployee(employee);
	        initialStatus.setStatus("Active");
	        
	        initialStatus.setChangesDateTime(LocalDateTime.now());
	        statusHistoryRepository.save(initialStatus);
		
	}

	private Long generateUniqueId() {
		// TODO Auto-generated method stub
		   return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
	}

	@Override
	public void trackStatusChange(Employee employee) {
		// TODO Auto-generated method stub
		 StatusHistory latestStatusHistory = statusHistoryRepository.findTopByEmployeeOrderByChangesDateTimeDesc(employee);

	        if (latestStatusHistory != null && !latestStatusHistory.getStatus().equals(employee.getStatus())) {
	            StatusHistory statusHistory = new StatusHistory();
	            statusHistory.setEmployee(employee);
	            statusHistory.setStatus(employee.getStatus());
	            statusHistory.setChangesDateTime(LocalDateTime.now());
	            statusHistoryRepository.save(statusHistory);
	        }
		
	}

}
