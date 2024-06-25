import axios from "axios";
const REST_API_BASE_URL = 'http://localhost:8080/api/employees';

const axiosInstance = axios.create({
    baseURL: REST_API_BASE_URL,
  })


  const isAuthenticated = () => {
    const token = localStorage.getItem('token');
    return !!token; // Double negation to convert to boolean
};

  const authConfig = () => {
    const token = localStorage.getItem('token');
    return{
    headers: {
      Authorization: `Bearer ${token}`,
      'Content-Type': 'application/json',
    },
  };
};

  export const listEmployees = (token) => {
    return axiosInstance.get('/getAllEmp', authConfig());
  };
// class EmployeeServiceJWT{
//     static Base_URL = 'http://localhost:8080/api/employees';

//     static async listofemployeeonprocesspage(userData ,token){
//       try{
//         const response = await axios.get(`${EmployeeServiceJWT.Base_URL}/getAllEmp`,userData,
//           {
//             headers: {Authorization:`Bearer ${token}`}
//           })
//           return response.data;
//         }catch(err){
//           throw err;
//         }
//       }
    
//     static isAuthenticated(){
//         const token =  localStorage.getItem('token') 
//         return !! token
//     }

//     static isAdmin(){
//         const role =  localStorage.getItem('role') 
//         return role === 'ADMIN'
//     }

//     static isUser(){
//         const role =  localStorage.getItem('role') 
//         return role === 'USER'
//     }

//     static adminOnly(){
        
//         return this.isAuthenticated() && this.isAdmin();
//     }
// }
// export default EmployeeServiceJWT;