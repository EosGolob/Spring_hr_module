import React from 'react'

const EducationalDetailsComponent= ({formData ,errors}) => {
  return (
    <div>
      <form>
      <div className="form-group">
                <label className="form-label">Qualification</label>
                <input
                  type="text"
                  placeholder="Enter qualification"
                  className={`form-control ${errors.qualification} ?'is-invalid':''}`}
                  value={formData.qualification}
                  onChange={(e) => setQualification(e.target.value)}
                />
                {errors.qualification && (
                  <div className="invalid-feedback">{errors.qualification}</div>
                )}
              </div>
              <div className="form-group">
                <label className="form-label">Previous Organisation</label>
                <input
                  type="text"
                  placeholder="Enter Previous Organisation"
                  className={`form-control ${errors.previousOrganisation} ?'is-invalid':''}`}
                  value={formData.previousOrganisation}
                  onChange={(e) => setPreviousOrganisation(e.target.value)}
                />
                {errors.previousOrganisation && (
                  <div className="invalid-feedback">
                    {errors.previousOrganisation}
                  </div>
                )}
              </div>
              <div className="form-group">
                <label className="form-label">Languages</label>
                <input
                  type="text"
                  placeholder="Enter languages"
                  className={`form-control ${errors.languages} ?'is-invalid':''}`}
                  value={formData.languages}
                  onChange={(e) => setLanguages(e.target.value)}
                />
                {errors.languages && (
                  <div className="invalid-feedback">{errors.languages}</div>
                )}
              </div>
              <div className="form-group">
                <label className="form-label">Total Experience</label>
                <input
                  type="text"
                  placeholder="Enter Total Experience"
                  className={`form-control ${errors.experience} ?'is-invalid':''}`}
                  value={formData.experience}
                  onChange={(e) => setExperience(e.target.value)}
                />
                {errors.experience && (
                  <div className="invalid-feedback">{errors.experience}</div>
                )}
              </div>
      </form>
    </div>
  )
}

export default EducationalDetailsComponent;
