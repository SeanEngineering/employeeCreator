import React from 'react';
import style from './EmployeeDetails.module.scss';

const EmployeeDetails = () => {
    const personal:Array<string> = ['First name', 'Middle name (if applicable)', 'Last name'];
    const contact:Array<string> = ['Email address', 'Mobile number', 'Residential address'];

    return (
        <form>
            <section>
                <h3>Personal information</h3>
                {personal.map(item => {
                    let tag = item.split(' ')[0].toLowerCase();
                    return (<div>
                        <label htmlFor={tag}>{item}</label>
                        <input type="text" name={tag} id={tag}/>
                    </div>)
                })}
            </section>
            <section>
                <h3>Contact details</h3>
                {contact.map(item => {
                   let tag = item.split(' ')[0].toLowerCase();
                   return (<div>
                       <label htmlFor={tag}>{item}</label>
                       <input type="text" name={tag} id={tag}/>
                   </div>)
               })}
            </section>
            <section>
                <h3>Employee status</h3>
                <form action="">
                    <input type="radio" name='permanent'/>
                    <label htmlFor="permanent">Permanent</label>
                    <input type="radio" name='contract'/>
                    <label htmlFor="contract">Contract</label>
                </form>
               <label htmlFor="startDate">Start date</label>
                <input type="date" name='startDate' id='startDate'/>
                <label htmlFor='endDate'>End date</label>
                <input type="date" name='endDate' id='endDate'/>
                <input type="checkbox" name='ongoing' id='ongoing'/>
                <label htmlFor="ongoing">On going</label>
                <div>
                    <h5>Is this on a full-time or part-time basis?</h5>
                    <input type="radio" name='fulltime' id='fulltime'/>
                    <label htmlFor="fulltime">Full-time</label>
                    <input type="radio" name='parttime' id='parttime'/>
                    <label htmlFor="parttime">Part-time</label>
                    <label htmlFor="hoursPerWeek">Hourse per week</label>
                    <input type="number" name='hoursPerWeek' id='hoursPerWeek'/>
                </div>
            </section>
            <button>Save</button>
            <button>Cancel</button>
        </form>
    );
};

export default EmployeeDetails;