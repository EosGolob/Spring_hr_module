import React ,{useEffect, useState} from 'react'
import { listEmployees } from '../services/EmployeeService'
import {useNavigate} from 'react-router-dom'

const ListEmployeeComponent = () => {
    const [ employees,setEmployees] = useState([])
    const navigator = useNavigate();

    useEffect(() => {
        listEmployees().then((response) => {
            setEmployees(response.data);
        }).catch(error => {
            console.error(error)
    })
    },[])

    function addNewEmployee(){
        navigator('/add-employee')

    }
  return (
    <div className='container'>
        <h2 className='text-center'>ListEmployeeComponent</h2>
        <button className='btn btn-primary mb-2' onClick={addNewEmployee}> Add Employee</button>
         <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Job Profile</th>
                <th>Mobile No</th>
                <th>Permanent Address</th>
                <th>Current Address</th>
                <th>Gender</th>
                <th>Previous Organisation</th>           
                </tr>
            </thead>
            <tbody>
                {
                employees.map(employee =>
                    <tr key={employee.id}>
                        <td>{employee.id}</td>
                        <td>{employee.fullName}</td>
                        <td>{employee.email}</td>
                        <td>{employee.jobProfile}</td>
                        <td>{employee.mobileNo}</td>
                        <td>{employee.permanentAddress}</td>
                        <td>{employee.currentAddress}</td>
                        <td>{employee.gender}</td>
                        <td>{employee.previousOrganisation}</td>

                        </tr>)
                }
            </tbody>
         </table>
    </div>
  )
}

export default ListEmployeeComponent