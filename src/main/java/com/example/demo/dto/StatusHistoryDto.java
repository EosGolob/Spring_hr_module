package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.example.demo.entity.Employee;
import com.example.demo.entity.InterviewProcesses;

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
public class StatusHistoryDto {
    private Long id;
    private String status;
//    private LocalDateTime changesDateTime;
    private Date changesDateTime;
    
    private InterviewProcesses interviewProcesses;
    private Employee employee;
}
