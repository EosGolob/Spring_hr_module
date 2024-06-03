import React from 'react'

const PersonalDetailsComponent = ({formData , handleChange}) => {
  return (
    <div>
      <h2>Personal Details</h2>
      <form>
              <div className="form-group">
                <label className="form-label">Full Name</label>
                <input
                  type="text"
                  placeholder="Enter Full Name"
                  className={`form-control ${errors.fullName} ?'is-invalid':''}`}
                  value={fullName}
                  onChange={(e) => setFirstName(e.target.value)}
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
                  className={`form-control ${errors.email} ?'is-invalid':''}`}
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
                {errors.email && (
                  <div className="invalid-feedback">{errors.email}</div>
                )}
              </div>
              <div className="form-group">
                <label className="form-label">Mobile No</label>
                <input
                  type="text"
                  placeholder="Enter Full Name"
                  className={`form-control ${errors.mobileNo} ?'is-invalid':''}`}
                  value={mobileNo}
                  onChange={(e) => setMobileNo(e.target.value)}
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
                  value={gender}
                  onChange={(e) => setGender(e.target.value)}
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
                    value={year}
                    onChange={handleYearChange}
                    className="form-control"
                  >
                    {renderYearOptions()}
                  </select>
                  <DatePicker
                    selected={dob}
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
                  className={`form-control ${errors.maritalStatus} ?'is-invalid':''}`}
                  value={maritalStatus}
                  onChange={(e) => setMaritalStatus(e.target.value)}
                />
                {errors.maritalStatus && (
                  <div className="invalid-feedback">{errors.maritalStatus}</div>
                )}
              </div>
     </form>
    </div>
  )
}

export default PersonalDetailsComponent;
