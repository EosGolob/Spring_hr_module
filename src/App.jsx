import { useState } from 'react'
import './App.css'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import { BrowserRouter, Route, Routes ,Navigate} from 'react-router-dom'
import EmployeeCreateComponent from './components/EmployeeCreateComponent'
import EmployeeCreatePageComponent from './components/EmployeeCreatePageComponent'
import UserRegisterComponent from './components/UserRegisterComponent'
import EmployeeProcessSelection from './components/EmployeeProcessSelection'
import EmployeeTable from './components/EmployeeTable'
import HrInterviewResponse from './components/HrInterviewResponse'
import MrInterviewResponse from './components/MrInterviewResponse'
import LoginPage from './components/auth/LoginPage'
import ProfilePage from './components/userspage/ProfilePage'
import RegistrationPage from './components/auth/RegistrationPage'
import UserManagementPage from './components/userspage/UserManagementPage'
import UpdateUser from './components/userspage/UpdateUser'
import UsersService from './services/UsersService'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <BrowserRouter>
    {/* <Routes> */}
      
      {/* <Route path="/" element={<ListEmployeeComponent/>} /> */}
      {/* <Route path="/register" element={<UserRegisterComponent/>} />
      <Route path='/add-employee' element = {<EmployeeCreateComponent/>}></Route>
      <Route path = '/edit-employee/:id' element = {<EmployeeCreateComponent/>}></Route>
      <Route path='/add-employee2' element = {<EmployeeCreatePageComponent/>}></Route>
      <Route path = '/process-Selection' element = {<EmployeeProcessSelection/>}></Route>
      <Route path = '/xyx' element ={<EmployeeTable></EmployeeTable>}></Route>
      <Route path = '/hr-Scheduled' element = {<HrInterviewResponse/>}></Route>
      <Route path = '/mrpage' element = {<MrInterviewResponse/>}></Route>
      <Route path ='/'  element = {<LoginPage/>}></Route> */}

       <Routes>
            <Route exact path="/" element={<LoginPage />} />
            <Route exact path="/login" element={<LoginPage />} />
            <Route path="/profile" element={<ProfilePage />} />
            <Route path = '/process-Selection' element = {<EmployeeProcessSelection/>}></Route>

            {/* Check if user is authenticated and admin before rendering admin-only routes */}
            {UsersService.adminOnly() && (
              <>
                <Route path="/register" element={<RegistrationPage />} />
                <Route path="/admin/user-management" element={<UserManagementPage />} />
                <Route path = "/admin/process-Selection" element = {<EmployeeProcessSelection/>}></Route>
                <Route path="/update-user/:userId" element={<UpdateUser />} />
              </>
            )}
            <Route path="*" element={<Navigate to="/login" />} />‰
          </Routes>
     
    {/* </Routes> */}
    </BrowserRouter>
    </>
  )
}

export default App
