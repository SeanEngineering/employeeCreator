import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import EmployeeList from './components/employeeList/EmployeeList';
import EmployeeDetails from './components/employeeDetails/EmployeeDetails';

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
      <EmployeeList />
      <EmployeeDetails />
    </div>
  )
}

export default App
