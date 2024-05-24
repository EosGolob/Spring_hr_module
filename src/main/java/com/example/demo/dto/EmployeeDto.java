package com.example.demo.dto;

import java.util.Date;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
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

	public EmployeeDto(Long id, String fullName, String email, String jobProfile, String qualification, Long mobileNo,
			String permanentAddress, String currentAddress, String gender, String previousOrganisation, Date dob,
			String maritalStatus, String refferal) {
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
    
    
    
}
