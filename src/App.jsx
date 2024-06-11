import { useState } from 'react'
import './App.css'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import EmployeeCreateComponent from './components/EmployeeCreateComponent'
import EmployeeCreatePageComponent from './components/EmployeeCreatePageComponent'
import UserRegisterComponent from './components/UserRegisterComponent'
import EmployeeProcessSelection from './components/EmployeeProcessSelection'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <BrowserRouter>
    <Routes>
      
      <Route path="/" element={<ListEmployeeComponent/>} />
      <Route path="/register" element={<UserRegisterComponent/>} />
      <Route path='/add-employee' element = {<EmployeeCreateComponent/>}></Route>
      <Route path = '/edit-employee/:id' element = {<EmployeeCreateComponent/>}></Route>
      <Route path='/add-employee2' element = {<EmployeeCreatePageComponent/>}></Route>
      <Route path = '/process-Selection' element = {<EmployeeProcessSelection/>}></Route>
    </Routes>
    </BrowserRouter>
    </>
  )
}

export default App
