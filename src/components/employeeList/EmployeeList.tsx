import React from 'react';
import style from './EmployeeList.module.scss';

const EmployeeList = () => {
    const employees:Array<any> = ['Bob', 'Darrel', 'James']

    return (
        <div className={style.main}>
            <div className={style.descriptor}>
                <p>Please click on 'Edit' to find more details of each employee.</p>
                <button>Add employee</button>

            </div>
            <div className={style.list}>
                {employees.map(employee => {
                    return (
                    <div className={style.card}>
                        <section className={style.card__details}>
                            <h5>{employee}</h5>
                            <p>Contract - 2 yrs</p>
                            <p>email@email.com</p>
                        </section>
                        <section className={style.card__options}>
                            <p>Edit</p>
                            <p>Remove</p>
                        </section>
                    </div>);
                })}
            </div>
        </div>
      
    );
};

export default EmployeeList;