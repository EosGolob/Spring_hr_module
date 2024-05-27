import React, { useEffect, useState } from 'react'
import { creatEmployee ,getEmployee,updateEmployee} from '../services/EmployeeService'
import { useNavigate ,useParams} from 'react-router-dom'
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
    const [previousOrganisation, setPreviousOrganisation] = useState('')
    const [dob, setDob] = useState(null)
    const [maritalStatus, setMaritalStatus] = useState('')
    const [refferal, setRefferal] = useState('')
    const [year, setYear] = useState(new Date().getFullYear());

    const {id} = useParams ();

    const [errors, setErrors] = useState({
        fullName: '',
        email: '',
        jobProfile: '',
        qualification: '',
        mobileNo: '',
        permanentAddress: '',
        currentAddress: '',
        gender: '',
        previousOrganisation: '',
        maritalStatus: '',
        refferal: '',
        year: new Date().getFullYear()
    })

    const navigator = useNavigate();

    useEffect (()=>{
        if(id){
            getEmployee(id).then((response) => {
                setFirstName(response.data.fullName);
                setEmail(response.data.email);
                setJobProfile(response.data.jobProfile);
                setQualification(response.data.qualification);
                setMobileNo(response.data.mobileNo);
                setPermanentAddress(response.data.permanentAddress);
                setCurrentAddress(response.data.currentAddress);
                setGender(response.data.gender);
                setPreviousOrganisation(response.data.previousOrganisation);
                setMaritalStatus(response.data.maritalStatus);
                setRefferal(response.data.refferal);
                setDob(response.data.dob);
                setYear(response.data.year);
                }).catch(error => {
                    console.error(error)
                })
        }
    },[id])

    function saveOrUpdateEmployee(e) {
        e.preventDefault();
        if(validateForm()){
            const employee = {
                fullName, email, jobProfile,
                qualification, mobileNo, permanentAddress, currentAddress, gender,
                previousOrganisation, dob, maritalStatus, refferal
            }
            if(id){
                updateEmployee(id, employee).then((response) => {
                    console.log(response.data);
                    navigator('/')
                }).catch(error => {
                    console.error(error)
                })
            }else{
                creatEmployee(employee).then((response) => {
                    console.log(response.data);
                    navigator('/')
            }).catch(error => {
                console.error(error);
            })
        }
    }
           
          
        
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

    function validateForm() {
        let isValid = true;

        const errorsCopy = { ...errors };
        if (fullName.trim()) {
            errorsCopy.fullName = '';
        } else {
            errorsCopy.fullName = 'Name is required';
            isValid = false;
        }
        if (email.trim()) {
            errorsCopy.email = '';
        } else {
            errorsCopy.email = 'Email is required';
            isValid = false;
        }
        if (jobProfile.trim()) {
            errorsCopy.jobProfile = '';
        } else {
            errorsCopy.jobProfile = 'Job Profile is required';
            isValid = false;
        }
        // if (mobileNo.trim()) {
        //     errorsCopy.mobileNo = '';
        // } else {
        //     errorsCopy.mobileNo = 'Mobile No is required';
        //     isValid = false;
        // }
        if (permanentAddress.trim()) {
            errorsCopy.permanentAddress = '';
        } else {
            errorsCopy.permanentAddress = 'Permanent Address is required';
            isValid = false;
        }
        if (currentAddress.trim()) {
            errorsCopy.currentAddress = '';
        } else {
            errorsCopy.currentAddress = 'Current Address  is required';
            isValid = false;
        }
        if (gender.trim()) {
            errorsCopy.gender = '';
        } else {
            errorsCopy.gender = 'Gender is required';
            isValid = false;
        }
        if (previousOrganisation.trim()) {
            errorsCopy.previousOrganisation = '';
        } else {
            errorsCopy.previousOrganisation = 'Previous Organisation No is required';
            isValid = false;
        }
        if (maritalStatus.trim()) {
            errorsCopy.maritalStatus = '';
        } else {
            errorsCopy.maritalStatus = 'Marital Status No is required';
            isValid = false;
        }

        if (refferal.trim()) {
            errorsCopy.refferal = '';
        } else {
            errorsCopy.refferal = 'Refferal is required';
            isValid = false;
        }
        setErrors(errorsCopy);
        return isValid;
    };
    function pageTitle(){
      if(id){
        return <h2 className='text-center'>update Employee</h2>
      }else{
        return <h2 className='text-center'>Add Employee</h2>
      }
    }
        return (
            <div className='container'>
                <br></br>
                <div className='row'>
                    <div className='card col-md-6 offset-md-3 offset-md-3'>
                        {/* <h2 className='text-center'>REGISTER FORM</h2> */}
                        {
                            pageTitle()
                        }
                        <div className='card-body'>
                            <form>
                                <div className='form-group'>
                                    <label className='form-label'>Full Name</label>
                                    <input type='text'
                                        placeholder='Enter Full Name'
                                        className={`form-control ${errors.fullName} ?'is-invalid':''}`}
                                        value={fullName}
                                        onChange={(e) => setFirstName(e.target.value)} />
                                        {errors.fullName &&<div className = 'invalid-feedback'>{errors.fullName}</div>}
                                </div>
                                <div className='form-group'>
                                    <label className='form-label'>Email</label>
                                    <input type='text'
                                        placeholder='Enter Email'
                                        className={`form-control ${errors.email} ?'is-invalid':''}`}
                                        value={email}
                                        onChange={(e) => setEmail(e.target.value)} />
                                        {errors.email &&<div className = 'invalid-feedback'>{errors.email}</div>}
                                </div>
                                <div className='form-group'>
                                    <label className='form-label'>Job Profile</label>
                                    <input type='text'
                                        placeholder='job profile is required'
                                        className={`form-control ${errors.jobProfile} ?'is-invalid':''}`}
                                        value={jobProfile}
                                        onChange={(e) => setJobProfile(e.target.value)} />
                                        {errors.jobProfile &&<div className = 'invalid-feedback'>{errors.jobProfile}</div>}
                                </div>
                                <div className='form-group'>
                                    <label className='form-label'>Qualification</label>
                                    <input type='text'
                                        placeholder='Enter qualification'
                                        className={`form-control ${errors.qualification} ?'is-invalid':''}`}
                                        value={qualification}
                                        onChange={(e) => setQualification(e.target.value)} />
                                        {errors.qualification && <div className = 'invalid-feedback'>{errors.qualification}</div>}
                                </div>
                                <div className='form-group'>
                                    <label className='form-label'>Mobile No</label>
                                    <input type='text'
                                        placeholder='Enter Full Name'
                                        className={`form-control ${errors.mobileNo} ?'is-invalid':''}`}
                                        value={mobileNo}
                                        onChange={(e) => setMobileNo(e.target.value)} />
                                        {errors.mobileNo &&<div className = 'invalid-feedback'>{errors.mobileNo}</div>}
                                </div>
                                <div className='form-group'>
                                    <label className='form-label'>Permanent Address</label>
                                    <input type='text'
                                        placeholder='Enter Permanent Address'
                                        className={`form-control ${errors.permanentAddress} ?'is-invalid':''}`}
                                        value={permanentAddress}
                                        onChange={(e) => setPermanentAddress(e.target.value)} />
                                        {errors.permanentAddress &&<div className = 'invalid-feedback'>{errors.permanentAddress}</div>}
                                </div>
                                <div className='form-group'>
                                    <label className='form-label'>Current Address</label>
                                    <input type='text'
                                        placeholder='Enter Current Address'
                                        className={`form-control ${errors.currentAddress} ?'is-invalid':''}`}
                                        value={currentAddress}
                                        onChange={(e) => setCurrentAddress(e.target.value)} />
                                        {errors.currentAddress &&<div className = 'invalid-feedback'>{errors.currentAddress}</div>}
                                </div>
                                <div className='form-group'>
                                    <label className='form-label'>Gender</label>
                                    <input type='text'
                                        placeholder='Enter Gender'
                                        className={`form-control ${errors.gender} ?'is-invalid':''}`}
                                        value={gender}
                                        onChange={(e) => setGender(e.target.value)} />
                                        {errors.gender &&<div className = 'invalid-feedback'>{errors.gender}</div>}
                                </div>
                                <div className='form-group'>
                                    <label className='form-label'>Previous Organisation</label>
                                    <input type='text'
                                        placeholder='Enter Previous Organisation'
                                        className={`form-control ${errors.previousOrganisation} ?'is-invalid':''}`}
                                        value={previousOrganisation}
                                        onChange={(e) => setPreviousOrganisation(e.target.value)} />
                                        {errors.previousOrganisation &&<div className = 'invalid-feedback'>{errors.previousOrganisation}</div>}
                                </div>
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
                                        className={`form-control ${errors.maritalStatus} ?'is-invalid':''}`}                                        value={maritalStatus}
                                        onChange={(e) => setMaritalStatus(e.target.value)} />
                                        {errors.maritalStatus &&<div className = 'invalid-feedback'>{errors.maritalStatus}</div>}
                                </div>
                                <div className='form-group'>
                                    <label className='form-label'>Refferal</label>
                                    <input type='text'
                                        placeholder='Enter Refferal'
                                        className={`form-control ${errors.refferal} ?'is-invalid':''}`}                                        value={refferal}
                                        onChange={(e) => setRefferal(e.target.value)} />
                                        {errors.refferal &&<div className = 'invalid-feedback'>{errors.refferal}</div>}
                                </div>
                                <button className='btn btn-success' onClick={saveOrUpdateEmployee}>Submit</button>

                            </form>
                        </div>
                    </div>
                </div>

            </div>

        )
    }

    export default EmployeeCreateComponent