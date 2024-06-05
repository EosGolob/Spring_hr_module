package com.example.demo.controller;

import com.example.demo.dto.InterviewsRequestDto;
import com.example.demo.service.InterviewProcessesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
public class InterviewProcessesController {

    @Autowired
    private InterviewProcessesService interviewProcessesService;

    @PostMapping
    public ResponseEntity<InterviewsRequestDto> addInterviewProcess(@RequestBody InterviewsRequestDto interviewProcessesDto) {
        InterviewsRequestDto createdInterviewProcess = interviewProcessesService.addInterviewProcess(interviewProcessesDto);
        return new ResponseEntity<>(createdInterviewProcess, HttpStatus.CREATED);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<InterviewsRequestDto>> getAllInterviewProcessesByEmployeeId(@PathVariable("employeeId") Long employeeId) {
        List<InterviewsRequestDto> interviewProcessesList = interviewProcessesService.getAllInterviewProcessesByEmployeeId(employeeId);
        return new ResponseEntity<>(interviewProcessesList, HttpStatus.OK);
    }
}
