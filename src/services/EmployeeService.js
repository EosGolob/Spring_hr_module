import axios from "axios";

const  REST_API_BASE_URL = 'http://localhost:8080/api/employees';
const INTERVIEW_API_BASE_URL = 'http://localhost:8080/api/interviews';

export const listEmployees = () => axios.get(REST_API_BASE_URL);
export const creatEmployee = (employee) => axios.post(REST_API_BASE_URL,employee);
export const getEmployee =(employeeId) => axios.get(REST_API_BASE_URL +'/'+ employeeId);
export const updateEmployee = (employeeId , employee) => axios.put(REST_API_BASE_URL+'/'+employeeId,employee);
export const deleteEmployee = (employeeId,) => axios.delete(REST_API_BASE_URL +'/' + employeeId);
export const updateEmployeeStatus = (employeeId, newStatus) => axios.patch(`${REST_API_BASE_URL}/${employeeId}/status`, null, {
    params: {
      newStatus
    }
  });
  // New methods for handling interview processes
export const scheduleInterview = (employeeId, interviewDetails) => {
  return axios.post(`${INTERVIEW_API_BASE_URL}/${employeeId}/interviews`, interviewDetails);
};

export const listInterviewsByEmployeeId = (employeeId) => {
  return axios.get(`${INTERVIEW_API_BASE_URL}/${employeeId}/interviews`);
};
export const creatEmployee2 = (employeeDto) => {
  const formData = new FormData();
  // formData.append(
  //   "image",
  //   new Blob([JSON.stringify(employeeDto)], { type: "application/json" })
  // );
  formData.append("image", new Blob([JSON.stringify(employeeDto)], { type: "application/json" }));

  return axios.post(REST_API_BASE_URL, formData, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  });
};