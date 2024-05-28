package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "email", nullable = false , unique = true)
	private String email; 
	
	@Column(name = "job_profile")
	private String jobProfile;
	
	@Column(name = "Qualification")
	private String Qualification;
	
	@Column(name = "mobile_no")
	private Long mobileNo;
	
	@Column(name = "permanent_address")
	private String permanentAddress;
	
	@Column(name = "current_address")
	private String currentAddress;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "previous_Organisation")
	private String previousOrganisation;
	
	@Column(name = "dob")
    private Date  dob;
	
	@Column(name = "marital_status")
    private String maritalStatus;
	
	@Column(name = "refferal")
    private String refferal;

	@Column(name = "status")
	private String status;
	
	
	@Column(name = "aadhar_filename")
	private String aadharFilename;
	
	public Employee() {
		super();
	}

	
	
	public Employee(Long id, String fullName, String email, String jobProfile, String qualification, Long mobileNo,
			String permanentAddress, String currentAddress, String gender, String previousOrganisation, Date dob,
			String maritalStatus, String refferal, String aadharFilename) {
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
