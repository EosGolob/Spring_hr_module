import { useState } from 'react'
import './App.css'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import EmployeeCreateComponent from './components/EmployeeCreateComponent'
import EmployeeCreatePageComponent from './components/EmployeeCreatePageComponent'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <BrowserRouter>
    <Routes>
      
      <Route path="/" element={<ListEmployeeComponent/>} />
      <Route path='/add-employee' element = {<EmployeeCreateComponent/>}></Route>
      <Route path = '/edit-employee/:id' element = {<EmployeeCreateComponent/>}></Route>
      <Route path='/add-employee2' element = {<EmployeeCreatePageComponent/>}></Route>
    </Routes>
    </BrowserRouter>
    </>
  )
}

export default App
