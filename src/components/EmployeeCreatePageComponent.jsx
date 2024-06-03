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
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <div>
      {currentPage === 1 && (
        <PersonalDetailsComponent
          formData={formData}
          handleChange={handleChange}
        />
      )}
      {currentPage === 2 && (
        <EducationalDetailsComponent
          formData={formData}
          handleChange={handleChange}
        />
      )}
      {currentPage === 3 && (
        <AdditionalDetailsComponent
          formData={formData}
          handleChange={handleChange}
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
