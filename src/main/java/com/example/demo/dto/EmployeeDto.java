package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.InterviewProcesses;
import com.example.demo.entity.StatusHistory;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class EmployeeDto {
	
	private Long id;
	private String fullName;	
	private String email; 	
	private String jobProfile;	
	private String Qualification;	
	private Long mobileNo;	
	private String permanentAddress;	
	private String currentAddress;	
	private String gender;	
	private String previousOrganisation;	
    private Date  dob;	
    private String maritalStatus;	
    private String refferal;
    private String aadharFilename;
    private String status;
    private List<StatusHistory> statusHistories;
    private List<InterviewProcesses> interviewProcesses;
	private String aadhaarNumber;
	private String  languages;
	private int experience;
	private String source;
	private String subSource;

   
	public EmployeeDto(Long id, String fullName, String email, String jobProfile, String qualification, Long mobileNo,
			String permanentAddress, String currentAddress, String gender, String previousOrganisation, Date dob,
			String maritalStatus, String refferal, String aadharFilename, String status,
			List<StatusHistory> statusHistories, List<InterviewProcesses> interviewProcesses, String aadhaarNumber, String languages, int experience, String source,
			String subSource) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.jobProfile = jobProfile;
		Qualification = qualification;
		this.mobileNo = mobileNo;
		this.permanentAddress = permanentAddress;
		this.currentAddress = currentAddress;
		this.gender = gender;
		this.previousOrganisation = previousOrganisation;
		this.dob = dob;
		this.maritalStatus = maritalStatus;
		this.refferal = refferal;
		this.aadharFilename = aadharFilename;
		this.status = status;
		this.statusHistories = statusHistories;
		this.interviewProcesses=interviewProcesses;
		this.aadhaarNumber = aadhaarNumber;
		this.languages = languages;
		this.experience = experience;
		this.source = source;
		this.subSource = subSource;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobProfile() {
		return jobProfile;
	}
	public void setJobProfile(String jobProfile) {
		this.jobProfile = jobProfile;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPreviousOrganisation() {
		return previousOrganisation;
	}
	public void setPreviousOrganisation(String previousOrganisation) {
		this.previousOrganisation = previousOrganisation;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getRefferal() {
		return refferal;
	}
	public void setRefferal(String refferal) {
		this.refferal = refferal;
	}
	public String getAadharFilename() {
		return aadharFilename;
	}

	public void setAadharFilename(String aadharFilename) {
		this.aadharFilename = aadharFilename;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<StatusHistory> getStatusHistories() {
		return statusHistories;
	}


	public void setStatusHistories(List<StatusHistory> statusHistories) {
		this.statusHistories = statusHistories;
	}


	public String getAadhaarNumber() {
		return aadhaarNumber;
	}


	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}


	public String getLanguages() {
		return languages;
	}


	public void setLanguages(String languages) {
		this.languages = languages;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getSubSource() {
		return subSource;
	}


	public void setSubSource(String subSource) {
		this.subSource = subSource;
	}


	public List<InterviewProcesses> getInterviewProcesses() {
		return interviewProcesses;
	}


	public void setInterviewProcesses(List<InterviewProcesses> interviewProcesses) {
		this.interviewProcesses = interviewProcesses;
	}

  

    
}
