package com.example.demo.service;

import com.example.demo.entity.Employee;

public interface StatusHistoryService {
	  public void createInitialStatus(Employee employee);
	  public void trackStatusChange(Employee employee, String newStatus );
}
