// EmployeeCreatePages.jsx (Parent Component)
import React, { useState } from "react";
import PersonalDetailsComponent from "./PersonalDetailsComponent";
import EducationalDetailsComponent from "./EducationalDetailsComponent";
import AdditionalDetailsComponent from "./AdditionalDetailsComponent";
import { creatEmployee } from "../services/EmployeeService";

const EmployeeCreatePageComponent = () => {
  const [formData, setFormData] = useState({
    fullName: "",
    email: "",
    jobProfile: "",
    qualification: "",
    mobileNo: "",
    permanentAddress: "",
    currentAddress: "",
    gender: "",
    previousOrganisation: "",
    dob: null,
    maritalStatus: "",
    refferal: "",
    year: new Date().getFullYear(),
    file: null,
    source: "",
    subSource: "",
  });
  const [errors, setErrors] = useState({
    fullName: "",
    email: "",
    jobProfile: "",
    qualification: "",
    mobileNo: "",
    permanentAddress: "",
    currentAddress: "",
    gender: "",
    previousOrganisation: "",
    dob: "",
    maritalStatus: "",
    refferal: "",
    year: "",
    file: "",
    source: "",
    subSource: "",
  });
  const [currentPage, setCurrentPage] = useState(1);

  const handleChange = (field, value) => {
    setFormData((prevFormData) => ({
      ...prevFormData,
      [field]: value,
    }));
  };

  const nextPage = () => {
    setCurrentPage((prevPage) => prevPage + 1);
  };

  const previousPage = () => {
    setCurrentPage((prevPage) => prevPage - 1);
  };

  const saveEmployee = () => {
    // Perform form submission logic
    creatEmployee(formData)
      .then((response) => {
        console.log(response.data);
        // Redirect or navigate to another page
      })
      .catch((errors) => {
        console.errors(errors);
      });
  };

  const handleDateChange = (date) => {
    if (date) {
      const updatedDate = new Date(date);
      updatedDate.setFullYear(year);
      setDob(updatedDate);
    }
  };

  const handleYearChange = (event) => {
    const newYear = parseInt(event.target.value, 10);
    setYear(newYear);
    if (dob) {
      const updatedDate = new Date(dob);
      updatedDate.setFullYear(newYear);
      setDob(updatedDate);
    }
  };

  const renderYearOptions = () => {
    const years = [];
    const startYear = new Date().getFullYear() - 100;
    const endYear = new Date().getFullYear() + 10;
    for (let i = startYear; i <= endYear; i++) {
      years.push(i);
    }
    return years.map((year) => (
      <option key={year} value={year}>
        {year}
      </option>
    ));
  }
  const handleSourceChange = (e) => {
    setSource(e.target.value);
    setSubSource(""); // Reset subSource when source changes
  };

  const handleSubSourceChange = (e) => {
    setSubSource(e.target.value);
  };

  return (
    <div>
      {currentPage === 1 && (
        <PersonalDetailsComponent
          formData={formData}
          handleChange={handleChange}
          handleYearChange={handleYearChange}
          renderYearOptions={renderYearOptions}
          handleDateChange = {handleDateChange}
          
          errors={errors}
        />
      )}
      {currentPage === 2 && (
        <EducationalDetailsComponent
          formData={formData}
          handleChange={handleChange}
          errors={errors}
        />
      )}
      {currentPage === 3 && (
        <AdditionalDetailsComponent
          formData={formData}
          handleChange={handleChange}
          errors={errors}
          handleSourceChange={handleSourceChange}
          // handleSubSourceChange={handleSubSourceChange}
        />
      )}
      {currentPage > 1 && (
        <button onClick={previousPage}>Previous</button>
      )}
      {currentPage < 3 ? (
        <button onClick={nextPage}>Next</button>
      ) : (
        <button onClick={saveEmployee}>Submit</button>
      )}
    </div>
  );
};

export default EmployeeCreatePageComponent;
