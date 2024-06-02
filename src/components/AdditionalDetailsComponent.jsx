import React from 'react'

const AdditionalDetailsComponent= ({formData , handleChange}) => {
  return (
    <div>
      <form>
      <div className="form-group">
                <label className="form-label">Job Profile</label>
                <input
                  type="text"
                  placeholder="job profile is required"
                  className={`form-control ${errors.jobProfile} ?'is-invalid':''}`}
                  value={jobProfile}
                  onChange={(e) => setJobProfile(e.target.value)}
                />
                {errors.jobProfile && (
                  <div className="invalid-feedback">{errors.jobProfile}</div>
                )}
              </div>
              <div className="form-group">
                <label className="form-label">Permanent Address</label>
                <input
                  type="text"
                  placeholder="Enter Permanent Address"
                  className={`form-control ${errors.permanentAddress} ?'is-invalid':''}`}
                  value={permanentAddress}
                  onChange={(e) => setPermanentAddress(e.target.value)}
                />
                {errors.permanentAddress && (
                  <div className="invalid-feedback">
                    {errors.permanentAddress}
                  </div>
                )}
              </div>
              <div className="form-group">
                <label className="form-label">Current Address</label>
                <input
                  type="text"
                  placeholder="Enter Current Address"
                  className={`form-control ${errors.currentAddress} ?'is-invalid':''}`}
                  value={currentAddress}
                  onChange={(e) => setCurrentAddress(e.target.value)}
                />
                {errors.currentAddress && (
                  <div className="invalid-feedback">
                    {errors.currentAddress}
                  </div>
                )}
              </div>
              <div className="form-group">
                <label className="form-label">Refferal</label>
                <input
                  type="text"
                  placeholder="Enter Refferal"
                  className={`form-control ${errors.refferal} ?'is-invalid':''}`}
                  value={refferal}
                  onChange={(e) => setRefferal(e.target.value)}
                />
                {errors.refferal && (
                  <div className="invalid-feedback">{errors.refferal}</div>
                )}
              </div>
              <div className="form-group">
                <label className="form-label">Aadhaar Number No</label>
                <input
                  type="text"
                  placeholder="Enter Aadhar No"
                  className={`form-control ${errors.aadhaarNumber} ?'is-invalid':''}`}
                  value={aadhaarNumber}
                  onChange={(e) => setAadhaarNumber(e.target.value)}
                />
                {errors.aadhaarNumber && (
                  <div className="invalid-feedback">{errors.aadhaarNumber}</div>
                )}
              </div>
              <div className="form-group">
                <label className="form-label">Aadhar upload</label>
                <input
                  type="file"
                  id="image"
                  placeholder="select your Aadhar File"
                  className={`form-control ${errors.file ? "is-invalid" : ""}`}
                  onChange={(e) => setFile(e.target.files[0])}
                />
                {errors.file && (
                  <div className="invalid-feedback">{errors.file}</div>
                )}
              </div>
              <div className="form-group">
                <label className="form-label">Source</label>
                <select
                  className={`form-control ${
                    errors.source ? "is-invalid" : ""
                  }`}
                  value={source}
                  onChange={handleSourceChange}
                >
                  <option value="" disabled>
                    Select Source
                  </option>
                  <option value="Vendor">Vendor</option>
                  <option value="Emp Ref">Employee Reference</option>
                  <option value="Social Media">Social Media</option>
                  <option value="Portal">Portal</option>
                  <option value="NGO">NGO</option>
                  <option value="Campus">Campus</option>
                  <option value="Walk In">Walk In</option>
                </select>
                {errors.source && (
                  <div className="invalid-feedback">{errors.source}</div>
                )}

                {source === "Vendor" && (
                  <div className="form-group">
                    <label className="form-label">
                      Sub Source (Name of Vendor)
                    </label>
                    <input
                      type="text"
                      placeholder="Enter Vendor Name"
                      className={`form-control ${
                        errors.subSource ? "is-invalid" : ""
                      }`}
                      value={subSource}
                      onChange={handleSubSourceChange}
                    />
                    {errors.subSource && (
                      <div className="invalid-feedback">{errors.subSource}</div>
                    )}
                  </div>
                )}

                {source === "Emp Ref" && (
                  <div className="form-group">
                    <label className="form-label">
                      Sub Source (Employee Code)
                    </label>
                    <input
                      type="text"
                      placeholder="Enter Employee Code"
                      className={`form-control ${
                        errors.subSource ? "is-invalid" : ""
                      }`}
                      value={subSource}
                      onChange={handleSubSourceChange}
                    />
                    {errors.subSource && (
                      <div className="invalid-feedback">{errors.subSource}</div>
                    )}
                  </div>
                )}
                {source === "Portal" && (
                  <div className="form-group">
                    <label className="form-label">Sub Source (Portal)</label>
                    <input
                      type="text"
                      placeholder="Enter Employee Code"
                      className={`form-control ${
                        errors.subSource ? "is-invalid" : ""
                      }`}
                      value={subSource}
                      onChange={handleSubSourceChange}
                    />
                    {errors.subSource && (
                      <div className="invalid-feedback">{errors.subSource}</div>
                    )}
                  </div>
                )}
                {source === "Social Media" && (
                  <div className="form-group">
                    <label className="form-label">
                      Sub Source (Social Media)
                    </label>
                    <input
                      type="text"
                      placeholder="Enter Employee Code"
                      className={`form-control ${
                        errors.subSource ? "is-invalid" : ""
                      }`}
                      value={subSource}
                      onChange={handleSubSourceChange}
                    />
                    {errors.subSource && (
                      <div className="invalid-feedback">{errors.subSource}</div>
                    )}
                  </div>
                )}
                {source === "NGO" && (
                  <div className="form-group">
                    <label className="form-label">Sub Source (NGO)</label>
                    <input
                      type="text"
                      placeholder="Enter Employee Code"
                      className={`form-control ${
                        errors.subSource ? "is-invalid" : ""
                      }`}
                      value={subSource}
                      onChange={handleSubSourceChange}
                    />
                    {errors.subSource && (
                      <div className="invalid-feedback">{errors.subSource}</div>
                    )}
                  </div>
                )}
                {source === "Campus" && (
                  <div className="form-group">
                    <label className="form-label">Sub Source (Campus)</label>
                    <input
                      type="text"
                      placeholder="Enter Employee Code"
                      className={`form-control ${
                        errors.subSource ? "is-invalid" : ""
                      }`}
                      value={subSource}
                      onChange={handleSubSourceChange}
                    />
                    {errors.subSource && (
                      <div className="invalid-feedback">{errors.subSource}</div>
                    )}
                  </div>
                )}
                {source === "Walk In" && (
                  <div className="form-group">
                    <label className="form-label">Sub Source (Walk In)</label>
                    <input
                      type="text"
                      placeholder="Enter Employee Code"
                      className={`form-control ${
                        errors.subSource ? "is-invalid" : ""
                      }`}
                      value={subSource}
                      onChange={handleSubSourceChange}
                    />
                    {errors.subSource && (
                      <div className="invalid-feedback">{errors.subSource}</div>
                    )}
                  </div>
                )}
              </div>
      </form>
    </div>
  )
}

export default AdditionalDetailsComponent
