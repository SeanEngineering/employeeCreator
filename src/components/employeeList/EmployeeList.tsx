import React, { useEffect, useState } from 'react';
import style from './EmployeeList.module.scss';
import axios, {AxiosResponse} from 'axios';
import { NavLink, useNavigate } from 'react-router-dom';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';

const EmployeeList = () => {
    const navigate = useNavigate();
    const queryClient = useQueryClient();

    const employeeList = useQuery({
        queryKey: ["employees"],
        queryFn: () => axios.get('http://localhost:8080/employees')
    })
    const deleteMutation = useMutation({
        mutationFn: id => {
            return axios.delete(`http://localhost:8080/employees/${id}`);
        },
        onSuccess: () => {
            queryClient.invalidateQueries(["employees"]);
        }
    })

    if(employeeList.isLoading) return <h1>Loading</h1>
    if(employeeList.error) return <h1>Could not retrieve data</h1>

    const changeNavigate = (e: Event, id: string) => {
        e.preventDefault;
            navigate(`/employee/${id}`);
    }

    return (
        <div className={style.main}>
            <div className={style.descriptor}>
                <p>Please click on 'Edit' to find more details of each employee.</p>
                <button onClick={(e) => changeNavigate('click', 'new')}>Add employee</button>

            </div>
            <div className={style.list}>
                {employeeList.data?.data.map((employee: { firstName: any; middleName: any; lastName: any; permanent: any; email: string | number | boolean | React.ReactElement<any, string | React.JSXElementConstructor<any>> | React.ReactFragment | React.ReactPortal | null | undefined; id: string | void; }) => {
                    return (
                    <div className={style.card}>
                        <section className={style.card__details}>
                            <h5>{`${employee.firstName}${employee.middleName ? ` ${employee.middleName} ` : ' '}${employee.lastName}`}</h5>
                            <p>{employee.permanent? 'Permanent' : 'Contract'} </p>
                            <p>{employee.email}</p>
                        </section>
                        <section className={style.card__options}>
                            <p onClick={(e) => {changeNavigate('click', employee.id)}}>Edit</p>
                            <p onClick={(e) => deleteMutation.mutate(employee.id)}>Remove</p>
                        </section>
                    </div>);
                })}
            </div>
        </div>
      
    );
};

export default EmployeeList;