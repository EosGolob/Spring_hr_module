package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StatusHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "employee_id" , nullable = false)
	private Employee employee; 
	
	//new field 
	@ManyToOne
	@JoinColumn(name = "interview_process_id")
	private InterviewProcesses interviewProcess;
	
	
	@Column(nullable = false)
	private String status;
	
	@Column(name = "hr_name")
	private String hrName;
	
	@Column(nullable = false)
	private Date changesDateTime;
//	private LocalDateTime changesDateTime;
		
}
