import React, { useEffect, useState } from 'react';
import style from './EmployeeList.module.scss';
import axios, {AxiosResponse} from 'axios';
import { NavLink, useNavigate } from 'react-router-dom';

const EmployeeList = () => {
    const employees:Array<any> = ['Bob', 'Darrel', 'James']
    const [data, setData] = useState([]);
    const navigate = useNavigate();
    const [employeeDeleted, setEmployeeDeleted] = useState(false);

    useEffect(() => {
               axios.get('http://localhost:8080/employees').then(response => {
                    setData(response.data); 
                    console.log(response.data);
                }).catch((err) => {console.log(err)});
    }, [employeeDeleted]);

    const changeNavigate = (e: Event, id: string) => {
        e.preventDefault;
            navigate(`/employee/${id}`);
    }

    const deleteEmployee = (e: Event, id: string) => {
        e.preventDefault;
        axios.delete(`http://localhost:8080/employees/${id}`).then(() => {setEmployeeDeleted(!employeeDeleted)});
    }
    return (
        <div className={style.main}>
            <div className={style.descriptor}>
                <p>Please click on 'Edit' to find more details of each employee.</p>
                <button onClick={(e) => changeNavigate('click', 'new')}>Add employee</button>

            </div>
            <div className={style.list}>
                {data.map(employee => {
                    return (
                    <div className={style.card}>
                        <section className={style.card__details}>
                            <h5>{`${employee.firstName}${employee.middleName ? ` ${employee.middleName} ` : ' '}${employee.lastName}`}</h5>
                            <p>{employee.permanent? 'Permanent' : 'Contract'}</p>
                            <p>{employee.email}</p>
                        </section>
                        <section className={style.card__options}>
                            <p onClick={(e) => {changeNavigate('click', employee.id)}}>Edit</p>
                            <p onClick={(e) => {deleteEmployee('click', employee.id)}}>Remove</p>
                        </section>
                    </div>);
                })}
            </div>
        </div>
      
    );
};

export default EmployeeList;