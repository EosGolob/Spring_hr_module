import React, { useState } from 'react'
import { creatEmployee } from '../services/EmployeeService'
import { useNavigate } from 'react-router-dom'
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
const EmployeeCreateComponent = () => {

    const [fullName, setFirstName] = useState('')
    const [email, setEmail] = useState('')
    const [jobProfile, setJobProfile] = useState('')
    const [qualification, setQualification] = useState('')
    const [mobileNo, setMobileNo] = useState('')
    const [permanentAddress, setPermanentAddress] = useState('')
    const [currentAddress, setCurrentAddress] = useState('')
    const [gender, setGender] = useState('')
    const [previousOrganisation ,setPreviousOrganisation] = useState('')
    const [dob, setDob] = useState('')
    const [maritalStatus, setMaritalStatus] = useState('')
    const [refferal, setRefferal] = useState('')
    const [year, setYear] = useState(new Date().getFullYear());

    const navigator = useNavigate();
    function saveEmployee(e){
        e.preventDefault();
        const employee = { fullName, email,jobProfile,
            qualification,mobileNo,permanentAddress,currentAddress,gender,
            previousOrganisation,dob,maritalStatus,refferal}
            console.log(employee);
            creatEmployee(employee).then((response) => {
                console.log(response.data);
                navigator('/')
            })
        }
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
            return years.map(year => (
                <option key={year} value={year}>{year}</option>
            ));
        };
    return (
        <div className='container'>
            <br></br>
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    <h2 className='text-center'>REGISTER FORM</h2>
                    <div className='card-body'>
                        <form>
                            <div className='form-group'>
                                <label className='form-label'>Full Name</label>
                                <input type='text' 
                                placeholder='Enter Full Name'
                                className='form-control'
                                 value={fullName} 
                                 onChange={(e) => setFirstName(e.target.value)} />
                            </div>
                            <div className='form-group'>
                                <label className='form-label'>Email</label>
                                <input type='text' 
                                placeholder='Enter Email'
                                className='form-control'
                                 value={email} 
                                 onChange={(e) => setEmail(e.target.value)} />
                            </div>
                            <div className='form-group'>
                                <label className='form-label'>Job Profile</label>
                                <input type='text' 
                                placeholder='Enter Full Name'
                                className='form-control'
                                 value={jobProfile} 
                                 onChange={(e) => setJobProfile(e.target.value)} />
                            </div>
                            <div className='form-group'>
                                <label className='form-label'>Qualification</label>
                                <input type='text' 
                                placeholder='Enter qualification'
                                className='form-control'
                                 value={qualification} 
                                 onChange={(e) => setQualification(e.target.value)} />
                            </div>
                            <div className='form-group'>
                                <label className='form-label'>Mobile No</label>
                                <input type='text' 
                                placeholder='Enter Full Name'
                                className='form-control'
                                 value={mobileNo} 
                                 onChange={(e) => setMobileNo(e.target.value)} />
                            </div>
                            <div className='form-group'>
                                <label className='form-label'>Permanent Address</label>
                                <input type='text' 
                                placeholder='Enter Full Name'
                                className='form-control'
                                 value={permanentAddress} 
                                 onChange={(e) => setPermanentAddress(e.target.value)} />
                            </div>
                            <div className='form-group'>
                                <label className='form-label'>Current Address</label>
                                <input type='text' 
                                placeholder='Enter Current Address'
                                className='form-control'
                                 value={currentAddress} 
                                 onChange={(e) => setCurrentAddress(e.target.value)} />
                            </div>
                            <div className='form-group'>
                                <label className='form-label'>Gender</label>
                                <input type='text' 
                                placeholder='Enter Gender'
                                className='form-control'
                                 value={gender} 
                                 onChange={(e) => setGender(e.target.value)} />
                            </div>
                            <div className='form-group'>
                                <label className='form-label'>Previous Organisation</label>
                                <input type='text' 
                                placeholder='Enter Previous Organisation'
                                className='form-control'
                                 value={previousOrganisation} 
                                 onChange={(e) => setPreviousOrganisation(e.target.value)} />
                            </div>
                            {/* <div className='form-group'>
                                <label className='form-label'>Date of Birth</label>
                                <input type='text' 
                                placeholder='Enter dob'
                                className='form-control'
                                 value={dob} 
                                 onChange={(e) => setDob(e.target.value)} />
                            </div> */}
            <div className='form-group'>
            <label className='form-label'>Date of Birth</label>
            <div style={{ display: 'flex', gap: '10px' }}>
                <select
                    value={year}
                    onChange={handleYearChange}
                    className='form-control'
                >
                    {renderYearOptions()}
                </select>
                <DatePicker
                    selected={dob}
                    onChange={handleDateChange}
                    className='form-control'
                    placeholderText='Enter dob'
                    dateFormat='MM/dd'
                    showMonthDropdown
                    showDayDropdown
                    dropdownMode="select"
                />
            </div>
        </div>
                            <div className='form-group'>
                                <label className='form-label'>Marital Status</label>
                                <input type='text' 
                                placeholder='Enter Marital status'
                                className='form-control'
                                 value={maritalStatus} 
                                 onChange={(e) => setMaritalStatus(e.target.value)} />
                            </div>
                            <div className='form-group'>
                                <label className='form-label'>Refferal</label>
                                <input type='text' 
                                placeholder='Enter Refferal'
                                className='form-control'
                                 value={refferal} 
                                 onChange={(e) => setRefferal(e.target.value)} />
                            </div>
                            <button className='btn btn-success' onClick={saveEmployee}>Submit</button>

                        </form>
                    </div>
                </div>
            </div>

        </div>

    )
}

export default EmployeeCreateComponent