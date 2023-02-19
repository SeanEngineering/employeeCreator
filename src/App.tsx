import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import EmployeeList from './components/employeeList/EmployeeList';
import EmployeeDetails from './components/employeeDetails/EmployeeDetails';
import {BrowserRouter, Route, Routes} from 'react-router-dom';

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
      <BrowserRouter>
      <Routes>
        <Route path='/' element={<EmployeeList/>}/>
        <Route path='/employee/:id' element={<EmployeeDetails />}/>
        <Route path='employee/new' element={<EmployeeDetails/>} />
      </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
