import React, { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

const PersonalDetailsComponent = ({
  formData,
  errors,
  handleYearChange,
  renderYearOptions,
  handleDateChange,
  handleChange,
}) => {
  return (
    <div className="container">
      <br></br>
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          <div className="card-body">
            <h2>PERSIONAL DETAILS</h2>
            <form>
              <div className="form-group">
                <label className="form-label">Full Name</label>
                <input
                  type="text"
                  placeholder="Enter Full Name"
                  className={`form-control ${
                    errors.fullName ? "is-invalid" : ""
                  }`}
                  value={formData.fullName}
                  onChange={(e) => handleChange("fullName", e.target.value)}
                />
                {errors.fullName && (
                  <div className="invalid-feedback">{errors.fullName}</div>
                )}
              </div>
              <div className="form-group">
                <label className="form-label">Email</label>
                <input
                  type="text"
                  placeholder="Enter Email"
                  className={`form-control ${errors.email ? "is-invalid" : ""}`}
                  value={formData.email}
                  onChange={(e) => handleChange("email", e.target.value)}
                />
                {errors.email && (
                  <div className="invalid-feedback">{errors.email}</div>
                )}
              </div>
              <div className="form-group">
                <label className="form-label">Mobile No</label>
                <input
                  type="text"
                  placeholder="Enter Mobile Number"
                  className={`form-control ${
                    errors.mobileNo ? "is-invalid" : ""
                  }`}
                  value={formData.mobileNo}
                  onChange={(e) => handleChange("mobileNo", e.target.value)}
                />
                {errors.mobileNo && (
                  <div className="invalid-feedback">{errors.mobileNo}</div>
                )}
              </div>
              <div className="form-group">
                <label className="form-label">Gender</label>
                <select
                  className={`form-control ${
                    errors.gender ? "is-invalid" : ""
                  }`}
                  value={formData.gender}
                  onChange={(e) => handleChange("gender", e.target.value)}
                >
                  <option value="" disabled>
                    Select Gender
                  </option>
                  <option value="male">Male</option>
                  <option value="female">Female</option>
                  <option value="other">Other</option>
                </select>
                {errors.gender && (
                  <div className="invalid-feedback">{errors.gender}</div>
                )}
              </div>
              <div className="form-group">
                <label className="form-label">Date of Birth</label>
                <div style={{ display: "flex", gap: "10px" }}>
                  <select
                    value={formData.year}
                    onChange={handleYearChange}
                    className="form-control"
                  >
                    {renderYearOptions()}
                  </select>
                  <DatePicker
                    selected={formData.dob}
                    onChange={handleDateChange}
                    className="form-control"
                    placeholderText="Enter dob"
                    dateFormat="MM/dd"
                    showMonthDropdown
                    showDayDropdown
                    dropdownMode="select"
                  />
                </div>
              </div>
              <div className="form-group">
                <label className="form-label">Marital Status</label>
                <input
                  type="text"
                  placeholder="Enter Marital status"
                  className={`form-control ${
                    errors.maritalStatus ? "is-invalid" : ""
                  }`}
                  value={formData.maritalStatus}
                  onChange={(e) =>
                    handleChange("maritalStatus", e.target.value)
                  }
                />
                {errors.maritalStatus && (
                  <div className="invalid-feedback">{errors.maritalStatus}</div>
                )}
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PersonalDetailsComponent;
