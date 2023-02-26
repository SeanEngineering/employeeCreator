import axios, { AxiosResponse } from 'axios';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';

export const processDate = (date: string) => {
    let [year, month, day] = date.split('-');
    return [parseInt(year), parseInt(month), parseInt(day)];
};

export const recombineDate = (year: number, month: number, day: number) => {
    let dayString: string = `${day}`;
    let monthString: string = `${month}`;
    dayString.length == 1 ? (dayString = `0${day}`) : null;
    monthString.length == 1 ? (monthString = `0${month}`) : null;

    return `${year}-${monthString}-${dayString}`;
};

export const checkEmail = (email: string) => {
    const validator = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(
        email
    );
    return validator;
};

export const deleteUser = async (id: number) => {
    const employee = await axios.delete(
        `http://localhost:8080/employees/${id}`
    );
    return await employee.data;
};

export const getUsers = async () => {
    const employees = await axios.get(`http://localhost:8080/employees`);
    return await employees.data;
};

export const getUserById = async (id: number) => {
    const employee = await axios.get(`http://localhost:8080/employees/${id}`);
};

export const updateUserById = async (id: number, json: string) => {
    const employee = await axios.patch(
        `http://localhost:8080/employees/${id}`,
        json,
        {
            headers: {
                'Content-Type': 'application/json',
            },
        }
    );
    return await employee.data;
};

export const postUser = async (json: string) => {
    const employee = await axios.post(`http://localhost:8080/employees`, json, {
        headers: {
            'Content-Type': 'application/json',
        },
    });
    return await employee.data;
};
